package EJ07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ej07_MascotaPreparada {
    public static void main(String[] args) {
        int id = 1; 
        String nombre = "Luna"; 
        String especie = "Gato"; 
        int edad = 3;

        String url="jdbc:sqlite:clinica.db";
        String sql="INSERT INTO mascotas (id, nombre, especie, edad) VALUES (?, ?, ?, ?);";

        try(Connection conexion = DriverManager.getConnection(url);
            PreparedStatement stmt=conexion.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.setString(2, nombre);
                stmt.setString(3, especie);
                stmt.setInt(4, edad);

                int filasAfectadas=stmt.executeUpdate();
                System.out.println("Filas insertadas: " +filasAfectadas);
            
        } catch (SQLException e) {
            System.out.println("Error de conexion");
            System.out.println(e.getMessage());
        }
    }
    
}
