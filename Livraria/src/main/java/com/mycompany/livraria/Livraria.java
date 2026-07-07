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
            adm.setEmail("adm");
            adm.setSenha("123");
            adm.setAdm(true);
            adm.setSaldo(666.00);
            
            pessoaController.register(adm);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new TelaInicialView().setVisible(true);
            }
        });
    }
}
