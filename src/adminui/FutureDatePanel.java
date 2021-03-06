/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminui;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Grapess
 */
public class FutureDatePanel extends javax.swing.JPanel {

    GregorianCalendar gcal;

    public FutureDatePanel() {
        initComponents();
        gcal = new GregorianCalendar();
        jcbYear.removeAllItems();
        jcbYear.addItem("Year");
        jcbMonth.removeAllItems();
        jcbMonth.addItem("Month");
        jcbDate.removeAllItems();
        jcbDate.addItem("Date");
        int currentyear = gcal.get(Calendar.YEAR);
        for (int year = currentyear; year <= currentyear + 1; year++) {
            jcbYear.addItem(year);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcbYear = new javax.swing.JComboBox();
        jcbMonth = new javax.swing.JComboBox();
        jcbDate = new javax.swing.JComboBox();

        jcbYear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jcbYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbYearItemStateChanged(evt);
            }
        });

        jcbMonth.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jcbMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbMonthItemStateChanged(evt);
            }
        });

        jcbDate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jcbDate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jcbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jcbMonth, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addComponent(jcbDate, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
            .addComponent(jcbYear)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jcbYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbYearItemStateChanged
        int selected_month = 0;
        if (jcbMonth.getSelectedIndex() > 0) {
            MonthList month = (MonthList) jcbMonth.getSelectedItem();
            selected_month = month.ordinal();
        }
        int selected_date = 0;
        if (jcbDate.getSelectedIndex() > 0) {
            selected_date = Integer.parseInt(jcbDate.getSelectedItem().toString());
        }
        jcbMonth.removeAllItems();
        jcbMonth.addItem("Month");
        if (jcbYear.getSelectedIndex() > 0) {
            int selected_year = Integer.parseInt(jcbYear.getSelectedItem().toString());
            int current_year = gcal.get(Calendar.YEAR);
            MonthList[] months = MonthList.values();
            int end_index = months.length - 1;
            int start_index = 0;
            if (selected_year == current_year) {
                start_index = gcal.get(Calendar.MONTH);
            }
            for (int index = start_index; index <= end_index; index++) {
                jcbMonth.addItem(months[index]);
            }
            for (int i = 1; i < jcbMonth.getItemCount(); i++) {
                MonthList month = (MonthList) jcbMonth.getItemAt(i);
                if (month.ordinal() == selected_month) {
                    jcbMonth.setSelectedIndex(i);
                    break;
                }
            }
            for (int i = 1; i < jcbDate.getItemCount(); i++) {
                int date = Integer.parseInt(jcbDate.getItemAt(i).toString());
                if (date == selected_date) {
                    jcbDate.setSelectedIndex(i);
                    break;
                }
            }
        }
    }//GEN-LAST:event_jcbYearItemStateChanged

    private void jcbMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbMonthItemStateChanged
        int selected_date = 0;
        if (jcbDate.getSelectedIndex() > 0) {
            selected_date = Integer.parseInt(jcbDate.getSelectedItem().toString());
        }
        jcbDate.removeAllItems();
        jcbDate.addItem("Date");
        if (jcbMonth.getSelectedIndex() > 0) {
            int selected_year = Integer.parseInt(jcbYear.getSelectedItem().toString());
            int current_year = gcal.get(Calendar.YEAR);
            MonthList selected_month = (MonthList) jcbMonth.getSelectedItem();
            int current_month = gcal.get(Calendar.MONTH);
            int startrange = 1;
            int daterange = selected_month.getDaterange();
            if (selected_year == current_year && current_month == selected_month.ordinal()) {
                startrange = gcal.get(Calendar.DATE);
            }
            if (selected_month == MonthList.February) {
                daterange = gcal.isLeapYear(selected_year) ? 29 : 28;
            }
            for (int date = startrange; date <= daterange; date++) {
                jcbDate.addItem(date);
            }
            for (int i = 1; i < jcbDate.getItemCount(); i++) {
                int date = Integer.parseInt(jcbDate.getItemAt(i).toString());
                if (date == selected_date) {
                    jcbDate.setSelectedIndex(i);
                    break;
                }
            }
        }
    }//GEN-LAST:event_jcbMonthItemStateChanged

    public Date getSelectedDate() {
        Date date = null;
        try {
            if (jcbYear.getSelectedIndex() > 0 && jcbMonth.getSelectedIndex() > 0 && jcbDate.getSelectedIndex() > 0) {
                int y = Integer.parseInt(jcbYear.getSelectedItem().toString());
                MonthList month = (MonthList) jcbMonth.getSelectedItem();
                int m = month.ordinal() + 1;
                int d = Integer.parseInt(jcbDate.getSelectedItem().toString());
                String datevalue = y + "-" + m + "-" + d;
                date = Date.valueOf(datevalue);
            }
        } catch (Exception ex) {
        }
        return date;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jcbDate;
    private javax.swing.JComboBox jcbMonth;
    private javax.swing.JComboBox jcbYear;
    // End of variables declaration//GEN-END:variables

    public void setDate(Date date) {
        try {
            String[] values = date.toString().split("-");
            int y = Integer.parseInt(values[0]);
            int m = Integer.parseInt(values[1]);
            int d = Integer.parseInt(values[2]);
            for (int i = 1; i < jcbYear.getItemCount(); i++) {
                int year = Integer.parseInt(jcbYear.getItemAt(i).toString());
                if (year == y) {
                    jcbYear.setSelectedIndex(i);
                    break;
                }
            }
            for (int i = 1; i < jcbMonth.getItemCount(); i++) {
                MonthList month = (MonthList) jcbMonth.getItemAt(i);
                if (month.ordinal() == m - 1) {
                    jcbMonth.setSelectedIndex(i);
                    break;
                }
            }
            for (int i = 0; i < jcbDate.getItemCount(); i++) {
                int gdate = Integer.parseInt(jcbDate.getItemAt(i).toString());
                if (gdate == d) {
                    jcbDate.setSelectedIndex(i);
                    break;
                }
            }
        } catch (Exception ex) {
        }
    }
}
