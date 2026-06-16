package EJ11;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoriaDAO {
    public void insertarCategoria(Categoria categoria){
        String sql="INSERT INTO categorias (id, nombre) VALUES (?, ?);";
        
        try(Connection conexion =ConexionBD.conectar();
            PreparedStatement stmt = conexion.prepareStatement(sql)) {
            System.out.println("Conexion establecida");
            stmt.setInt(1,categoria.getId());
            stmt.setString(2, categoria.getNombre());
            int filasAfectadas=stmt.executeUpdate();
            System.out.println("Filas insertadas: "+filasAfectadas);
        } catch (SQLException e) {
            System.out.println("Error de conexion");
            System.out.println(e.getMessage());
        }

    }
    
}
