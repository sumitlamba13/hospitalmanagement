/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import model.dao.RoomInfoDAO;
import model.to.RoomInfoTo;
import utility.CommonOperations;

public class ViewRooms extends javax.swing.JInternalFrame {

    List<RoomInfoTo> allrooms;
    private int srow;
    private JPopupMenu popup;

    public ViewRooms() {
        initComponents();
        setSize(1000, 600);
        setLocation(400, 150);
        bindTableDetails();
        srow = -1;
        popup = new JPopupMenu();
        JMenuItem deleteitem = new JMenuItem("Delete Record");
        deleteitem.setFont(new Font("Arial", Font.BOLD, 20));
        JMenuItem edititem = new JMenuItem("Edit Record");
        edititem.setFont(new Font("Arial", Font.BOLD, 20));
        try {
            ImageIcon icon1;
            icon1 = new ImageIcon(getClass().getResource("/adminui/delete.png"));
            ImageIcon icon2;
            icon2 = new ImageIcon(getClass().getResource("/adminui/edit.png"));
            deleteitem.setIcon(icon1);
            edititem.setIcon(icon2);
        } catch (Exception ex) {
        }
        popup.add(deleteitem);
        popup.add(edititem);
        deleteitem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                deleteRecord();
            }
        });
        edititem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                editRecord();
            }
        });
    }
     public void deleteRecord() {
        if (srow != -1 && allrooms != null && srow < allrooms.size()) {
            int result = JOptionPane.showConfirmDialog(this, "are you sure you want to remove this record?", "Message from system", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                RoomInfoTo ft = allrooms.get(srow);
                RoomInfoDAO action = new RoomInfoDAO();
                String message = "";
                if (action.deleteRecord(ft.getRoom_no())) {
                    message = "record is deleted from database";
                    bindTableDetails();
                } else {
                    message = "record does not remove from database" + action.getErrormessage();
                }
                JOptionPane.showMessageDialog(this, message);
            }
        }
        srow = -1;
    }

    public void editRecord() {
        if (srow != -1 && allrooms != null && srow < allrooms.size()) {
            CommonOperations.openInternalFrame(getDesktopPane(), new AddRoomDetails(allrooms.get(srow)));
            dispose();
        }
    }
    protected void bindTableDetails() {
        allrooms = new RoomInfoDAO().getAllRecord();
        String[] col_name = {"Room no.", "Floor name", "Type name", "no_of_beds"};
        Object[][] records = null;
        if (allrooms != null && allrooms.size() > 0) {
            records = new Object[allrooms.size()][col_name.length];
            int i = 0;
            for (RoomInfoTo rt : allrooms) {
                records[i] = new Object[]{rt.getRoom_no(), rt.getFloor_name(), rt.getType_name(), rt.getNo_of_bed()};
                i++;
            }
        } else {
            records = new Object[1][col_name.length];
            records[0] = new Object[]{"no records found", "no records found", "no records found"};
        }
        DefaultTableModel dtm = new DefaultTableModel(records, col_name) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableroom.setModel(dtm);
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
        tableroom = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("View Room Details");

        tableroom.setModel(new javax.swing.table.DefaultTableModel(
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
        tableroom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableroomMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableroom);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1002, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableroomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableroomMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            int point = tableroom.rowAtPoint(evt.getPoint());
            tableroom.getSelectionModel().setSelectionInterval(point, point);
            srow = tableroom.getSelectedRow();
            popup.show(tableroom, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tableroomMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableroom;
    // End of variables declaration//GEN-END:variables
}
