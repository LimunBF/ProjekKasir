package databaseAdmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import koneksi.KoneksiDB;

public class CRUDAdmin {

    public static boolean checkCredentials(String username, String password) {
        try {
            Connection connection = KoneksiDB.getConnection();
            String query = "SELECT * FROM admin WHERE username = ? AND password = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                ResultSet resultSet = preparedStatement.executeQuery();
                return resultSet.next();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public static boolean exists(String username) {
        try {
            Connection koneksi = KoneksiDB.getConnection();

            String checkquery = "SELECT id FROM admin WHERE username = ?";

            try (PreparedStatement preparedStatement = koneksi.prepareStatement(checkquery)) {
                preparedStatement.setString(1, username);
                ResultSet resultSet = preparedStatement.executeQuery();
                return resultSet.next();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public static void createDataAdmin(String username, String password, JRootPane rootPane) {
        try {
            Connection koneksi = KoneksiDB.getConnection();

            // Check if the username already exists
            if (exists(username)) {
                JOptionPane.showMessageDialog(rootPane, "Username already exists. Please choose a different username.");
            } else {
                // Insert the new admin data
                String insertQuery = "INSERT INTO admin (username, password) VALUES (?, ?)";
                try (PreparedStatement preparedStatement = koneksi.prepareStatement(insertQuery)) {
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, password);

                    int rowCount = preparedStatement.executeUpdate();
                    if (rowCount > 0) {
                        System.out.println("Data admin berhasil dimasukkan ke dalam database.");
                        JOptionPane.showMessageDialog(rootPane, "Account created successfully.");
                    } else {
                        System.out.println("Data admin gagal dimasukkan ke dalam database.");
                        JOptionPane.showMessageDialog(rootPane, "Failed to create account. Please try again.");
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(rootPane, "An error occurred. Please try again.");
        }
    }
}
