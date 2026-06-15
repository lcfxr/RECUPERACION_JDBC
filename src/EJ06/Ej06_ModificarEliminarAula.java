package EJ06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ej06_ModificarEliminarAula {
    public static void main(String[] args) {
        String url="jdbc:sqlite:centro.db";
        String actualizar="UPDATE aulas SET capacidad=32 WHERE id=1;";
        String eliminar="DELETE FROM aulas WHERE id=99;";

        try(Connection conexion=DriverManager.getConnection(url);
            Statement stmt = conexion.createStatement()) {
                System.out.println("Conexion establecida");
                int filasActualizadas=stmt.executeUpdate(actualizar);
                System.out.println("Filas actualizadas: " +filasActualizadas);
                int filasEliminadas=stmt.executeUpdate(eliminar);
                System.out.println("Filas eliminadas: " +filasEliminadas);
            
        } catch (SQLException e) {
            System.out.println("EDrror de conexion");
            System.out.println(e.getMessage());
        }

        /* 
        Respuestas: 1. ¿Qué valor tendrá filasAfectadas si existe el aula con id = 1? 
        Tendra valor 1 porque se ha modificado una fila
        Respuesta: 2. ¿Qué valor tendrá filasAfectadas si no existe ningún aula con id = 99? 
        Tendra valor 0 ya que no se ve ninguna fila afectada
        Respuesta: 3. ¿Por qué es peligroso hacer un DELETE sin WHERE? Respuesta:
        Porque borraria toda la base de datos
        */
    }
    
}
