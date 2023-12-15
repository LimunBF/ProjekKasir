/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frame;

import javax.swing.table.DefaultTableModel;
import databaseTransaksi.TampilTransaksiData;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author acer
 */
public class DaftarTransaksi extends javax.swing.JFrame {
    private String name;

    /**
     * Creates new form DaftarTransaksi
     * @param name
     */
    public DaftarTransaksi(String name) {
        System.out.println(name);
        initComponents();
        this.name = name;
        this.usernameAdmin.setText(" "+this.name);
        
        String[] columns = {
        "No",
        "No Faktur", 
        "Tanggal", 
        "Barang", 
        "Jumlah",
        "Member",
        "Nominal",
        };   
        DefaultTableModel modeltabel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        this.jTable1.setModel(modeltabel);
        TampilTransaksiData db = new TampilTransaksiData();
        ResultSet rs = db.tampilkanDataSemuaTransaksi();
        
        try {
            int i = 0;
            if (rs != null) {  // Add this check
                while (rs.next()) {
                    modeltabel.addRow(new Object[]{i+1, rs.getString("faktur"), rs.getString("tanggal_transaksi"), 
                        rs.getString("id_member"), rs.getString("kode_transaksi_barang"), 
                        rs.getString("total_harga"),rs.getString("qty")});
                    i++;
                }
            }
        } catch (SQLException e) {
            System.out.println("Pesan Error : " + e.getMessage());
        }
        setVisible(true);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        usernameAdmin = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtCariTransaksi = new javax.swing.JTextField();
        btnCariTransaksi = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 153));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("DAFTAR TRANSAKSI");

        usernameAdmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        usernameAdmin.setText("username");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Selamat datang");

        jTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "No. Faktur", "Tanggal", "Barang", "Jumlah", "Member", "Nominal"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        txtCariTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariTransaksiActionPerformed(evt);
            }
        });

        btnCariTransaksi.setText("Cari");
        btnCariTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariTransaksiActionPerformed(evt);
            }
        });

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCariTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCariTransaksi)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnKembali)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(usernameAdmin)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCariTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCariTransaksi))
                .addGap(4, 4, 4)
                .addComponent(btnKembali)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCariTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariTransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariTransaksiActionPerformed

    private void btnCariTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariTransaksiActionPerformed
        // TODO add your handling code here:
        ResultSet rs;
        if(!"".equals(txtCariTransaksi.getText())) {
            TampilTransaksiData db = new TampilTransaksiData();
            rs = db.tampiltransaksi(Integer.parseInt(txtCariTransaksi.getText()));
        } else {
            TampilTransaksiData db = new TampilTransaksiData();
            rs = db.tampilkanDataSemuaTransaksi();
        }
        
        DefaultTableModel tabel = (DefaultTableModel) jTable1.getModel();
        
        try{
            for(var i = tabel.getRowCount() - 1; i >= 0; i--) {
                tabel.removeRow(i);
            }
            while(rs.next()){
                int i = 0;
                tabel.addRow(new Object[]{i+1, rs.getInt("faktur"), rs.getString("tanggal_transaksi"), 
                        rs.getString("id_member"), rs.getString("kode_transaksi_barang"), 
                        rs.getString("total_harga"),rs.getString("qty")});
            }
            
        }catch(SQLException e){
            System.out.println("Pesan Error : " + e.getMessage());
        }
    }//GEN-LAST:event_btnCariTransaksiActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        // TODO add your handling code here:
        Menu menu = new Menu(name);
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCariTransaksi;
    private javax.swing.JButton btnKembali;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCariTransaksi;
    private javax.swing.JLabel usernameAdmin;
    // End of variables declaration//GEN-END:variables
}
