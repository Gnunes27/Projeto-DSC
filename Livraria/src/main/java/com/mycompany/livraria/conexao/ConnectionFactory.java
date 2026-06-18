/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.livraria.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    // Configurações do Banco de Dados (Agora dentro da classe!)
    private static final String URL = "jdbc:mysql://localhost:3306/Livraria";
    private static final String USER = "root";   
    private static final String PASS = "gnunes27"; 
    
    // Método para obter a conexão
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver do MySQL não encontrado!", e);
        }
    }
    // Script para testar a conexão com o banco de dados
    /*public static void main(String[] args) {
        try {
            System.out.println("Tentando conectar ao banco de dados...");
            java.sql.Connection con = ConnectionFactory.getConnection();

            if (con != null) {
                System.out.println("SUCESSO! O banco conversou com o código perfeitamente.");
                con.close(); // Fecha a conexão após o teste
            }
        } catch (Exception e) {
            System.out.println("FALHA! Ocorreu um erro ao tentar conectar:");
            e.printStackTrace();
        }
    }*/
}