package EXAMEN;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HabitacionDAO {

    //METODO PARA INSERTAR HABITACIONES EN LA BASE DE DATOS
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

    //METODO PARA OBTENER TODAS LAS HABITACIONES DE LA BASE DE DATOS
    public ArrayList<Habitacion>obtenerHabitacion(){
        String consultar="SELECT id, numero, tipo, precio_noche, ocupada FROM habitaciones;";//CONSULTA
        ArrayList<Habitacion>habitaciones=new ArrayList<>();//CREAMOS EL ARRAYLIST PARA PODER AÑADIR LAS HABITACIONES
        try(Connection conexion = ConexionBD.conectar();
            PreparedStatement stmt = conexion.prepareStatement(consultar);//PREPARA LA CONSULTA
            ResultSet rs = stmt.executeQuery()) {  //EJECUTA LA CONSULTA
                while (rs.next()) {
                    //PARA QUE NOS MUESTRE UN OBJETO TENEMOS QUE CREARLO
                  int id = rs.getInt("id"); 
                  String numero = rs.getString("numero"); 
                  String tipo = rs.getString("tipo"); 
                  double precio_noche = rs.getDouble("precio_noche");   
                  int ocupada = rs.getInt("ocupada");
                  Habitacion habitacion = new Habitacion(id, numero, tipo, precio_noche, ocupada);//CREAMOS EL OBJETO HABITACION CON LOS DATOS OBTENIDOS DE LA BASE DE DATOS
                  habitaciones.add(habitacion);//AÑADIMOS EL OBJETO HABITACION AL ARRAYLIST
                }
        } catch (SQLException e) {
            System.out.println("Error de conexion");
            System.out.println(e.getMessage());
        }
        return habitaciones;//DEVOLVEMOS EL ARRAYLIST CON TODAS LAS HABITACIONES
    }

    //METODO PARA BUSCAR UNA HABITACION POR SU ID
    public Habitacion buscarHabitacion(int id){
        String buscar="SELECT * FROM habitaciones WHERE id=?;";//CONSULTA PARA BUSCAR LA HABITACION POR SU ID
        try(Connection conexion = ConexionBD.conectar();//CONECTAMOS A LA BASE DE DATOS
            PreparedStatement stmt = conexion.prepareStatement(buscar)) {//PREPARAMOS LA CONSULTA
            stmt.setInt(1, id);//SE ESTABLECE EL VALOR DEL PARAMETRO DE LA CONSULTA
            try(ResultSet rs = stmt.executeQuery()) {//EJECUTA LA CONSULTA
                if (rs.next()) {//SI HAY RESULTADOS, SE CREA EL OBJETO HABITACION CON LOS DATOS OBTENIDOS DE LA BASE DE DATOS
                    String numero = rs.getString("numero");
                    String tipo = rs.getString("tipo");
                    double precio_noche = rs.getDouble("precio_noche");
                    int ocupada = rs.getInt("ocupada");
                    return new Habitacion(id, numero, tipo, precio_noche, ocupada);//DEVOLVEMOS EL OBJETO HABITACION CON LOS DATOS OBTENIDOS DE LA BASE DE DATOS
                }
            }
        } catch (SQLException e) {
            System.out.println("Error de conexion");
            System.out.println(e.getMessage());
        }
        return null;//DEVOLVEMOS NULL SI NO SE ENCUENTRA LA HABITACION
    }

    //METODO PARA ACTUALIZAR EL PRECIO DE UNA HABITACION
    public int actualizarPrecioNoche(int id, double precio_noche){
        String actualizar="UPDATE habitaciones SET precio_noche=? WHERE id =?;";//APRENDER 
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

    //METODO PARA ELIMINAR UNA HABITACION
    public int eliminarHabitacion(int id){
        String eliminar ="DELETE FROM habitaciones WHERE id=?;";//APRENDER
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
