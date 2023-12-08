/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frame;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import databaseMember.TampilDataMember;
import databaseMember.DeleteMember;
import databaseMember.UpdateMember;
import databaseMember.CreateMember;
/**
 *
 * @author ACER
 */
public class DataMember extends javax.swing.JFrame {

    /**
     * Creates new form DataMember
     */
    
    TampilDataMember tampilData = new TampilDataMember();
    int selectedRow = -1;
    public DataMember() {
        initComponents();
        String[] columns = {
          "Mama Member", 
          "No HP", 
          "Email Member", 
          "Doomisili Member",
        };   
        DefaultTableModel modeltabel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        this.tabelDataMember.setModel(modeltabel);
        ResultSet rs = tampilData.tampilkanDataSemuaMember();
        
        try {
            int i = 0;
            if (rs != null) {  // Add this check
                while (rs.next()) {
                    modeltabel.addRow(new Object[]{rs.getString("id_member"), rs.getString("nama_member"), rs.getString("no_hp"), rs.getString("email"), rs.getString("domisili")});
                    i++;
                }
            }
        } catch (SQLException e) {
            System.out.println("Pesan Error : " + e.getMessage());
        }

        setVisible(true);
    }
    
    
    
    private void refreshTable() {
        DefaultTableModel tabelData = (DefaultTableModel) tabelDataMember.getModel();
        tabelData.setRowCount(0); // Clear the table

        ResultSet rs = tampilData.tampilkanDataSemuaMember();

        try {
            while (rs.next()) {
                tabelData.addRow(new Object[]{
                    rs.getString("id_member"),
                    rs.getString("nama_member"),
                    rs.getString("no_hp"),
                    rs.getString("email"),
                    rs.getString("domisili")
                });
            }
        } catch (SQLException e) {
            System.out.println("Pesan Error : " + e.getMessage());
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

        LabelKOde = new javax.swing.JLabel();
        LabelNama = new javax.swing.JLabel();
        LabelNO = new javax.swing.JLabel();
        LabelEmail = new javax.swing.JLabel();
        LabelDomisili = new javax.swing.JLabel();
        InputKode = new javax.swing.JTextField();
        InputNama = new javax.swing.JTextField();
        InputHandphone = new javax.swing.JTextField();
        InputEmail = new javax.swing.JTextField();
        InputDomisili = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelDataMember = new javax.swing.JTable();
        btnCari = new javax.swing.JButton();
        InputCariMember = new javax.swing.JTextField();
        btnSimpanMember = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        btnHapusMember = new javax.swing.JButton();
        btnEditMember = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        usernameAdmin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LabelKOde.setText("KODE MEMBER");

        LabelNama.setText("NAMA MEMBER");

        LabelNO.setText("NO HANDPHONE");

        LabelEmail.setText("EMAIL");

        LabelDomisili.setText("DOMISILI");

        InputHandphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputHandphoneActionPerformed(evt);
            }
        });

        tabelDataMember.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelDataMember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabelDataMemberMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabelDataMember);

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnSimpanMember.setText("SIMPAN");
        btnSimpanMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanMemberActionPerformed(evt);
            }
        });

        btnKembali.setText("KEMBALI");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        btnHapusMember.setText("HAPUS");
        btnHapusMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusMemberActionPerformed(evt);
            }
        });

        btnEditMember.setText("EDIT");
        btnEditMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditMemberActionPerformed(evt);
            }
        });

        jLabel1.setText("Selamat datang, ");

        usernameAdmin.setText("text");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnSimpanMember, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(usernameAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(LabelNama, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(LabelNO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(LabelKOde)
                                            .addComponent(LabelEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(LabelDomisili, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(InputKode)
                                            .addComponent(InputNama)
                                            .addComponent(InputHandphone)
                                            .addComponent(InputDomisili)
                                            .addComponent(InputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(35, 35, 35)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnHapusMember, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditMember, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(InputCariMember)
                                .addGap(18, 18, 18)
                                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usernameAdmin))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelKOde)
                            .addComponent(InputKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelNama)
                            .addComponent(InputNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelNO)
                            .addComponent(InputHandphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(InputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(InputDomisili, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelDomisili))
                        .addGap(21, 21, 21)
                        .addComponent(btnSimpanMember)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(InputCariMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHapusMember)
                    .addComponent(btnEditMember))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnKembali)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InputHandphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputHandphoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputHandphoneActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        ResultSet rs;
        if(!"".equals(InputCariMember.getText())) {
            rs = tampilData.tampilkanDataMember(InputCariMember.getText());
        } else {
            rs = tampilData.tampilkanDataSemuaMember();
        }

        DefaultTableModel tabel = (DefaultTableModel) tabelDataMember.getModel();

        try{
            for(var i = tabel.getRowCount() - 1; i >= 0; i--) {
                tabel.removeRow(i);
            }
            while(rs.next()){
                tabel.addRow(new Object[]{rs.getString("kode_barang"), rs.getString("nama_barang"),rs.getString("harga_barang"), rs.getString("jumlah_barang")});
            }

        }catch(SQLException e){
            System.out.println("Pesan Error : " + e.getMessage());
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnSimpanMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanMemberActionPerformed
        // TODO add your handling code here:
        try {
            String Namamember = InputNama.getText();;
            String Emailmember = InputEmail.getText();
            String Domisilimember = InputDomisili.getText();
            String cleanedPhoneNumber = InputHandphone.getText().replaceAll("[^\\d]", "");

            try {
                int NoHPmember = Integer.parseInt(cleanedPhoneNumber);
                // rest of your code...
            } catch (NumberFormatException e) {
                // Handle the case where the input is not a valid integer
                e.printStackTrace();
            }          

            // Retrieve the latest ID from the database
            int latestId = tampilData.getLatestMemberId();

            // Increment the ID for the new member
            int newId = latestId + 1;

            // Set the new ID in the InputKode field
            InputKode.setText(String.valueOf(newId));

            // Create the new member with the incremented ID
            CreateMember.CreateDataMember(Namamember, HAND_CURSOR, Emailmember, Domisilimember, rootPane);
        } catch (Exception e) {
            e.printStackTrace();
        }         
    }//GEN-LAST:event_btnSimpanMemberActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        // TODO add your handling code here:
        Menu menu = new Menu();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnHapusMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusMemberActionPerformed
        // TODO add your handling code here:
        DeleteMember deleteData = new DeleteMember();
        DeleteMember.deleteDataMember(SOMEBITS, rootPane);
        DefaultTableModel tabel = (DefaultTableModel) tabelDataMember.getModel();
        tabel.removeRow(selectedRow);
        
        InputKode.setText("");
        InputNama.setText("");
        InputHandphone.setText("");
        InputEmail.setText("");
        InputDomisili.setText("");
    }//GEN-LAST:event_btnHapusMemberActionPerformed

    private void btnEditMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditMemberActionPerformed
        // TODO add your handling code here:
        UpdateMember updateData = new UpdateMember();
        updateData.updateDataMember(
            Integer.parseInt(InputKode.getText()),
            InputNama.getText(),
            Integer.parseInt(InputHandphone.getText()),
            InputEmail.getText(),
            InputDomisili.getText(),
            rootPane
        );
   
        DefaultTableModel tabel = (DefaultTableModel) tabelDataMember.getModel();
        tabel.addRow(new Object[]{InputKode.getText(), InputNama.getText(), InputHandphone.getText(),InputEmail.getText(), InputDomisili.getText()});
        tabel.removeRow(selectedRow);
    }//GEN-LAST:event_btnEditMemberActionPerformed

    private void tabelDataMemberMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelDataMemberMousePressed
        // TODO add your handling code here:
        int row = tabelDataMember.getSelectedRow();
                selectedRow = row;
                InputKode.setText(tabelDataMember.getValueAt(row, 0).toString());
                InputNama.setText(tabelDataMember.getValueAt(row, 1).toString());
                InputHandphone.setText(tabelDataMember.getValueAt(row, 2).toString());
                InputEmail.setText(tabelDataMember.getValueAt(row, 3).toString());
                InputDomisili.setText(tabelDataMember.getValueAt(row, 4).toString());
    }//GEN-LAST:event_tabelDataMemberMousePressed

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
            java.util.logging.Logger.getLogger(DataMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataMember().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField InputCariMember;
    private javax.swing.JTextField InputDomisili;
    private javax.swing.JTextField InputEmail;
    private javax.swing.JTextField InputHandphone;
    private javax.swing.JTextField InputKode;
    private javax.swing.JTextField InputNama;
    private javax.swing.JLabel LabelDomisili;
    private javax.swing.JLabel LabelEmail;
    private javax.swing.JLabel LabelKOde;
    private javax.swing.JLabel LabelNO;
    private javax.swing.JLabel LabelNama;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnEditMember;
    private javax.swing.JButton btnHapusMember;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnSimpanMember;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelDataMember;
    private javax.swing.JLabel usernameAdmin;
    // End of variables declaration//GEN-END:variables
}
