/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseTransaksi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import koneksi.KoneksiDB;

/**
 *
 * @author Limun
 */
public class TampilTransaksiData {
    private ResultSet rs;
    
    public ResultSet tampilkanDataSemuaTransaksi(){
        try{
            Connection koneksi = KoneksiDB.getConnection();
            String readallquery = String.format("SELECT * FROM transaksi");
            PreparedStatement preparedStatement = koneksi.prepareStatement(readallquery);
            
            this.rs = preparedStatement.executeQuery();
            return this.rs;
        }catch (ClassNotFoundException | SQLException ex){
           System.out.println("Terdapat Error : "+ex.getMessage());  
            }
        return this.rs;
    }
}
