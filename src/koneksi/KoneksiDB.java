package koneksi;

import java.sql.*;

public class KoneksiDB {
    private static String url = "jdbc:mysql://localhost:3306/database_kasir";
    private static String username = "root";
    private static String password = "";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }
}
//cekk