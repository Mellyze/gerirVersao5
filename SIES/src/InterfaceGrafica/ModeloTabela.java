/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gustavo
 */
public class ModeloTabela extends AbstractTableModel{

   
    private String colunas[]=null;
    private ArrayList linhas = null ;
    
    public ModeloTabela(ArrayList lin, String[] col) {
        //seto os dados no construtor
        setLinhas(lin);
        setColunas(col);
    }

    public ArrayList getLinhas()
    {
        return linhas;
    }

    public void setLinhas(ArrayList dados)
    {
        linhas=dados;
    }
    
    public String[] getColunas()
    {
        return colunas;
    }
    
    public void setColunas(String [] titulos)
    {
        colunas=titulos;
    }
    
    public int getColumnCount()
    {
        return colunas.length;
    }
    
    public int getRowCount()
    {
        return linhas.size();
    }       
    
    public String getColumnName(int numCol)
    {
        return colunas[numCol];
    }
    
    public Object getValueAt(int numLim, int numCol)
    {
        Object[] linha = (Object[])getLinhas().get(numLim);
        return linha[numCol];
    } 
}
