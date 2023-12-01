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

/**
 *
 * @author ACER
 */
public class TampilDataBarang {
    String url = "jdbc:mysql://localhost:3306/database_kasir";
    String username = "root";
    String password = "";
    private ResultSet rs;
    
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
}
