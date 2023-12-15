/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseMember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import koneksi.KoneksiDB;

public class UpdateMember {
    public void updateDataMember(int id_member, String nama_member, long no_hp, String email, String domisili, JRootPane rootPane){
        try {
            Connection koneksi = KoneksiDB.getConnection();
            String updateQuery = "UPDATE member SET nama_member = ?, no_hp = ?, email = ?, domisili = ? WHERE id_member = ?";
            PreparedStatement                     
            preparedStatement = koneksi.prepareStatement(updateQuery);
            preparedStatement.setString(1, nama_member);
            preparedStatement.setLong(2, no_hp);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, domisili);
            preparedStatement.setInt(5, id_member);

            int rowCount = preparedStatement.executeUpdate();

            if (rowCount > 0) {
                System.out.println("Data anggota berhasil diupdate dalam database.");
                JOptionPane.showMessageDialog(rootPane, "EDIT DATA BERHASIL");
            } else {
                System.out.println("Data anggota tidak ditemukan atau tidak ada perubahan.");
                JOptionPane.showMessageDialog(rootPane, "Tidak ada perubahan atau data tidak ditemukan");
            }

            preparedStatement.close();
            koneksi.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Terdapat Error : " + ex.getMessage());
            JOptionPane.showMessageDialog(rootPane, "EDIT DATA GAGAL");
        }
    }
}
