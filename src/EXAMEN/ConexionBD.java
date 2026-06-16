package EXAMEN;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConexionBD {
    //ESTUDIARSE DE MEMORIA ESTO
    private static final String url="jdbc:sqlite:hotel.db";
    public static Connection conectar() throws SQLException{
        return DriverManager.getConnection(url);
    }
    
}
