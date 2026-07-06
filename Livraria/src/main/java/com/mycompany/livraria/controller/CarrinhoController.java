/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.livraria.controller;
import com.mycompany.livraria.dao.CarrinhoDao;
import com.mycompany.livraria.model.Carrinho;
import java.util.*;
/**
 *
 * @author Gnunes
 */
public class CarrinhoController {
    private final CarrinhoDao carrinho = new CarrinhoDao();
    
    public int search(int id){
        try{
            int cart = carrinho.searchCarrinho(id);
            return cart;
        }catch (java.sql.SQLException e){
            throw new RuntimeException ("Erro ao listar os livros dessa categoria: "+e.getMessage(), e);
        }
    
    }
    
}
