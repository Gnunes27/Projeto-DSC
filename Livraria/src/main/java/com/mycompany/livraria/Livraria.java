/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.livraria;
import com.mycompany.livraria.view.*;
import com.mycompany.livraria.model.Pessoa;
import com.mycompany.livraria.controller.PessoaController;

/**
 *
 * @author Gnunes
 */
public class Livraria {

    public static void main(String args[]) {
        PessoaController pessoaController = new PessoaController();
        //Criar um adm se não existir
        try{
            pessoaController.search("1");
        } catch (RuntimeException e){
            //Se não encontrar cria um adm
            Pessoa adm = new Pessoa();
            adm.setNome("adm");
            adm.setEmail("Adm@livraria");
            adm.setSenha("12345");
            adm.setAdm(true);
            adm.setSaldo(1.00);
            
            pessoaController.register(adm);
        }
        
        //Usuários
        try{
            pessoaController.search("2");
        }catch (RuntimeException e){
            //Se não encontrar cria um user
            Pessoa user = new Pessoa();
            user.setNome("Pedro");
            user.setEmail("Pedro@Usuario");
            user.setSenha("p123");
            user.setAdm(false);
            user.setSaldo(1000.00);
            
            pessoaController.register(user);
        }
        
        try{
            pessoaController.search("3");
        }catch (RuntimeException e){
            //Se não encontrar cria um user
            Pessoa user = new Pessoa();
            user.setNome("Nanda");
            user.setEmail("Nanda@Usuario");
            user.setSenha("n123");
            user.setAdm(false);
            user.setSaldo(1000.00);
            
            pessoaController.register(user);
        }
        
        try{
            pessoaController.search("4");
        }catch (RuntimeException e){
            //Se não encontrar cria um user
            Pessoa user = new Pessoa();
            user.setNome("Luis");
            user.setEmail("Luis@Usuario");
            user.setSenha("l123");
            user.setAdm(false);
            user.setSaldo(1000.00);
            
            pessoaController.register(user);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new TelaInicialView().setVisible(true);
            }
        });
    }
}
