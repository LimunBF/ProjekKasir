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

/**
 *
 * @author Limun
 */
public class DeleteMember {
    public static void deleteDataMember(int id_member, JRootPane rootPane) {
        try {
            Connection koneksi = KoneksiDB.getConnection();

            // Modify the DELETE query based on your database schema
            String deleteQuery = String.format("DELETE FROM barang WHERE id_member = \"%s\";", id_member);
            PreparedStatement preparedStatement = koneksi.prepareStatement(deleteQuery);
            int rowCount = preparedStatement.executeUpdate();
            if (rowCount > 0) {
                System.out.println("Data anggota berhasil dihapus dari database.");
                JOptionPane.showMessageDialog(rootPane, "HAPUS DATA BERHASIL");
            } else {
                System.out.println("Data anggota tidak ditemukan atau gagal dihapus dari database.");
                JOptionPane.showMessageDialog(rootPane, "Sedang Dalam Proses Peminjaman");
            }

            preparedStatement.close();
            koneksi.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
