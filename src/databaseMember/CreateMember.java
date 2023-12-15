package databaseMember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import koneksi.KoneksiDB;

public class CreateMember {
    public static void CreateDataMember(String Namamember, long NoHPmember, String Emailmember, String Domisilimember, JRootPane rootPane) {
        try (Connection koneksi = KoneksiDB.getConnection()) {
            String insertQuery = "INSERT INTO member (nama_member, no_hp, email, domisili) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = koneksi.prepareStatement(insertQuery)) {
                // Set parameters
                preparedStatement.setString(1, Namamember);
                preparedStatement.setLong(2, NoHPmember);
                preparedStatement.setString(3, Emailmember);
                preparedStatement.setString(4, Domisilimember);

                int rowCount = preparedStatement.executeUpdate();
                if (rowCount > 0) {
                    System.out.println("Data anggota berhasil dimasukkan ke dalam database.");
                } else {
                    System.out.println("Data anggota gagal dimasukkan ke dalam database.");
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