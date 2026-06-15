package EJ04;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ej04_LibrosCaros{
    public static void main(String[]args){
        String url ="jdbc:sqlite:biblioteca.db";
        String sql="SELECT id, titulo, autor, precio FROM libros WHERE precio>20;";

        try(Connection conexion = DriverManager.getConnection(url);
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
                boolean hayResultados=false;
                System.out.println("Conexion establecida");
                while(rs.next()){
                    String id = rs.getString("id");
                    String titulo=rs.getString("titulo");
                    String autor=rs.getString("autor");
                    double precio = rs.getDouble("precio");
                    if(precio>20){
                        hayResultados=true;
                        System.out.println(titulo+ " - " +autor+ " - " +precio);
                    }else{
                        System.out.println("No se han encontrado libros con ese precio");
                    }
                    System.out.println(hayResultados);
                }
            
        } catch (SQLException e) {
            System.out.println("Error de conexion");
            System.out.println(e.getMessage());
        }
    }
}
