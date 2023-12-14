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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
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
    
    public void inputDataTransaksi(String idMember, int totalHarga, int qty, ArrayList<HashMap> listBarang, JRootPane rootPane){
        try (Connection koneksi = KoneksiDB.getConnection()) {
            String insertQuery = "INSERT INTO transaksi (tanggal_transaksi, id_member, total_harga, qty) VALUES (NOW(), ?, ?, ?);";
            try (PreparedStatement preparedStatement = koneksi.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
                // Set parameters
                preparedStatement.setString(1, idMember.isEmpty() ? null : idMember);
                preparedStatement.setInt(2, totalHarga);
                preparedStatement.setInt(3, qty);

                preparedStatement.executeUpdate();
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    int faktur = rs.getInt(1);
                    for(int i = 0; i< listBarang.size(); i++) {
                        HashMap barang = listBarang.get(i);
                        String kode_barang = barang.get("kode_barang").toString();
                        String jml = barang.get("jml").toString();
                        String query="INSERT INTO transaksi_barang (faktur, kode_barang, qty) VALUES ("+faktur+", "+kode_barang+ ", " + jml +");";
                        PreparedStatement ps = koneksi.prepareStatement(query);
                        ps.executeUpdate();
                    }
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
