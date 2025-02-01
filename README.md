# ApplicationDistrib
Devoir 1 Application Distribuees Karen Khoury 220402

Proving my identity : C:\Users\User>prompt KarenKhoury$G

Software and version used:
PostgreSQL	16.6
Java JDK	java version "18.0.2.1" 2022-08-18
PostgreSQL JDBC Driver	42.7.5

Etape 1: 
Instalation de Postgresql

Etape 2 : 
Instalation du driver jdbc postgres et le placer dans le fichier de mon project
 

Etape 3:
Adding psql to my environement variable path so I can run it from cmd
 

Success of installation of Postgress 16:
 

Etape 4: 
Creer la base de donne dans PosgreSQL
CREATE DATABASE ma_base;
 


Creation du code Java :
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

1)	Créer le nouveau fichier pour le project
2)	Placer le JDBC .jar file dans ce fichier
3)	Copier Coller le code procurer par ChatGPT
4)	Compiler : javac -cp ".;postgresql-42.7.5.jar" PostgreSQLJDBC.java
5)	Run avec : java -cp ".;postgresql-42.7.5.jar" PostgreSQLJDBC

 
SUCCES DU CODE ! 
Nous avons fait SELECT version();
PS C:\Users\User\Desktop\karen\Universite-Etudes\Semestre 8\Application distribuees\jdbcpostgresDevoir1> java -cp ".;postgresql-42.7.5.jar" PostgreSQLJDBC
PostgreSQL Version: PostgreSQL 16.6, compiled by Visual C++ build 1942, 64-bit
