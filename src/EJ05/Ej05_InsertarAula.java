package EJ05;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class Ej05_InsertarAula {
    public static void main(String[] args) {
        String url="jdbc:sqlite:centro.db";
        String sql="INSERT INTO aulas (id, nombre, capacidad) VALUES (1, 'Aula Informática 1', 30);";

        try(Connection conexion = DriverManager.getConnection(url);
            Statement stmt = conexion.createStatement()) {
                int filasAfectadas = stmt.executeUpdate(sql);
                System.out.println("Filas insertadas: " +filasAfectadas);
        } catch (SQLException e) {
            System.out.println("Error de conexion");
            System.out.println(e.getMessage());
        }
    }
    
}
