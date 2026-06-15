package EJ03;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ej03_ConsultarLibros {
    public static void main(String[] args) {
        String url="jdbc:sqlite:biblioteca.db";
        String consulta="SELECT id, titulo, autor, precio FROM libros;";

        try(Connection conexion = DriverManager.getConnection(url);
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(consulta)) {
            System.out.println("Conexion establecida");
            while(rs.next()){
                int id=rs.getInt("id");
                String titulo =rs.getString("titulo");
                String autor = rs.getString("autor");
                double precio = rs.getDouble("precio");
                 System.out.println(id + " - " + titulo + " - " + autor + " - " + precio + " €");
            }
        } catch (SQLException e) {
            System.out.println("Error de conexion");
            System.out.println(e.getMessage());
        }
    }
    
}
