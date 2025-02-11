import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSQLJDBC {
    public static void main(String[] args) {
        // Informations de connexion PostgreSQL
        String url = "jdbc:postgresql://localhost:5432/ma_base"; 
        String user = "postgres"; 
        String password = "karen"; 

        // Connexion à PostgreSQL
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT version();")) {

            // Affichage des résultats
            while (rs.next()) {
                System.out.println("PostgreSQL Version: " + rs.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
