/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminui;

import java.sql.Timestamp;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.dao.LoginInfoDAO;
import model.to.LoginInfoTo;
import utility.Validations;

/**
 *
 * @author HP
 */
public class ChangePassword extends javax.swing.JInternalFrame {

    /**
     * Creates new form ChangePassword
     */
    

    public ChangePassword() {
        initComponents();
        setSize(1000, 750);
        setLocation(400, 100);
    }
    public ChangePassword(String uname){
        this();
        jtfUserName.setText(uname);
        jtfUserName.setEditable(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtfUserName = new javax.swing.JTextField();
        jpfpassword3 = new javax.swing.JPasswordField();
        jpfpassword1 = new javax.swing.JPasswordField();
        jpfpassword2 = new javax.swing.JPasswordField();
        btnchange = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Change Password");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Enter Old Password :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Enter User Name :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Enter New Password :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("Re-Enter New Password:");

        jtfUserName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jpfpassword3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jpfpassword1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jpfpassword2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        btnchange.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnchange.setText("CHANGE");
        btnchange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchangeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                            .addComponent(jpfpassword3)
                            .addComponent(jpfpassword1)
                            .addComponent(jpfpassword2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(btnchange, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpfpassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpfpassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpfpassword3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addComponent(btnchange, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnchangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchangeActionPerformed
        String uname = jtfUserName.getText().trim();
        LoginInfoTo record = new LoginInfoDAO().getRecord(uname);
        String upass = new String(jpfpassword1.getPassword());
        String upass2 = new String(jpfpassword2.getPassword());
        String upass3 = new String(jpfpassword3.getPassword());
        String rolename = new String(record.getRolename());
        String message = "";

        if (Validations.isEmpty(uname) || Validations.isEmpty(upass) || Validations.isEmpty(upass2) || Validations.isEmpty(upass3) ) {
            message = "Please fill all fields";
        } else if (!record.getPassword().equals(upass)) {
            message += "Please enter correct old password";
        } else if (!upass2.equals(upass3)) {
            message += "Password does not match\n\n";
            message += "Please enter same password in both fields  \n\n";
        } else {
            LoginInfoTo records = new LoginInfoTo();
            LoginInfoDAO action = new LoginInfoDAO();
            records.setUsername(uname);
            records.setPassword(upass2);
            records.setRolename(rolename);
            records.setLastlogin(record.getLastlogin());
            if (action.updateRecord(records)) {
                message = "password changed successfully";
                dispose();
            } else {
                message = "updation failure" + action.getErrormessage();
            }
        }
        JOptionPane.showMessageDialog(this, message);
    }//GEN-LAST:event_btnchangeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnchange;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField jpfpassword1;
    private javax.swing.JPasswordField jpfpassword2;
    private javax.swing.JPasswordField jpfpassword3;
    private javax.swing.JTextField jtfUserName;
    // End of variables declaration//GEN-END:variables
}