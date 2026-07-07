/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.livraria.dao;

import com.mycompany.livraria.model.Pessoa;
import com.mycompany.livraria.conexao.ConnectionFactory;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.*;

public class PessoaDao {

    public void atualizarSaldo(int idUsuario, Double valorPago){
        String sql = "UPDATE usuario SET saldo = saldo - ? WHERE id_usuario = ?";
        
        try (Connection conn = ConnectionFactory.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, valorPago);
            stmt.setInt(2, idUsuario);
            
            int linhasAfetadas = stmt.executeUpdate();
            
            if(linhasAfetadas == 0){
                throw new RuntimeException("Nenhum usuário foi encontrado no banco de dados! ");
            }
            
        } catch(SQLException e){
            throw new RuntimeException("Não foi possível buscar o usuário no banco de dados! ", e);
        }
    }
    
    public boolean cadastrar(Pessoa pessoa) {
        String sql = "INSERT INTO Usuario (nome, email, senha, adm) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEmail());

            String senhaHash = BCrypt.hashpw(pessoa.getSenha(), BCrypt.gensalt());
            stmt.setString(3, senhaHash);

            stmt.setBoolean(4, pessoa.isAdm());

            stmt.execute();
            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
            return false;
        }
    }

    public Pessoa autenticar(String email, String senha) {
        String sql = "SELECT * FROM Usuario WHERE email = ?";

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String hashDoBanco = rs.getString("senha");

                    if (BCrypt.checkpw(senha, hashDoBanco)) {

                        Pessoa usuarioLogado = new Pessoa();
                        usuarioLogado.setIdUsuario(rs.getInt("id_usuario"));
                        usuarioLogado.setNome(rs.getString("nome"));
                        usuarioLogado.setEmail(rs.getString("email"));
                        usuarioLogado.setSenha(hashDoBanco);
                        usuarioLogado.setAdm(rs.getBoolean("adm"));
                        usuarioLogado.setSaldo(rs.getDouble("saldo"));

                        return usuarioLogado;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível autenticar no banco de dados! ", e);
        }

        return null;
    }

    public List<Pessoa> listarTodos() {
        String sql = "SELECT id_usuario, nome, email FROM Usuario";
        List<Pessoa> list = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pessoa p = new Pessoa();
                p.setIdUsuario(rs.getInt("id_usuario"));
                p.setNome(rs.getString("nome"));
                p.setEmail(rs.getString("email"));

                list.add(p);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar os clientes no banco de dados! ", e);
        }

        return list;
    }

    public Pessoa buscar(String id) {
        String sql = "SELECT * FROM Usuario WHERE id_usuario = ?";

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    int iD = rs.getInt("id_usuario");
                    String nome = rs.getString("nome");
                    String email = rs.getString("email");
                    double saldo = rs.getDouble("saldo");
                    boolean adm = rs.getBoolean("adm");

                    Pessoa c = new Pessoa();
                    c.setIdUsuario(iD);
                    c.setNome(nome);
                    c.setEmail(email);
                    c.setSaldo(saldo);
                    c.setAdm(adm);

                    return c;

                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar os clientes no banco de dados! ", e);
        }
        
        return null;
    }
    
    public void excluir(String id) {
        String sql = "DELETE FROM Usuario WHERE id_usuario = ?";
        
        try (java.sql.Connection conn = ConnectionFactory.getConnection();
             java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, id);
            
            stmt.executeUpdate();
            
        } catch (java.sql.SQLException e) {
            throw new RuntimeException("Não foi possível excluir o usuário no banco de dados! ", e);
        }
    }
}
