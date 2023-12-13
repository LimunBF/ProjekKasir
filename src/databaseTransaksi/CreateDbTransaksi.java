/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseTransaksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import koneksi.KoneksiDB;

/**
 *
 * @author ACER
 */
public class CreateDbTransaksi {
    String url = "jdbc:mysql://localhost:3306/database_kasir";
    String username = "root";
    String password = "";
    
    public void inputDataTransaksi(int kodeBarang, int idMember, int totalHarga, int qty, JRootPane rootPane){
        try (Connection koneksi = KoneksiDB.getConnection()) {
            String insertQuery = "INSERT INTO transaksi (tanggal_transaksi, kode_barang, id_member, total_harga, qty) VALUES (NOW(), ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = koneksi.prepareStatement(insertQuery)) {
                // Set parameters
                preparedStatement.setInt(1, kodeBarang);
                preparedStatement.setInt(2, idMember);
                preparedStatement.setInt(3, totalHarga);
                preparedStatement.setInt(4, qty);

                int rowCount = preparedStatement.executeUpdate();
                if (rowCount > 0) {
                    System.out.println("Data transaksi berhasil dimasukkan ke dalam database.");
                } else {
                    System.out.println("Data transaksi gagal dimasukkan ke dalam database.");
                }
                JOptionPane.showMessageDialog(rootPane, "INPUT DATA BERHASIL");
            } catch (SQLException ex) {
                // Handle PreparedStatement-related exceptions
                System.out.println("PreparedStatement Error: " + ex.getMessage());
                JOptionPane.showMessageDialog(rootPane, "INPUT DATA GAGAL");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            // Handle Connection-related exceptions
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(rootPane, "INPUT DATA GAGAL");
        }
    }
    
    public void inputDataTransaksi(int kodeBarang, int totalHarga, int qty, JRootPane rootPane){
        try (Connection koneksi = KoneksiDB.getConnection()) {
            String insertQuery = "INSERT INTO transaksi (tanggal_transaksi, kode_barang, total_harga, qty) VALUES (NOW(), ?, ?, ?)";
            try (PreparedStatement preparedStatement = koneksi.prepareStatement(insertQuery)) {
                // Set parameters
                preparedStatement.setInt(1, kodeBarang);
                preparedStatement.setInt(2, totalHarga);
                preparedStatement.setInt(3, qty);

                int rowCount = preparedStatement.executeUpdate();
                if (rowCount > 0) {
                    System.out.println("Data transaksi berhasil dimasukkan ke dalam database.");
                } else {
                    System.out.println("Data transaksi gagal dimasukkan ke dalam database.");
                }
                JOptionPane.showMessageDialog(rootPane, "INPUT DATA BERHASIL");
            } catch (SQLException ex) {
                // Handle PreparedStatement-related exceptions
                System.out.println("PreparedStatement Error: " + ex.getMessage());
                JOptionPane.showMessageDialog(rootPane, "INPUT DATA GAGAL");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            // Handle Connection-related exceptions
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(rootPane, "INPUT DATA GAGAL");
        }
    }
}
