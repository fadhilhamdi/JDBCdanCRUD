import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class update {

    //Driver
    private static final String URL = "jdbc:mysql://localhost:3306/kartu_keluarga";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    
    public static void updatekkCredentials(Scanner scanner) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "UPDATE kk SET nama = ?, jenis_kelamin = ?, tempat_lahir = ? WHERE NIK = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                System.out.println("----UPDATE DATA LOGIN PEGAWAI----");
                System.out.print("NIK: ");
                int NIK = scanner.nextInt();
                
                System.out.print("Nama: ");
                String newnama = scanner.next();

                System.out.print("Jenis Kelamin: ");
                String newjkl = scanner.next();

                 System.out.print("Tempat Lahir: ");
                String newtl = scanner.next();

                preparedStatement.setInt(4, NIK);
                preparedStatement.setString(1, newnama);
                preparedStatement.setString(2, newjkl);
                preparedStatement.setString(3, newtl);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Data login pegawai diupdate!");
                } else {
                    System.out.println("Tidak ditemukan data pegawai dengan id tersebut");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
