/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.livraria.dao;

import com.mycompany.livraria.model.Pessoa;
import com.mycompany.livraria.conexao.ConnectionFactory;

import org.mindrot.jbcrypt.BCrypt; // Importação do BCrypt para as senhas

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaDao {

    /**
     * Método para cadastrar um novo usuário no banco de dados.
     * A senha é criptografada automaticamente antes de salvar.
     */
    public boolean cadastrar(Pessoa pessoa) {
        String sql = "INSERT INTO Usuario (nome, email, senha, adm) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

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

    /**
     * Método para o Login. Busca pelo e-mail e compara a senha digitada com o hash do banco.
     * Retorna o objeto Pessoa preenchido se o login der certo, ou null se der errado.
     */
    public Pessoa autenticar(String emailDigitado, String senhaPuraDigitada) {
        String sql = "SELECT * FROM Usuario WHERE email = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, emailDigitado);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // O e-mail existe! Agora vamos pegar o hash salvo
                    String hashDoBanco = rs.getString("senha");

                    // Compara a senha digitada na tela com o hash do banco
                    if (BCrypt.checkpw(senhaPuraDigitada, hashDoBanco)) {
                        
                        // Senha correta! Montamos o objeto Pessoa com os dados do banco para o sistema usar
                        Pessoa usuarioLogado = new Pessoa();
                        usuarioLogado.setIdUsuario(rs.getInt("id_usuario"));
                        usuarioLogado.setNome(rs.getString("nome"));
                        usuarioLogado.setEmail(rs.getString("email"));
                        usuarioLogado.setSenha(hashDoBanco);
                        usuarioLogado.setAdm(rs.getBoolean("adm"));
                        
                        return usuarioLogado;
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro na autenticação: " + e.getMessage());
        }
        
        // Se o e-mail não existir ou a senha estiver errada, retorna null
        return null; 
    }
}