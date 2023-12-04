package databaseMember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import koneksi.KoneksiDB;

public class CreateMember {
    public static void CreateDataMember(String Namamember, String Emailmember, String NoHPmember, String Domisilimember) {
        try {
            Connection koneksi = KoneksiDB.getConnection();

            String insertQuery = "INSERT INTO member (nama_member, no_hp, email, domisili) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = koneksi.prepareStatement(insertQuery);

            int rowCount = preparedStatement.executeUpdate();
            if (rowCount > 0) {
                System.out.println("Data anggota berhasil dimasukkan ke dalam database.");
            } else {
                System.out.println("Data anggota gagal dimasukkan ke dalam database.");
            }

            preparedStatement.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
