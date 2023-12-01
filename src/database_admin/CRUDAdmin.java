package database_admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public static void createDataAdmin(String username, String password) {
        try {
            Connection koneksi = KoneksiDB.getConnection();

            String insertQuery = "INSERT INTO admin (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = koneksi.prepareStatement(insertQuery);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            int rowCount = preparedStatement.executeUpdate();
            if (rowCount > 0) {
                System.out.println("Data anggota berhasil dimasukkan ke dalam database.");
            } else {
                System.out.println("Data anggota gagal dimasukkan ke dalam database.");
            }

            preparedStatement.close();
            koneksi.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public boolean exists(String username) {
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

}
