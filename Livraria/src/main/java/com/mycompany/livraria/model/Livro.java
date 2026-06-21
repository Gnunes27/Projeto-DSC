/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.livraria.model;

/**
 *
 * @author Gnunes
 */

public class Livro {
    
    private int idLivro;
    private String nome;
    private String autor;
    private String categoria;
    private double preco;
    private String codigo;

    public Livro() {
    }

    public Livro(int idLivro, String nome, String autor, String categoria, double preco, String codigo) {
        this.idLivro = idLivro;
        this.nome = nome;
        this.autor = autor;
        this.categoria = categoria;
        this.preco = preco;
        this.codigo = codigo;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}