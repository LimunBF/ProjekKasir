/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseMember;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import koneksi.KoneksiDB;

/**
 *
 * @author Limun
 */
public class TampilDataMember {
    private ResultSet rs;
    
    public ResultSet tampilkanDataMember (String id_member){
        try{
            Connection koneksi = KoneksiDB.getConnection();
            String query = String.format("SELECT * FROM member WHERE id_member = \"%s\";", id_member);
            Statement st = koneksi.createStatement();
            this.rs = st.executeQuery(query);
            return this.rs;
         }catch (ClassNotFoundException | SQLException ex){
           System.out.println("Terdapat Error : "+ex.getMessage());  
       }
        return this.rs;
    }
    
    public ResultSet tampilkanDataSemuaMember(){
        
        try{
            Connection koneksi = KoneksiDB.getConnection();
            String query = String.format("SELECT * FROM member");
            Statement st = koneksi.createStatement();
            this.rs = st.executeQuery(query);
            return this.rs;
        }catch (ClassNotFoundException | SQLException ex){
           System.out.println("Terdapat Error : "+ex.getMessage());  
            }
        return this.rs;
    }
    
}
