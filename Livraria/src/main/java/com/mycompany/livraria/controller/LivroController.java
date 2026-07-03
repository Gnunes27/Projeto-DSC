/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.livraria.controller;
import com.mycompany.livraria.dao.LivroDao;
import com.mycompany.livraria.model.Livro;


/**
 *
 * @author Bruno
 */
public class LivroController {
    
    private final LivroDao livroDao; 
    
    public LivroController(LivroDao livroDao){
        this.livroDao = livroDao;
    }
    
    public Livro search(String txtCodigo){
        //verificando se é a pessoa digitou alguma coisa
        if(txtCodigo.isEmpty() || txtCodigo.trim().isEmpty())
            throw new IllegalArgumentException("Digite um código válido!");
        
        //mandando para o DAO procurar
        try {
           //Buscando o livro 
           Livro livro =  livroDao.buscar(txtCodigo);
           
           if (livro == null)
               throw new RuntimeException("Não foi encontrado livro com esse código");
           
           return livro;
           
        } catch (RuntimeException e) {
            throw new RuntimeException("Não foi possível encontrar o livro!", e);
        }
    }
}
