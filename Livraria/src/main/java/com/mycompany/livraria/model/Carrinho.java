/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.livraria.model;

import java.util.*;

/**
 *
 * @author Gnunes
 */
public class Carrinho {

    private List<ItemCarrinho> itens;

    public Carrinho() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(int idLivro, String titulo, double preco, int quantidade) {
        // Primeiro, verifica se o livro já está no carrinho
        // Se existir, soma + 1
        for (ItemCarrinho item : itens) {
            if (item.getIdLivro() == idLivro) {
                item.setQuantidade(item.getQuantidade() + quantidade);
                return; 
            }
        }

        ItemCarrinho novoItem = new ItemCarrinho(idLivro, titulo, preco, quantidade);
        itens.add(novoItem);
    }

   
    public void removerItem(int idLivro) {
        // Remove o item se o ID corresponder
        itens.removeIf(item -> item.getIdLivro() == idLivro);
    }

  
    public double calcularTotal() {
        double total = 0.0;
        for (ItemCarrinho item : itens) {
            total += (item.getPreco() * item.getQuantidade());
        }
        return total;
    }

   
    public void limparCarrinho() {
        itens.clear();
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }
}



 
