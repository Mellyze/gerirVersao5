/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import Database.ConexaoJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class Movimentacao extends javax.swing.JFrame {

    /**
     * Creates new form ControleProblema
     */
    String sqlPesquisa = "select case when (st_within(localizacao,(select area from tb_estacionamento where id=1))=true)\n"
            + "		then (select nome from tb_estacionamento where id=1)\n"
            + "            when(st_within(localizacao,(select area from tb_estacionamento where id=2))=true)\n"
            + "		then (select nome from tb_estacionamento where id=2)\n"
            + "	    when(st_within(localizacao,(select area from tb_estacionamento where id=3))=true)\n"
            + "		then (select nome from tb_estacionamento where id=3)\n"
            + "	    else 'N/A'\n"
            + "	end as verifica,\n"
            + "	st_astext(localizacao) as localizacao,\n"
            + "	tb_estacionamento.preco_per_minute as preco,\n"
            + "	dt_ponto as tempo\n"
            + "	from ponto \n"
            + "	FULL join tb_estacionamento on (tb_estacionamento.nome = case when (st_within(localizacao,(select area from tb_estacionamento where id=1))=true)\n"
            + "		then (select nome from tb_estacionamento where id=1)\n"
            + "            when(st_within(localizacao,(select area from tb_estacionamento where id=2))=true)\n"
            + "		then (select nome from tb_estacionamento where id=2)\n"
            + "	    when(st_within(localizacao,(select area from tb_estacionamento where id=3))=true)\n"
            + "		then (select nome from tb_estacionamento where id=3)\n"
            + "	    ELSE 'N/A'\n"
            + "	    \n"
            + "\n"
            + "	end)\n"
            + "	where placa=?";
    String[] column = {"Estacionamento", "Entrada", "Saída", "Permanência", "Valor"};
    ConexaoJDBC con = new ConexaoJDBC();

    public Movimentacao() {

        initComponents();
        atualizaCombo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Dados = new javax.swing.JTable();
        fechar = new javax.swing.JButton();
        veiculo = new javax.swing.JComboBox<>();
        ver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Movimentações");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Controle de Movimentações");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Dados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(Dados);

        fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfaceGrafica/confirma.png"))); // NOI18N
        fechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fecharMouseClicked(evt);
            }
        });

        ver.setText("Ver");
        ver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(veiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ver)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(veiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ver)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void preencherTabela(String SQL, String[] col) {
        ArrayList dados = new ArrayList();
        String[] colunas = col;
        String entrada = "N/A";
        long tempo;
        float valor = 0;
        Timestamp t1 = new Timestamp(0), t2 = new Timestamp(0);
        try {
            con.conecta();
            con.stm = con.con.prepareStatement(SQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            con.stm.setString(1, (String) veiculo.getItemAt(veiculo.getSelectedIndex()));
            con.rs = con.stm.executeQuery();
            con.rs.first();

            do {
                if (!con.rs.getString("verifica").equals("N/A") && entrada == "N/A") {
                    entrada = con.rs.getString("verifica");
                    t1 = con.rs.getTimestamp("tempo");
                    valor = con.rs.getFloat("preco");
                    System.out.println("1");
                } else if (con.rs.getString("verifica").equals("N/A") && entrada != "N/A") {
                    t2 = con.rs.getTimestamp("tempo");
                    tempo = ((t2.getTime() - t1.getTime()) / 3600);
                    dados.add(new Object[]{entrada, t1, t2, tempo, tempo * valor});
                    entrada = "N/A";
                    System.out.println("2");
                } else if (!con.rs.getString("verifica").equals("N/A") && entrada != "N/A" && !con.rs.getString("verifica").equals(entrada) ) {
                    t2 = con.rs.getTimestamp("tempo");
                    tempo = ((t2.getTime() - t1.getTime()) / 3600);
                    dados.add(new Object[]{entrada, t1, t2, tempo, tempo * valor});
                    entrada = con.rs.getString("verifica");
                    t1 = con.rs.getTimestamp("tempo");
                    valor = con.rs.getFloat("preco");
                    System.out.println("3");
                }
            } while (con.rs.next());
            con.desconecta();

        } catch (Exception e) {
            e.printStackTrace();
        }

        ModeloTabela tabela = new ModeloTabela(dados, colunas);
        Dados.setModel(tabela);
        con.desconecta();
    }

    private void fecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fecharMouseClicked
        dispose();
    }//GEN-LAST:event_fecharMouseClicked

    private void verMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verMouseClicked
        preencherTabela(sqlPesquisa, column);
    }//GEN-LAST:event_verMouseClicked

    public void atualizaCombo() {
        try {
            con.conecta();
            con.stm = con.con.prepareStatement("select placa from tb_veiculo order by id", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            con.rs = con.stm.executeQuery();
            con.rs.first();
            veiculo.removeAllItems();
            do {
                veiculo.addItem(new String(con.rs.getString("placa")));
            } while (con.rs.next());
            con.desconecta();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroPontos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Movimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Movimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Movimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Movimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Movimentacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Dados;
    private javax.swing.JButton fechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> veiculo;
    private javax.swing.JButton ver;
    // End of variables declaration//GEN-END:variables
}
