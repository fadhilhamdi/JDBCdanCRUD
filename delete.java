import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class delete {

    private static final String URL = "jdbc:mysql://localhost:3306/kartu_keluarga";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void deletekkByNIK() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "DELETE FROM kk WHERE NIK = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                Scanner del = new Scanner(System.in);
                System.out.println("----MENGHAPUS DATA LOGIN PEGAWAI----");
                System.out.print("Masukkan NIK pegawai untuk dihapus: ");
                int kkNIK = del.nextInt();
                preparedStatement.setInt(1, kkNIK);
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Data pegawai berhasil dihapus!");
                } else {
                    System.out.println("Tidak ditemukan data pegawai dengan NIK tersebut.");
                }
        
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
