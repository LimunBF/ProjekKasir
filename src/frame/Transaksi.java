/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frame;

/**
 *
 * @author ACER
 */
import databaseBarang.TampilDataBarang;
import databaseMember.TampilDataMember;
import databaseTransaksi.CreateDbTransaksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import databaseTransaksi.TampilTransaksiData;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Transaksi extends javax.swing.JFrame {
    

    /**
     * Creates new form Transaksi
     */
    
    TampilTransaksiData tampilData = new TampilTransaksiData();
    int selectedRow = -1;
    int nomorTabel = 1;
    Boolean isMember = false;
    int hargaKeseluruhan = 0;
    int diskon = 0;
    int total = 0;
    String nama;
    int jumlahBarang = 0;
    
    public Transaksi(String nama) {
        initComponents();
        this.nama = nama;
        this.usernameAdmin.setText(this.nama);
        txtKodeBarang.getDocument().addDocumentListener(kodeBarangListener);
        txtJumlahBarang.getDocument().addDocumentListener(totalHargaListener);
        txtKodeMember.getDocument().addDocumentListener(kodeMemberListener);
        txtNamaBarang.setFocusable(false);
        txtHargaBarang.setFocusable(false);
        txtTotalHargaBarang.setFocusable(false);
        txtSubtotal.setFocusable(false);
        txtDiskon.setFocusable(false);
        txtTotal.setFocusable(false);
        String[] columns = {
        "No",
        "Kode Barang", 
        "Nama Barang", 
        "Harga Barang", 
        "QTY",
        "Total Harga",
        };   
        DefaultTableModel modeltabel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        this.tblTransaksi.setModel(modeltabel);
//        ResultSet rs = tampilData.tampilkanDataSemuaTransaksi();
//        
//        try {
//            int i = 0;
//            if (rs != null) {  // Add this check
//                while (rs.next()) {
//                    modeltabel.addRow(new Object[]{i, rs.getString("kode_barang"), txtNamaBarang.getText(),
//                        rs.getString("no_hp"), rs.getString("email"), rs.getString("domisili")});
//                    i++;
//                }
//            }
//        } catch (SQLException e) {
//            System.out.println("Pesan Error : " + e.getMessage());
//        }
        setVisible(true);
    }
    
    DocumentListener kodeBarangListener = new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent evt) {
            onChange();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            onChange();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            onChange();
        }
        void onChange() {
            String kodeBarang = txtKodeBarang.getText();
            TampilDataBarang dbBarang = new TampilDataBarang();
            ResultSet rs = dbBarang.tampilkanDataBarang(kodeBarang);
            try {
                if(rs.next()) {
                    String namaBarang = rs.getString("nama_barang");
                    String hargaBarang = rs.getString("harga_barang");
                    jumlahBarang = rs.getInt("jumlah_barang");
                    txtNamaBarang.setText(namaBarang);
                    txtHargaBarang.setText(hargaBarang);
                    txtJumlahBarang.requestFocus();
                } else {
                    jumlahBarang = 0;
                    txtNamaBarang.setText("");
                    txtHargaBarang.setText("");
                    txtTotalHargaBarang.setText("");
                }
            } catch (SQLException e) {
                
            }
        }
    };
    
    DocumentListener totalHargaListener = new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            onChange();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            onChange();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            onChange();
        }
        
        void onChange() {
            if(txtJumlahBarang.getText().length() > 0) {
                Integer jumlahBarang = Integer.valueOf(txtJumlahBarang.getText());
                Integer hargaBarang = Integer.valueOf(txtHargaBarang.getText());
                String totalHarga = String.valueOf(hargaBarang * jumlahBarang);
                txtTotalHargaBarang.setText(totalHarga); 
            } else {
                txtTotalHargaBarang.setText("0");
            }
        }
};
    DocumentListener kodeMemberListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                onChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                onChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                onChange();
            }
            
            void onChange() {
                TampilDataMember dbMember = new TampilDataMember();
                ResultSet rs = dbMember.tampilkanDataMember(txtKodeMember.getText());
                try {
                    isMember = rs.next();
                    if(isMember) {
                        diskon = hargaKeseluruhan/10;
                        txtDiskon.setText("(10%) "+diskon);
                        txtTotal.setText(""+(hargaKeseluruhan-diskon));
                        total = hargaKeseluruhan - diskon;
                    } else {
                        txtDiskon.setText("");
                        txtTotal.setText(""+hargaKeseluruhan);
                    }
                } catch (SQLException e) {
                    isMember = false;
                }
            }
        };
    
    private void refreshTable() {
        DefaultTableModel tabelData = (DefaultTableModel) tblTransaksi.getModel();
        tabelData.setRowCount(0); // Clear the table
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogKonfirmasi = new javax.swing.JDialog();
        lbltotalharga = new java.awt.Label();
        txttitle = new java.awt.Label();
        lbotalharga1 = new java.awt.Label();
        lblkembalian = new java.awt.Label();
        btniya = new javax.swing.JButton();
        btntidak = new javax.swing.JButton();
        txttotalharga = new java.awt.Label();
        txtjumlahkembali = new java.awt.Label();
        txtuangpembeli = new java.awt.Label();
        dialogError = new javax.swing.JDialog();
        jLabel9 = new javax.swing.JLabel();
        btnError = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtKodeBarang = new javax.swing.JTextField();
        txtTotalHargaBarang = new javax.swing.JTextField();
        txtJumlahBarang = new javax.swing.JTextField();
        txtHargaBarang = new javax.swing.JTextField();
        txtNamaBarang = new javax.swing.JTextField();
        txtKodeMember = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnInput = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        usernameAdmin = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransaksi = new javax.swing.JTable();
        btnBayar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDiskon = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtBayar = new javax.swing.JTextField();
        btnKembali = new javax.swing.JButton();

        lbltotalharga.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        lbltotalharga.setText("Uang Pembeli");

        txttitle.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        txttitle.setName(""); // NOI18N
        txttitle.setText("Konfirmasi Pembayaran");

        lbotalharga1.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        lbotalharga1.setText("Total Harga");

        lblkembalian.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        lblkembalian.setText("Jumlah Kembalian");

        btniya.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btniya.setText("IYA");
        btniya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btniyaActionPerformed(evt);
            }
        });

        btntidak.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btntidak.setText("TIDAK");
        btntidak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntidakActionPerformed(evt);
            }
        });

        txttotalharga.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        txttotalharga.setText("0");

        txtjumlahkembali.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        txtjumlahkembali.setText("0");

        txtuangpembeli.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        txtuangpembeli.setText("0");

        javax.swing.GroupLayout dialogKonfirmasiLayout = new javax.swing.GroupLayout(dialogKonfirmasi.getContentPane());
        dialogKonfirmasi.getContentPane().setLayout(dialogKonfirmasiLayout);
        dialogKonfirmasiLayout.setHorizontalGroup(
            dialogKonfirmasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogKonfirmasiLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(dialogKonfirmasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblkembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbotalharga1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbltotalharga, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(dialogKonfirmasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttotalharga, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtjumlahkembali, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtuangpembeli, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(206, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogKonfirmasiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(dialogKonfirmasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogKonfirmasiLayout.createSequentialGroup()
                        .addComponent(txttitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(264, 264, 264))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogKonfirmasiLayout.createSequentialGroup()
                        .addComponent(btniya, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btntidak, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(297, 297, 297))))
        );
        dialogKonfirmasiLayout.setVerticalGroup(
            dialogKonfirmasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogKonfirmasiLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(txttitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(dialogKonfirmasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbotalharga1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttotalharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogKonfirmasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbltotalharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtuangpembeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(dialogKonfirmasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblkembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtjumlahkembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(dialogKonfirmasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntidak, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btniya, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(295, Short.MAX_VALUE))
        );

        lbltotalharga.getAccessibleContext().setAccessibleName("Total Harga :");

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel9.setText("Uang Pembayaran Kurang");

        btnError.setText("OK");
        btnError.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnErrorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogErrorLayout = new javax.swing.GroupLayout(dialogError.getContentPane());
        dialogError.getContentPane().setLayout(dialogErrorLayout);
        dialogErrorLayout.setHorizontalGroup(
            dialogErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogErrorLayout.createSequentialGroup()
                .addGroup(dialogErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogErrorLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel9))
                    .addGroup(dialogErrorLayout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(btnError, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        dialogErrorLayout.setVerticalGroup(
            dialogErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogErrorLayout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(49, 49, 49)
                .addComponent(btnError)
                .addGap(83, 83, 83))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));

        txtKodeBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodeBarangActionPerformed(evt);
            }
        });

        txtNamaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaBarangActionPerformed(evt);
            }
        });

        jLabel2.setText("Kode Member");

        jLabel3.setText("Barang");

        btnInput.setText("Tambah");
        btnInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInputActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Kasir : ");

        usernameAdmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        usernameAdmin.setText("username");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Rp0");

        tblTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Kode Barang", "Nama Barang", "Harga Barang", "QTY", "Total Harga"
            }
        ));
        jScrollPane1.setViewportView(tblTransaksi);

        btnBayar.setText("Bayar");
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });

        jLabel4.setText("Subtotal");

        jLabel5.setText("Diskon");

        txtDiskon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiskonActionPerformed(evt);
            }
        });

        jLabel6.setText("Total");

        jLabel7.setText("Bayar");

        btnKembali.setText("KEMBALI");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usernameAdmin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNamaBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtHargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtJumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTotalHargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtKodeMember, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnInput, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnKembali)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtBayar)
                            .addComponent(txtTotal, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSubtotal)
                            .addComponent(txtDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnBayar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(usernameAdmin)
                        .addComponent(jLabel8))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKodeMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalHargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(btnInput)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(btnKembali)))
                    .addComponent(btnBayar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtKodeBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodeBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodeBarangActionPerformed

    private void txtDiskonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiskonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiskonActionPerformed

    private void btnInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInputActionPerformed
        try {
          String kodeBarang = txtKodeBarang.getText();
          String namaBarang = txtNamaBarang.getText();
          String hargaBarang = txtHargaBarang.getText();
          String qty = txtJumlahBarang.getText();
          String totalHarga = txtTotalHargaBarang.getText();
          if (!kodeBarang.isEmpty() && !namaBarang.isEmpty() && !hargaBarang.isEmpty() && !qty.isEmpty() && !totalHarga.isEmpty()) {
              if(jumlahBarang < Integer.parseInt(qty)) {
                  JOptionPane.showMessageDialog(rootPane, "Stok Barang Tidak Cukup");
              } else {
                TampilTransaksiData updbrg = new TampilTransaksiData();
                updbrg.updatebarang(jumlahBarang-(Integer.parseInt(qty)), (Integer.valueOf(kodeBarang)));
                DefaultTableModel tabelData = (DefaultTableModel) tblTransaksi.getModel();
                tabelData.addRow(new Object[]{nomorTabel, kodeBarang, namaBarang, hargaBarang, qty, totalHarga});
                hargaKeseluruhan = Integer.valueOf(jLabel1.getText().substring(2))+Integer.valueOf(totalHarga);
                jLabel1.setText("Rp"+hargaKeseluruhan);
                txtSubtotal.setText(""+hargaKeseluruhan);
                if(isMember) {  
                    diskon = hargaKeseluruhan/10;
                    txtDiskon.setText("(10%) "+diskon);
                }
                total = hargaKeseluruhan - diskon;
                txtTotal.setText(""+total);
                nomorTabel++;
                
                // clear form
                txtKodeBarang.setText("");
                txtNamaBarang.setText("");
                txtHargaBarang.setText("");
                txtTotalHargaBarang.setText("");
                txtJumlahBarang.setText("");
                txtKodeBarang.requestFocus();
              }
                
          } else {
              JOptionPane.showMessageDialog(rootPane, "Please fill in all the input fields.");
          }
      } catch (HeadlessException e) {
          e.printStackTrace();
      }   
    }//GEN-LAST:event_btnInputActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        Menu menu = new Menu(nama);
        menu.setVisible(true);
        txtKodeBarang.getDocument().removeDocumentListener(kodeBarangListener);
        txtJumlahBarang.getDocument().removeDocumentListener(totalHargaListener);
        dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void txtNamaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaBarangActionPerformed

    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarActionPerformed
        // TODO add your handling code here:
        // 1. Tampilkan jDialog buat hitung kembalian
        // 2. Generate file pdf
        // 3. Simpan file pdf di dalam folder yang ditentuka C:/Download/Riwayat Transaksi/[id_transaksi].pdf
        // 4. Simpan data-data di atas kedalam tabel transaksi
        
        int bayar = Integer.parseInt(txtBayar.getText());
        if(bayar < total) {
            dialogError.setSize(450, 250);
            dialogError.setVisible(true);
        } else {
            int kembali = bayar - total;
            txttotalharga.setText("Rp "+total);
            txtuangpembeli.setText("Rp "+bayar);
            txtjumlahkembali.setText("Rp "+kembali);
            dialogKonfirmasi.setSize(600, 600);
            dialogKonfirmasi.setVisible(true);
        }
    }//GEN-LAST:event_btnBayarActionPerformed

    private void btniyaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniyaActionPerformed
        CreateDbTransaksi db = new CreateDbTransaksi();
        ArrayList<HashMap> listBarang = new ArrayList();
        int qty = 0;
        int rows = tblTransaksi.getRowCount();
        for(int i = 0; i < rows; i++) {
            qty += Integer.parseInt(tblTransaksi.getValueAt(i,4).toString());
            String kodeBarang = tblTransaksi.getValueAt(i, 1).toString();
            String jml = tblTransaksi.getValueAt(i, 4).toString();
            HashMap barang = new HashMap();
            barang.put("kode_barang", kodeBarang);
            barang.put("jml", jml);
            listBarang.add(barang);
        }
        
        String kodeMember = txtKodeMember.getText();
        System.out.println("Kode Member: "+ kodeMember+ "|| qty" + qty);
        db.inputDataTransaksi(kodeMember, total, qty, listBarang, rootPane);
          Menu menu = new Menu(nama);
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_btniyaActionPerformed

    private void btnErrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnErrorActionPerformed
        dialogError.setVisible(false);
    }//GEN-LAST:event_btnErrorActionPerformed

    private void btntidakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntidakActionPerformed
        dialogKonfirmasi.setVisible(false);
    }//GEN-LAST:event_btntidakActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBayar;
    private javax.swing.JButton btnError;
    private javax.swing.JButton btnInput;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btniya;
    private javax.swing.JButton btntidak;
    private javax.swing.JDialog dialogError;
    private javax.swing.JDialog dialogKonfirmasi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label lblkembalian;
    private java.awt.Label lbltotalharga;
    private java.awt.Label lbotalharga1;
    private javax.swing.JTable tblTransaksi;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtDiskon;
    private javax.swing.JTextField txtHargaBarang;
    private javax.swing.JTextField txtJumlahBarang;
    private javax.swing.JTextField txtKodeBarang;
    private javax.swing.JTextField txtKodeMember;
    private javax.swing.JTextField txtNamaBarang;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotalHargaBarang;
    private java.awt.Label txtjumlahkembali;
    private java.awt.Label txttitle;
    private java.awt.Label txttotalharga;
    private java.awt.Label txtuangpembeli;
    private javax.swing.JLabel usernameAdmin;
    // End of variables declaration//GEN-END:variables
}
