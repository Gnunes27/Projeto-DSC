/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.livraria.view;

/**
 *
 * @author Gnunes
 */
public class ItemCarrinho {

    private int idLivro;
    private String titulo;
    private double preco;
    private int quantidade;

    public ItemCarrinho(int idLivro, String titulo, double preco, int quantidade) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Getters e Setters
    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
