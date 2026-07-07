/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.livraria.controller;

import com.mycompany.livraria.dao.RelatorioDao;
import java.util.List;

/**
 *
 * @author Gnunes
 */
public class RelatorioController {

    private final RelatorioDao relatorioDAO = new RelatorioDao();

     // Busca livros vendidos
    public int getTotalLivrosVendidos() {
        try {
            return relatorioDAO.getTotalLivrosVendidos();
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao buscar o total de livros vendidos: " + e.getMessage(), e);
        }
    }

   
    //Busca o valor total faturado 
    public double getTotalFaturado() {
        try {
            return relatorioDAO.getTotalFaturado();
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao buscar o total faturado: " + e.getMessage(), e);
        }
    }

    //Busca o livro mais vendido ou menos vendido.
    //Se true, traz o mais vendido. Se false, o menos
    public String getLivroDestaque(boolean maisVendido) {
        try {
            return relatorioDAO.getLivrosVendidos(maisVendido);
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao buscar o livro destaque: " + e.getMessage(), e);
        }
    }

    //Busca a lista de faturamento para cada mês
    public List<String> getFaturamentoPorMes() {
        try {
            return relatorioDAO.getFaturamentoPorMes();
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao buscar o faturamento por mês: " + e.getMessage(), e);
        }
    }

    
     //Busca o histórico de vendas
    public List<Object[]> getHistoricoVendas() {
        try {
            return relatorioDAO.getHistoricoVendas();
        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao buscar o histórico de vendas: " + e.getMessage(), e);
        }
    }

    public String gerarRelatorioFormatado() {
        try {
            int totalLivros = getTotalLivrosVendidos();
            double totalFaturado = getTotalFaturado();
            String maisVendido = getLivroDestaque(true);
            String menosVendido = getLivroDestaque(false);

            StringBuilder mesesStr = new StringBuilder();
            for (String mes : getFaturamentoPorMes()) {
                mesesStr.append("   - ").append(mes).append("\n");
            }
            if (mesesStr.length() == 0) {
                mesesStr.append("   - Nenhum dado de faturamento mensal registrado.\n");
            }

            StringBuilder historico = new StringBuilder();
            for (Object[] venda : getHistoricoVendas()) {
                // venda[0]=ID, venda[1]=Cliente, venda[2]=Data, venda[3]=Valor
                historico.append(String.format("   Pedido #%d | %s | Data: %s | Valor: %s\n",
                        venda[0], venda[1], venda[2], venda[3]));
            }
            if (historico.length() == 0) {
                historico.append("   - Nenhum histórico de vendas registrado.\n");
            }

            String documento
                    = "=========================================================\n"
                    + "               ===RELATÓRIO DA LIVRARIA ENTRE LINHAS===            \n"
                    + "=========================================================\n\n"
                    + "[ RESUMO FINANCEIRO E DE VENDAS ]\n"
                    + "Total de Livros Vendidos :        %d unidades\n"
                    + "Faturamento Total:                   R$ %.2f\n\n"
                    + "[ DESTAQUES DO CATÁLOGO ]\n"
                    + "Livro Mais Vendido:          %s\n"
                    + "Livro Menos Vendido:       %s\n\n"
                    + "[ FATURAMENTO POR MÊS ]\n"
                    + "%s\n"
                    + "[ HISTÓRICO DE VENDAS ]\n"
                    + "%s\n"
                    + "=========================================================\n";

            return String.format(documento,
                    totalLivros, totalFaturado, maisVendido, menosVendido,
                    mesesStr.toString(), historico.toString());

        } catch (RuntimeException e) {
            throw new RuntimeException("Erro ao gerar o relatório formatado: " + e.getMessage(), e);
        }
    }

}
