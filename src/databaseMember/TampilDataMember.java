/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseMember;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    
    public ResultSet tampilkanDataMember(String id_member) {
        try {
            Connection koneksi = KoneksiDB.getConnection();
            String readquery = "SELECT * FROM member WHERE id_member = ?";

            PreparedStatement preparedStatement = koneksi.prepareStatement(readquery);
            preparedStatement.setString(1, id_member);

            this.rs = preparedStatement.executeQuery();
            return this.rs;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Terdapat Error: " + ex.getMessage());
        }
        return this.rs;
    }
    
    public ResultSet tampilkanDataSemuaMember(){
        
        try{
            Connection koneksi = KoneksiDB.getConnection();
            String readallquery = String.format("SELECT * FROM member");
            PreparedStatement preparedStatement = koneksi.prepareStatement(readallquery);
            
            this.rs = preparedStatement.executeQuery();
            return this.rs;
        }catch (ClassNotFoundException | SQLException ex){
           System.out.println("Terdapat Error : "+ex.getMessage());  
            }
        return this.rs;
    }
    
    public int getLatestMemberId() {
        int latestId = 0;

        try {
            Connection koneksi = KoneksiDB.getConnection();
            String getLinesquery = "SELECT MAX(id_member) as latest_id FROM member";
            PreparedStatement preparedStatement = koneksi.prepareStatement(getLinesquery);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                latestId = resultSet.getInt("latest_id");
            }

            resultSet.close();
            preparedStatement.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return latestId;
    }
}
