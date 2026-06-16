package EJ09_Ej10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Ej09_FilaAObjeto {
    public static void main(String[] args) {
        String url="jdbc:sqlite:academia.db";
        String sql="SELECT id, nombre, nota FROM alumnos ;";

        try(Connection conexion = DriverManager.getConnection(url);
            Statement stmt = conexion.createStatement();
            ResultSet rs =stmt.executeQuery(sql)) {
                System.out.println("Conexion establecida");
                while(rs.next()){
                    int id =rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    double nota=rs.getDouble("nota");
                    Alumno alumno = new Alumno(id, nombre, nota);
                    System.out.println(alumno.getNombre()+ " - " +alumno.getNota());
                }            
        } catch (SQLException e) {
            System.out.println("Error de conexion");
            System.out.println(e.getMessage());
        }
    }
    
}
