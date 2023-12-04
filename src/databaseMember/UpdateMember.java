/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseMember;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import koneksi.KoneksiDB;

/**
 *
 * @author Limun
 */
public class UpdateMember {
    public void updateDataMember(int id_member, String nama_member, int no_hp, String email, String domisili, JRootPane rootPane){
        try{
            Connection koneksi = KoneksiDB.getConnection();
            String insertQuery = String.format("UPDATE member SET id_member = \"%s\", nama_member = \"%s\", no_hp = \"%s\", domisili = \"%s\" , email = \"%s\" WHERE id_member = \"%s\";",id_member, nama_member, no_hp, email, domisili, id_member);
            PreparedStatement preparedStatement = koneksi.prepareStatement(insertQuery);
            
            System.out.println("Koneksi ditutup...");
            JOptionPane.showMessageDialog(rootPane, "EDIT DATA BERHASIL");
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println("Terdapat Error : "+ex.getMessage());  
            JOptionPane.showMessageDialog(rootPane, "EDIT DATA GAGAL");
       }
    }
    
}
