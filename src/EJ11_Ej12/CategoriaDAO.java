package EJ11_Ej12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    public ArrayList<Categoria>obtenerTodasLasCategorias(){
        ArrayList<Categoria>categorias=new ArrayList<>();
        String consulta="SELECT id, nombre FROM categorias;";
        try(Connection conexion =ConexionBD.conectar();
            PreparedStatement stmt = conexion.prepareStatement(consulta);
            ResultSet rs =stmt.executeQuery()) {
                System.out.println("Conexion establecida");
                while (rs.next()) {
                    int id=rs.getInt("id");
                    String nombre=rs.getString("nombre");
                    Categoria categoria=new Categoria(id, nombre);
                    categorias.add(categoria);
                }
        } catch (SQLException e) {
            System.out.println("Error de conexion");
            System.out.println(e.getMessage());
        }
        return categorias;
    }

    
}
