/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.livraria.controller;
import com.mycompany.livraria.model.Pessoa;
import com.mycompany.livraria.dao.PessoaDao;
import java.util.List;
/**
 *
 * @author br992
 */
public class PessoaController {
    //Intanciando o DAO de pessoa
    private final PessoaDao pessoaDao = new PessoaDao();
    
    
    public List<Pessoa> list(){
        //Chama pessoaDao para retornar a lista de clientes no banco de dados
        try {
            List<Pessoa> pessoas = pessoaDao.listarTodos();
            
            //Se não houver nenhum errro retorna para a view
            return pessoas;
        } catch (RuntimeException e){
            //Se houver erro propaga o erro para a tela view e cancela
            throw new RuntimeException("Erro ao listar clientes: "+e.getMessage(), e);
        }
    }
}
