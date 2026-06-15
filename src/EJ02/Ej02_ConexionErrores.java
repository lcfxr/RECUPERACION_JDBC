package EJ02;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Ej02_ConexionErrores {
    public static void main(String[] args) {
        String url="jdbc:sqlite:biblioteca.db";
        try (Connection conexion=DriverManager.getConnection(url)){
            System.out.println("Conexion establecida");
        } catch (SQLException e) {
            System.out.println("Error de conexion");
            System.out.println(e.getMessage());
        }

        /**
         * 1- Es sqlite no sqlit
         * 2-SQLException
         * 3-Para recibir un mensaje tecnico sobre el error
         * 4- Crear la conexion no confirma que la bbdd este correcta
         */
    }
    
}
