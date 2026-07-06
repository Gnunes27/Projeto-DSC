/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.livraria;
import com.mycompany.livraria.view.*;
/**
 *
 * @author Gnunes
 */
public class Livraria {

    public static void main(String args[]) {
        
              
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new TelaInicialView().setVisible(true);
            }
        });
    }
}
