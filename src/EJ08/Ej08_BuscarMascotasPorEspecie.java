package EJ08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ej08_BuscarMascotasPorEspecie {
    public static void main(String[] args) {
        String especieBuscada = "Perro";
        String url="jdbc:sqlite:clinica.db";
        String sql="SELECT id, nombre, especie, edad FROM mascotas WHERE especie = ?;";

        try(Connection conexion =DriverManager.getConnection(url);
            PreparedStatement stmt =conexion.prepareStatement(sql)){
                stmt.setString(1, especieBuscada);
                try(ResultSet rs = stmt.executeQuery()){
                    while(rs.next()){
                        String nombre=rs.getString("nombre");
                        int edad=rs.getInt("edad");
                        System.out.println(nombre+ " - " +edad+ " años");
                    }
                }
            
        } catch (SQLException e) {
            System.out.println("Error de conexion");
            System.out.println(e.getMessage());
        }
    }
    
}
