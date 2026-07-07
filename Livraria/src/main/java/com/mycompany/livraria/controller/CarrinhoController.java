/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.livraria.controller;

import com.mycompany.livraria.dao.CarrinhoDao;
import com.mycompany.livraria.model.Carrinho;


/**
 *
 * @author Gnunes
 */
public class CarrinhoController {
    
    //PessoaController
    PessoaController pessoaController = new PessoaController();

    private final CarrinhoDao carrinho = new CarrinhoDao();

    public int search(int id) {
        try {
            int cart = carrinho.searchCarrinho(id);
            return cart;
        } catch (java.sql.SQLException e) {
            throw new RuntimeException("Erro ao buscar carrinho: " + e.getMessage(), e);
        }

    }

    public void addItem(int idCliente, int idLivro, int qtde) {
        try {
            carrinho.addItem(idCliente, idLivro, qtde);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao adicionar Item: " + e.getMessage(), e);
        }
        
        
        
    }

    public Carrinho getCarrinho(int idCliente) {
        try {
            Carrinho cart = carrinho.restaurarCarrinho(idCliente);
            return cart;
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro: " + e.getMessage(), e);
        }
    }

    public void finalizarCompra(int idCliente, Double valorCompra) {
        try {
            carrinho.finalizarCompra(idCliente);
            
            //Subtrair o valor da compra no usuário
            pessoaController.balanceUpdate(idCliente, valorCompra);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao finalizar compra: " + e.getMessage(), e);
        }
    }

}
