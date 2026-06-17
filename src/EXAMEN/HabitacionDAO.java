package EXAMEN;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HabitacionDAO {
    public int insertarHabitacion(Habitacion habitacion){
        String insertar="INSERT INTO habitaciones (id, numero, tipo, precio_noche, ocupada)VALUES(?,?,?,?,?);";
        try(Connection conexion=ConexionBD.conectar();
            PreparedStatement stmt=conexion.prepareStatement(insertar)){
                stmt.setInt(1,habitacion.getId());
                stmt.setString(2, habitacion.getNumero());
                stmt.setString(3, habitacion.getTipo());
                stmt.setDouble(4, habitacion.getPrecio_noche());
                stmt.setInt(5, habitacion.getOcupada());
                int filasAfectadas=stmt.executeUpdate();
                return filasAfectadas;
        }catch(SQLException e){
            System.out.println("Error de conexion");
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public ArrayList<Habitacion>obtenerHabitacion(){
        String consultar="SELECT id, numero, tipo, precio_noche, ocupada FROM habitaciones;";
        ArrayList<Habitacion>habitaciones=new ArrayList<>();
        try(Connection conexion = ConexionBD.conectar();
            PreparedStatement stmt = conexion.prepareStatement(consultar);
            ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    //PARA QUE NOS MUESTRE UN OBJETO TENEMOS QUE CREARLO
                  int id = rs.getInt("id"); 
                  String numero = rs.getString("numero"); 
                  String tipo = rs.getString("tipo"); 
                  double precioNoche = rs.getDouble("precio_noche");   
                  int ocupada = rs.getInt("ocupada");
                  Habitacion habitacion = new Habitacion(id, numero, tipo, precioNoche, ocupada);
                  habitaciones.add(habitacion);
                }
        } catch (SQLException e) {
            System.out.println("Error de conexion");
            System.out.println(e.getMessage());
        }
        return habitaciones;
    }
    public Habitacion buscarHabitacion(int id){
        String buscar="SELECT * FROM habitaciones WHERE id=?;";
        try(Connection conexion = ConexionBD.conectar();
            PreparedStatement stmt = conexion.prepareStatement(buscar)) {
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String numero = rs.getString("numero");
                    String tipo = rs.getString("tipo");
                    double precioNoche = rs.getDouble("precio_noche");
                    int ocupada = rs.getInt("ocupada");
                    return new Habitacion(id, numero, tipo, precioNoche, ocupada);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error de conexion");
            System.out.println(e.getMessage());
        }
        return null;
    }
    public int actualizarPrecioNoche(int id, double precio_noche){
        String actualizar="UPDATE habitaciones SET precio_noche=? WHERE id =?;";
        try(Connection conexion =ConexionBD.conectar();
            PreparedStatement stmt = conexion.prepareStatement(actualizar)) {
                stmt.setInt(2, id);
                stmt.setDouble(1, precio_noche);
                int filasAfectadas=stmt.executeUpdate();
                return filasAfectadas;
        } catch (SQLException e) {
            System.out.println("Error de conexion");
            System.out.println(e.getMessage());
        }
        return 0;
    }
    public int eliminarHabitacion(int id){
        String eliminar ="DELETE FROM habitaciones WHERE id=?;";
        try(Connection conexion = ConexionBD.conectar();
            PreparedStatement stmt = conexion.prepareStatement(eliminar)) {
                stmt.setInt(1, id);
                int filasAfectadas=stmt.executeUpdate();
                return filasAfectadas;
        } catch (SQLException e) {
            System.out.println("Error de conexion");
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
}
