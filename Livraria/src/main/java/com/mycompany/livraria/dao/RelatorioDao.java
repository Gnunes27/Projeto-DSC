/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.livraria.dao;

import com.mycompany.livraria.conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gnunes
 */
public class RelatorioDao {

     // Busca livros vendidos
    public int getTotalLivrosVendidos() {
        String sql = "SELECT SUM(iv.quantidade) AS total_livros "
                + "FROM ItemVenda iv "
                + "JOIN Venda v ON iv.id_venda = v.id_venda "
                + "WHERE v.status = 'FINALIZADA'";

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("total_livros");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar total de livros: " + e.getMessage());
        }
        return 0;
    }
  //Busca o valor total faturado 
    public double getTotalFaturado() {
        String sql = "SELECT SUM(valor_total) AS faturamento "
                + "FROM Venda "
                + "WHERE status = 'FINALIZADA'";

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getDouble("faturamento");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar faturamento: " + e.getMessage());
        }
        return 0.0;
    }
    
     //Busca o livro mais vendido ou menos vendido.
    //Se true, traz o mais vendido. Se false, o menos
    public String getLivrosVendidos(boolean maisVendido) {
        
        String ordem = maisVendido ? "DESC" : "ASC";

        String sql = "SELECT l.nome, SUM(iv.quantidade) AS total_vendido "
                + "FROM ItemVenda iv "
                + "JOIN Venda v ON iv.id_venda = v.id_venda "
                + "JOIN Livro l ON iv.id_livro = l.id_livro "
                + "WHERE v.status = 'FINALIZADA' "
                + "GROUP BY l.id_livro, l.nome "
                + "ORDER BY total_vendido " + ordem + " "
                + "LIMIT 1";

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                String nome = rs.getString("nome");
                int qtd = rs.getInt("total_vendido");
                return nome + " (" + qtd + " unidades)";
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar livro destaque: " + e.getMessage());
        }
        return "Nenhum dado encontrado";
    }

  
    public List<String> getFaturamentoPorMes() {
        List<String> relatorioMeses = new ArrayList<>();

        
        String sql = "SELECT DATE_FORMAT(data_venda, '%m/%Y') AS mes_ano, "
                + "SUM(valor_total) AS total_mes "
                + "FROM Venda "
                + "WHERE status = 'FINALIZADA' "
                + "GROUP BY DATE_FORMAT(data_venda, '%m/%Y'), DATE_FORMAT(data_venda, '%Y-%m') "
                + "ORDER BY DATE_FORMAT(data_venda, '%Y-%m') DESC";

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String mesAno = rs.getString("mes_ano");
                double total = rs.getDouble("total_mes");
                relatorioMeses.add(String.format("Mês %s: R$ %.2f", mesAno, total));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar faturamento por mês: " + e.getMessage());
        }
        return relatorioMeses;
    }

    
    public List<Object[]> getHistoricoVendas() {
        List<Object[]> historico = new ArrayList<>();

        String sql = "SELECT v.id_venda, u.nome AS cliente, v.data_venda, v.valor_total "
                + "FROM Venda v "
                + "JOIN Usuario u ON v.id_usuario = u.id_usuario "
                + "WHERE v.status = 'FINALIZADA' "
                + "ORDER BY v.data_venda DESC";

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                historico.add(new Object[]{
                    rs.getInt("id_venda"),
                    rs.getString("cliente"),
                    rs.getTimestamp("data_venda").toString(), // Formato Data e Hora
                    String.format("R$ %.2f", rs.getDouble("valor_total"))
                });
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar histórico: " + e.getMessage());
        }
        return historico;
    }
}
