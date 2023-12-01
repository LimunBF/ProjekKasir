/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseBarang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

/**
 *
 * @author ACER
 */
public class CreatDbBarang {
    String url = "jdbc:mysql://localhost:3306/database_kasir";
    String username = "root";
    String password = "";
    
    public void inputDataBarang(int kode_barang, String nama_barang, int harga_barang, int jumlah_barang, JRootPane rootPane){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection koneksi = DriverManager.getConnection(url,username,  password);
            String query = String.format("insert into barang(kode_barang, nama_barang, harga_barang, jumlah_barang)values(\"%s\",\"%s\",\"%s\",\"%s\");",kode_barang, nama_barang, harga_barang, jumlah_barang);
            Statement st = koneksi.createStatement();
            st.executeUpdate(query);
            st.close();
            System.out.println("Koneksi ditutup...");
            JOptionPane.showMessageDialog(rootPane, "INPUT DATA BERHASIL");
         }catch (ClassNotFoundException | SQLException ex){
           System.out.println("Terdapat Error : "+ex.getMessage());  
           JOptionPane.showMessageDialog(rootPane, "INPUT DATA GAGAL");
       }
    }
}
