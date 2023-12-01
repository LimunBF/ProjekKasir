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
    private ResultSet rs;
    
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
     
    
    
    public ResultSet tampilkanDataBarang (String kode_barang){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection koneksi = DriverManager.getConnection(url,username,  password);
            String query = String.format("select * from barang where kode_barang = \"%s\";", kode_barang);
            Statement st = koneksi.createStatement();
            this.rs = st.executeQuery(query);
            return this.rs;
         }catch (ClassNotFoundException | SQLException ex){
           System.out.println("Terdapat Error : "+ex.getMessage());  
       }
        return this.rs;
    }
     
    public ResultSet tampilkanDataSemuaBarang(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection koneksi = DriverManager.getConnection(url,username,  password);
            String query = String.format("select * from barang");
            Statement st = koneksi.createStatement();
            this.rs = st.executeQuery(query);
            return this.rs;
         }catch (ClassNotFoundException | SQLException ex){
           System.out.println("Terdapat Error : "+ex.getMessage());  
       }
        return this.rs;
    }
    
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
