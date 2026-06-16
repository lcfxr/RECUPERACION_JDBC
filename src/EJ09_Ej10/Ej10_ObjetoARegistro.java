package EJ09_Ej10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ej10_ObjetoARegistro {
    public static void main(String[] args) {
        Alumno alumno = new Alumno(4, "Daniel", 7.8);
        String url="jdbc:sqlite:academia.db";
        String sql="INSERT INTO alumnos (id, nombre, nota) VALUES(?,?,?);";

        try(Connection conexion=DriverManager.getConnection(url);
            PreparedStatement stmt =conexion.prepareStatement(sql)) {
                stmt.setInt(1, alumno.getId());
                stmt.setString(2, alumno.getNombre());
                stmt.setDouble(3, alumno.getNota()); 
                int filasAfectadas=stmt.executeUpdate();
                System.out.println("Filas afectadas: "+filasAfectadas);           
        } catch (SQLException e) {
           System.out.println("Error de conexion");
           System.out.println(e.getMessage());
        }
    }
    
}
