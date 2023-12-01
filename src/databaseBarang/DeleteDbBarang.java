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
public class DeleteDbBarang {
    String url = "jdbc:mysql://localhost:3306/database_kasir";
    String username = "root";
    String password = "";
    
    public void deleteDataBarang(int kode_barang, JRootPane rootPane){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection koneksi = DriverManager.getConnection(url,username,  password);
            String query = String.format("delete from barang where kode_barang = \"%s\";", kode_barang);
            Statement st = koneksi.createStatement();
            st.executeUpdate(query);
            st.close();
            System.out.println("Koneksi ditutup...");
            JOptionPane.showMessageDialog(rootPane, "HAPUS DATA BERHASIL");

         }catch (ClassNotFoundException | SQLException ex){
           System.out.println("Terdapat Error : "+ex.getMessage());  
           JOptionPane.showMessageDialog(rootPane, "Sedang Dalam Proses Peminjaman");
       }
    }
}
