import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class create {

    private static final String URL = "jdbc:mysql://localhost:3306/kartu_keluarga";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void insertkkData(Scanner scanNEW) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO kk (NIK, nama, jenis_kelamin, tempat_lahir) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                System.out.println("----MEMBUAT DATA LOGIN BARU----");

                System.out.print("NIK: ");
                int nikValue = scanNEW.nextInt();

                System.out.print("Nama: ");
                String namaValue = scanNEW.next();

                System.out.print("Jenis Kelamin: ");
                String jklValue = scanNEW.next();

                 System.out.print("Tempat Lahir: ");
                String tlValue = scanNEW.next();

                preparedStatement.setInt(1, nikValue);
                preparedStatement.setString(2, namaValue);
                preparedStatement.setString(3, jklValue);
                preparedStatement.setString(4, tlValue);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Berhasil menambah data login baru");
                } else {
                    System.out.println("Tidak dapat menambah data login baru");
                }

                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
