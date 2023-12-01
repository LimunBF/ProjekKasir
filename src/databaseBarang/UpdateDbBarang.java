/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseBarang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

/**
 *
 * @author ACER
 */
public class UpdateDbBarang {
    String url = "jdbc:mysql://localhost:3306/database_kasir";
    String username = "root";
    String password = "";
    
    public void updateDataBarang(int kode_barang, String nama_barang, int harga_barang, int jumlah_barang, JRootPane rootPane){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection koneksi = DriverManager.getConnection(url,username,  password);
            String query = String.format("update barang set kode_barang = \"%s\", nama_barang = \"%s\", harga_barang = \"%s\", jumlah_barang = \"%s\" where kode_barang = \"%s\";",kode_barang, nama_barang, harga_barang, jumlah_barang, kode_barang);
            Statement st = koneksi.createStatement();
            st.executeUpdate(query);
            st.close();
            System.out.println("Koneksi ditutup...");
            JOptionPane.showMessageDialog(rootPane, "EDIT DATA BERHASIL");
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println("Terdapat Error : "+ex.getMessage());  
            JOptionPane.showMessageDialog(rootPane, "EDIT DATA GAGAL");
       }
    }
}
