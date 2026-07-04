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
    
    public void register(Livro livro){
        //verificando validade das informações
        if(livro.getPreco() <= 0)
            throw new RuntimeException("O preço do livro não pode ser zero ou negativo! ");
        
        //verifica se já não existe um livro com o mesmo código no banco de dados
        if(livroDao.buscar(livro.getCodigo()) != null)
            throw new RuntimeException("Esse código já está cadastrado para outro livro! ");
        
        try{
            livroDao.cadastrar(livro);
        } catch (RuntimeException e){
            throw e;
        }
    }
    
    public void delete(String codigo){
        try{
            livroDao.excluir(codigo);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao excluir o livro: "+e.getMessage());
        }
    }
}
