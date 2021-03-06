/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminui;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.dao.LoginInfoDAO;
import model.to.LoginInfoTo;

/**
 *
 * @author HP
 */
public class ViewUsers extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewUsers
     */
    List<LoginInfoTo> allusers;
    public ViewUsers() {
        initComponents();
        setSize(1000, 600);
        setLocation(400, 150);
        bindTableDetails();
    }
    
    protected void bindTableDetails(){
        allusers = new LoginInfoDAO().getAllRecords("user");
        String[] col_name = {"User name","Last Login"};
        Object[][] records = null;
        if (allusers != null && allusers.size() > 0) {
            records = new Object[allusers.size()][col_name.length];
            int i = 0;
            for (LoginInfoTo lt : allusers) {
                records[i] = new Object[]{lt.getUsername(), lt.getLastlogin()};
                i++;
            }
        } else {
            records = new Object[1][col_name.length];
            records[0] = new Object[]{"no records found", "no records found"};
        }
        DefaultTableModel dtm = new DefaultTableModel(records, col_name) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableusers.setModel(dtm);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableusers = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("View User Details");

        tableusers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableusers);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 995, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableusers;
    // End of variables declaration//GEN-END:variables
}
