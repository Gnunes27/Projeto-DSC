/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.livraria.dao;
import com.mycompany.livraria.model.Livro;
import com.mycompany.livraria.conexao.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class LivroDao {

    public void cadastrar(Livro livro) {
        String sql = "INSERT INTO Livro (nome, autor, categoria, preco, codigo) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, livro.getNome());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getCategoria());
            stmt.setDouble(4, livro.getPreco());
            stmt.setString(5, livro.getCodigo());

            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível adicionar o livro ao banco de dados! ",e);
        }        
    }
   
    public List<Livro> listarTodos() {
        String sql = "SELECT nome, autor, categoria, preco, codigo FROM Livro";
        List<Livro> listaDeLivros = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Livro livro = new Livro();
                livro.setNome(rs.getString("nome"));
                livro.setAutor(rs.getString("autor"));
                livro.setCategoria(rs.getString("categoria"));
                livro.setPreco(rs.getDouble("preco"));
                livro.setCodigo(rs.getString("codigo"));
               

                listaDeLivros.add(livro);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar os livros no banco de dados! ", e);
        }
        
        return listaDeLivros; 
    }

    public Livro buscar(String codigo) {
        String sql = "SELECT * FROM Livro WHERE codigo = ?";
        
        try (Connection conn = ConnectionFactory.getConnection();
             java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, codigo);  
            
            try (java.sql.ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Livro livro = new Livro();
                    livro.setIdLivro(rs.getInt("id_livro"));
                    livro.setNome(rs.getString("nome"));
                    livro.setAutor(rs.getString("autor"));
                    livro.setCategoria(rs.getString("categoria"));
                    livro.setPreco(rs.getDouble("preco"));
                    livro.setCodigo(rs.getString("codigo"));
                    return livro;
                }
            }
        } catch (java.sql.SQLException e) {
            throw new  RuntimeException("Não foi possível buscar livros no banco de dados!  " , e);
        }
        return null; 
    }
    
    public void excluir(String codigo) {
        String sql = "DELETE FROM Livro WHERE codigo = ?";
        
        try (java.sql.Connection conn = ConnectionFactory.getConnection();
             java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, codigo);
            int linhasAfetadas = stmt.executeUpdate();
            
            if(linhasAfetadas == 0)
                 throw new RuntimeException("Livro não encontrado! ");
        } catch (java.sql.SQLException e) {
            throw new RuntimeException("Não foi possível excluir o livro no banco de dados! ", e);
        }
    }
}