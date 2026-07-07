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
    
    //Função de registrar pessoa
    public void register(Pessoa pessoa){
        try{
            pessoaDao.cadastrar(pessoa);
        } catch(RuntimeException e){
            throw new RuntimeException("Erro ao cadastrar usuário: " + e.getMessage(), e);
        }
    }
    
    //Função de atualizar saldo
    public void balanceUpdate(int idUsuario, Double valorPago){
        try{
            pessoaDao.atualizarSaldo(idUsuario, valorPago);
        } catch(RuntimeException e){
            throw new RuntimeException("Erro ao atualizar o saldo: "+e.getMessage(), e);
        }
    }
    
    //Função de logar
    public Pessoa login(String email, String senha){
        try{
            Pessoa pessoaLogada = pessoaDao.autenticar(email, senha);
            
            //retorna a pessoa logada ou nulo caso esteja com senha ou usuário incorretos
            return pessoaLogada;
            
        } catch (RuntimeException e){
            throw new RuntimeException ("Erro ao fazer login: "+e.getMessage(), e);
        }
    }
    
    //Listar pessoas
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
    
    //Buscar pessoa
    public Pessoa search(String id){
        try{
            Pessoa p = pessoaDao.buscar(id);
            if (p == null)
               throw new RuntimeException("Não foi encontrado livro com esse código");
            return p;
        }catch (RuntimeException e){
            throw new RuntimeException("Erro ao buscar cliente: "+e.getMessage(), e);
        }
    }
    
    //Deletar pessoa
    public void delete(String id){
        try{
            pessoaDao.excluir(id);
        }catch(RuntimeException e){
            throw new RuntimeException("Erro ao buscar cliente: "+e.getMessage(), e);
        }
    }
}
