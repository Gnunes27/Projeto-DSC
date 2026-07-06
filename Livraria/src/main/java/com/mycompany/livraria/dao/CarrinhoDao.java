/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.livraria.dao;

import com.mycompany.livraria.model.Carrinho;
import com.mycompany.livraria.conexao.ConnectionFactory;
import java.sql.*;

public class CarrinhoDao {

   
    // Função que procura um carrinho vinculado ao cliente
    public int searchCarrinho(int idUsuario) throws SQLException{
        String sqlBusca = "SELECT id_venda FROM Venda WHERE id_usuario = ? AND status = 'CARRINHO'";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlBusca)) {
            stmt.setInt(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id_venda"); // Retorna o carrinho existente
                }
            }
        }

        // Se não achou, cria um carrinho 
        String sqlCria = "INSERT INTO Venda (id_usuario, valor_total, status) VALUES (?, 0.0, 'CARRINHO')";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmtCria = conn.prepareStatement(sqlCria, Statement.RETURN_GENERATED_KEYS)) {
            stmtCria.setInt(1, idUsuario);
            stmtCria.executeUpdate();
            try (ResultSet rs = stmtCria.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1); // Retorna o ID do novo carrinho
                }
            }
        }
        throw new SQLException("Não foi possível criar uma nova venda/carrinho.");
    }

    /**
     * Chamado toda vez que o cliente clicar no botão "+ Carrinho".
     * Adiciona o livro direto na base de dados.
     */
    public boolean addItem(int idUsuario, int idLivro, int quantidade) {
        try {
            int idVenda = searchCarrinho(idUsuario);

            // Verifica se este livro já foi adicionado a este carrinho antes
            String sqlVerificaItem = "SELECT id_item, quantidade FROM ItemVenda WHERE id_venda = ? AND id_livro = ?";
            boolean itemExiste = false;
            int qtdAtual = 0;

            try (Connection conn = ConnectionFactory.getConnection();
                 PreparedStatement stmtVer = conn.prepareStatement(sqlVerificaItem)) {
                stmtVer.setInt(1, idVenda);
                stmtVer.setInt(2, idLivro);
                try (ResultSet rs = stmtVer.executeQuery()) {
                    if (rs.next()) {
                        itemExiste = true;
                        qtdAtual = rs.getInt("quantidade");
                    }
                }
            }

            if (itemExiste) {
                // Se já existir, apenas soma a nova quantidade
                String sqlUpdateItem = "UPDATE ItemVenda SET quantidade = ? WHERE id_venda = ? AND id_livro = ?";
                try (Connection conn = ConnectionFactory.getConnection();
                     PreparedStatement stmtUpd = conn.prepareStatement(sqlUpdateItem)) {
                    stmtUpd.setInt(1, qtdAtual + quantidade);
                    stmtUpd.setInt(2, idVenda);
                    stmtUpd.setInt(3, idLivro);
                    stmtUpd.executeUpdate();
                }
            } else {
                // Se não existir, insere o livro pela primeira vez no carrinho
                String sqlInsertItem = "INSERT INTO ItemVenda (id_venda, id_livro, quantidade) VALUES (?, ?, ?)";
                try (Connection conn = ConnectionFactory.getConnection();
                     PreparedStatement stmtIns = conn.prepareStatement(sqlInsertItem)) {
                    stmtIns.setInt(1, idVenda);
                    stmtIns.setInt(2, idLivro);
                    stmtIns.setInt(3, quantidade);
                    stmtIns.executeUpdate();
                }
            }

            // Recalcula o valor total da venda consultando o preço dos livros
            valorTotal(idVenda);

            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao adicionar item no banco: " + e.getMessage());
            return false;
        }
    }

    
    private void valorTotal(int idVenda) throws SQLException {
         String sqlTotal = "SELECT SUM(iv.quantidade * l.preco) AS total " +
                          "FROM ItemVenda iv JOIN Livro l ON iv.id_livro = l.id_livro " +
                          "WHERE iv.id_venda = ?";
        double novoTotal = 0.0;
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlTotal)) {
            stmt.setInt(1, idVenda);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    novoTotal = rs.getDouble("total");
                }
            }
        }

        String sqlUpdateTotal = "UPDATE Venda SET valor_total = ? WHERE id_venda = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlUpdateTotal)) {
            stmt.setDouble(1, novoTotal);
            stmt.setInt(2, idVenda);
            stmt.executeUpdate();
        }
    }

    /**
     * Chama este método logo após o Login do cliente!
     * Ele vai no banco, procura se tem carrinho aberto e restaura para a memória.
     */
    public Carrinho restaurarCarrinho(int idUsuario) {
         Carrinho carrinho = new Carrinho();
        // Busca os itens do banco usando JOIN para pegar o nome e preço do livro
        String sql = "SELECT iv.id_livro, l.nome, l.preco, iv.quantidade " +
                     "FROM Venda v " +
                     "JOIN ItemVenda iv ON v.id_venda = iv.id_venda " +
                     "JOIN Livro l ON iv.id_livro = l.id_livro " +
                     "WHERE v.id_usuario = ? AND v.status = 'CARRINHO'";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // Preenche o objeto Carrinho da memória para usar na interface
                    carrinho.adicionarItem(
                        rs.getInt("id_livro"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao restaurar carrinho: " + e.getMessage());
        }
        return carrinho;
    }

   
    public boolean finalizarCompra(int idUsuario) {
        String sql = "UPDATE Venda SET status = 'FINALIZADA', data_venda = CURRENT_TIMESTAMP " +
                     "WHERE id_usuario = ? AND status = 'CARRINHO'";
                     
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idUsuario);
            int linhas = stmt.executeUpdate();
            return linhas > 0; // Retorna true se finalizou com sucesso

        } catch (SQLException e) {
            System.out.println("Erro ao finalizar compra: " + e.getMessage());
            return false;
        }
    
    }
}
