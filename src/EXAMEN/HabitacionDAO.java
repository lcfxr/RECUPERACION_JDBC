package EXAMEN;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HabitacionDAO {
    public void insertarHabitacion(Habitacion habitacion){
        String insertar="INSERT INTO habitaciones (id, numero, tipo, precio_noche, ocupada)VALUES(?,?,?,?,?);";
        try(Connection conexion=ConexionBD.conectar();
            PreparedStatement stmt=conexion.prepareStatement(insertar)){
                stmt.setInt(1,habitacion.getId());
                stmt.setString(2, habitacion.getNumero());
                stmt.setString(3, habitacion.getTipo());
                stmt.setDouble(4, habitacion.getPrecio_noche());
                stmt.setInt(5, habitacion.getOcupada());
                int filasAfectadas=stmt.executeUpdate();
                System.out.println("Habitaciones insertadas: " +filasAfectadas);
        }catch(SQLException e){
            System.out.println("Error de conexion");
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Habitacion>obtenerHabitacion(){
        String consultar="SELECT id, numero, tipo, precio_noche, ocupada FROM habitaciones;";
        ArrayList<Habitacion>habitaciones=new ArrayList<>();
        try(Connection conexion = ConexionBD.conectar();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(consultar)) {
                while (rs.next()) {
                    //PARA QUE NOS MUESTRE UN OBJETO TENEMOS QUE CREARLO
                    habitaciones.add(new Habitacion(//AQUI SE CREA CON EL NEW HABITACION
                        rs.getInt("id"),
                        rs.getString("numero"),
                        rs.getString("tipo"),
                        rs.getDouble("precio_noche"),
                        rs.getInt("ocupada")
                    ));  
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
            ResultSet rs =stmt.executeQuery();
            if(rs.next()){
                return new Habitacion( //NOS PASA LO MISMO QUE EL EJERCICIO ANTERIOR
                        rs.getInt("id"),
                        rs.getString("numero"),
                        rs.getString("tipo"),
                        rs.getDouble("precio_noche"),
                        rs.getInt("ocupada")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error de conexion");
            System.out.println(e.getMessage());
        }
        return null;
    }
    public void actualizarPrecioNoche(int id, double precio_noche){
        String actualizar="UPDATE habitaciones SET precio_noche=? WHERE id =?;";
        try(Connection conexion =ConexionBD.conectar();
            PreparedStatement stmt = conexion.prepareStatement(actualizar)) {
                stmt.setInt(1, id);
                stmt.setDouble(4, precio_noche);
                int filasAfectadas=stmt.executeUpdate();
                System.out.println("Habitaciones actualizadas: "+filasAfectadas);
        } catch (SQLException e) {
            System.out.println("Error de conexion");
            System.out.println(e.getMessage());
        }
    }
    public void eliminarHabitacion(int id){
        String eliminar ="DELETE FROM habitaciones WHERE id=?;";
        try(Connection conexion = ConexionBD.conectar();
            PreparedStatement stmt = conexion.prepareStatement(eliminar)) {
                stmt.setInt(1, id);
                int filasAfectadas=stmt.executeUpdate();
                System.out.println("Habitaciones eliminadas: " +filasAfectadas);
            
        } catch (SQLException e) {
            System.out.println("Error de conexion");
            System.out.println(e.getMessage());
        }
    }
    
}
