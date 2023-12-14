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
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
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
    String nama;
    public DataMember(String nama) {
        initComponents();
        this.nama = nama;
        this.usernameAdmin.setText(this.nama);
        String[] columns = {
        "Kode Member",
        "Nama Member", 
        "No HP", 
        "Email", 
        "Domisili",
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelDataMember = new javax.swing.JTable();
        btnCari = new javax.swing.JButton();
        InputCariMember = new javax.swing.JTextField();
        btnKembali = new javax.swing.JButton();
        btnHapusMember = new javax.swing.JButton();
        btnEditMember = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        usernameAdmin = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        InputDomisili = new javax.swing.JTextField();
        LabelDomisili = new javax.swing.JLabel();
        btnSimpanMember = new javax.swing.JButton();
        InputEmail = new javax.swing.JTextField();
        LabelEmail = new javax.swing.JLabel();
        InputHandphone = new javax.swing.JTextField();
        LabelNO = new javax.swing.JLabel();
        InputNama = new javax.swing.JTextField();
        LabelNama = new javax.swing.JLabel();
        InputKode = new javax.swing.JTextField();
        LabelKOde = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(866, 514));
        setPreferredSize(new java.awt.Dimension(866, 514));

        tabelDataMember.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "#", "Kode Member", "Nama", "No. HP", "Email", "Domisili"
            }
        ));
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Selamat datang");

        usernameAdmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        usernameAdmin.setText("username");

        LabelDomisili.setText("DOMISILI");

        btnSimpanMember.setText("SIMPAN");
        btnSimpanMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanMemberActionPerformed(evt);
            }
        });

        LabelEmail.setText("EMAIL");

        InputHandphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputHandphoneActionPerformed(evt);
            }
        });

        LabelNO.setText("NO HANDPHONE");

        LabelNama.setText("NAMA MEMBER");

        LabelKOde.setText("KODE MEMBER");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(InputDomisili)
                    .addComponent(LabelEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(InputHandphone)
                    .addComponent(InputNama)
                    .addComponent(InputKode)
                    .addComponent(InputEmail)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelDomisili, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelNO, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelNama, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelKOde))
                        .addGap(0, 106, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSimpanMember, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelKOde)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InputKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelNama)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InputNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelNO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InputHandphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelDomisili)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InputDomisili, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSimpanMember)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("PENGELOLAAN MEMBER");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(InputCariMember, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnEditMember, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapusMember, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(6, 6, 6)
                                .addComponent(usernameAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(usernameAdmin)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(InputCariMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari)
                    .addComponent(btnEditMember)
                    .addComponent(btnHapusMember))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btnKembali)
                .addContainerGap())
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
        
        try {
            for (var i = tabel.getRowCount() - 1; i >= 0; i--) {
                tabel.removeRow(i);
            }
            while (rs.next()) {
                tabel.addRow(new Object[]{rs.getString("id_member"), rs.getString("nama_member"),
                        rs.getInt("no_hp"), rs.getString("email"), rs.getString("domisili")});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "Error while processing SQL results: " + e.getMessage());
            System.out.println("Pesan Error : " + e.getMessage());
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnSimpanMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanMemberActionPerformed
        // TODO add your handling code here:
        try {
          String Namamember = InputNama.getText();
          String Emailmember = InputEmail.getText();
          String Domisilimember = InputDomisili.getText();
          String cleanedPhoneNumber = InputHandphone.getText();

          if (!Namamember.isEmpty() && !Emailmember.isEmpty() && !Domisilimember.isEmpty() && !cleanedPhoneNumber.isEmpty()) {
              if (!cleanedPhoneNumber.matches("\\d+")) { // Check if it contains only digits
                  JOptionPane.showMessageDialog(rootPane, "Invalid phone number format. Please enter a valid number.");
                  return; // Stop further processing if the phone number has non-digit characters
              }

              try {
                  int NoHPmember = Integer.parseInt(cleanedPhoneNumber);
                  // Continue with the rest of your code, e.g., calling CreateMember.CreateDataMember
                  CreateMember.CreateDataMember(Namamember, NoHPmember, Emailmember, Domisilimember, rootPane);
                  refreshTable();
              } catch (NumberFormatException e) {
                  JOptionPane.showMessageDialog(rootPane, "Invalid phone number format. Please enter a valid number.");
                  e.printStackTrace();
              }
          } else {
              JOptionPane.showMessageDialog(rootPane, "Please fill in all the input fields.");
          }
      } catch (HeadlessException e) {
          e.printStackTrace();
      }         
    }//GEN-LAST:event_btnSimpanMemberActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        // TODO add your handling code here:
        Menu menu = new Menu(nama);
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnHapusMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusMemberActionPerformed
        // TODO add your handling code here:
        // Get the selected row index from the displayed table
        int selectedRow = tabelDataMember.getSelectedRow();

        // Check if a row is selected
        if (selectedRow != -1) {
            // Get the member ID from the first column of the selected row
            String memberIdToDeleteString = (String) tabelDataMember.getValueAt(selectedRow, 0);
            int memberIdToDelete = Integer.parseInt(memberIdToDeleteString);


            // Call the deleteDataMember method with the extracted member ID
            DeleteMember.deleteDataMember(memberIdToDelete, rootPane);

            // Remove the selected row from the table
            DefaultTableModel tabel = (DefaultTableModel) tabelDataMember.getModel();
            tabel.removeRow(selectedRow);

            InputKode.setText("");
            InputNama.setText("");
            InputHandphone.setText("");
            InputEmail.setText("");
            InputDomisili.setText("");
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Please select a row to delete.");
        }
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelDataMember;
    private javax.swing.JLabel usernameAdmin;
    // End of variables declaration//GEN-END:variables
}
