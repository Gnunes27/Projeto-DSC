/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.livraria.controller;
import com.mycompany.livraria.dao.LivroDao;
import com.mycompany.livraria.model.Livro;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class LivroController {
    
    //Instanciando DAO de livro
    private final LivroDao livroDao = new LivroDao();
    
    public List<Livro> searchCategories(String categoria, int quantidade){
        try{
            List<Livro> livros = livroDao.buscar(categoria, quantidade);
            
            return livros;
        } catch (RuntimeException e){
            throw new RuntimeException ("Erro ao listar os livros dessa categoria: "+e.getMessage(), e);
        }
    }
    
    public List<Livro> searchLastBooks(int quantidade) {
        //Chama a função DAO que faz a busca dos livros
        try{
            List<Livro> livros = livroDao.buscarRecentes(quantidade);
            //retorna os livros pesquisados
            return livros;
        } catch(RuntimeException e){
            throw new RuntimeException("Erro ao listar os livros mais recentes: "+e.getMessage(), e);
        }
    }
    
    public List<Livro> searchTitle(String titulo, int quantidade){
        try{
            List<Livro> livros = livroDao.buscarTitulo(titulo, quantidade);
            return livros;
        } catch(RuntimeException e){
            throw new RuntimeException ("Não foi buscar os livros! "+e.getMessage(), e);
        }
    }
    
    public Livro search(String txtCodigo){
        try {
           //Buscando o livro 
           Livro livro =  livroDao.buscar(txtCodigo);
           
           
           if (livro == null)
               throw new RuntimeException("Não foi encontrado livro com esse código");
           
           return livro;
           
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao encontrar o livro: " + e.getMessage(), e);
        }
    }
    
    public void register(Livro livro){
        //verificando validade das informações
        if(livro.getPreco() <= 0)
            throw new RuntimeException("O preço do livro não pode ser zero ou negativo! ");
        
        //verifica se já não existe um livro com o mesmo código no banco de dados
        try{
            if(livroDao.buscar(livro.getCodigo()) != null)
                throw new RuntimeException("Esse código já está cadastrado para outro livro! ");
        } catch (RuntimeException e){
            throw new RuntimeException("Erro ao verificar a validade do código: "+e.getMessage(),e);
        }
        
        //Cadastra o livro
        try{
            livroDao.cadastrar(livro);
        } catch (RuntimeException e){
            throw new RuntimeException("Erro ao cadastrar livro: " + e.getMessage(), e);
        }
    }
    
    public void delete(String codigo){
        try{
            livroDao.excluir(codigo);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao excluir o livro: "+e.getMessage(), e);
        }
    }
    
    public List<Livro> list(){
        
        //Tenta listar os livros usando o livroDao
        try{
            List<Livro> listaLivros =  livroDao.listarTodos();
            
            //retorna a lista se não ocorrer erros
            return listaLivros;
            
        } catch (RuntimeException e){
            throw new RuntimeException("Erro ao listar os livros: " + e.getMessage(), e);
        }
    }
}
