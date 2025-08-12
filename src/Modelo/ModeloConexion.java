
package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ModeloConexion {
        public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=EducacionAmbiental;encrypt=true;trustServerCertificate=true";
        String usuario = "sa";
        String contrasena = "123456789a";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contrasena)) {
            System.out.println("Conexion exitosa a SQL Server");
        } catch (SQLException e) {
            System.out.println("Error de conexion: " + e.getMessage());
        }
    }
    
}
