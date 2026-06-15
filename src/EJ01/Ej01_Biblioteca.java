import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
public class Ej01_Biblioteca{
    public static void main(String[] args) {
        String url="jdbc:sqlite:biblioteca.db";
        try(Connection conexion = DriverManager.getConnection(url)){
            System.out.println("Conexion establecida");
        }catch(SQLException e){
            System.out.println("Error de conexion");
            System.out.println(e.getMessage());
        }
        
    }
    
}