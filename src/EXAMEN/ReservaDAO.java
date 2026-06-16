package EXAMEN;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservaDAO {
    //ESTA PARTE DEL EJERCICIO ME CUESTA BASTANTE LA VERDAD
    public void registrarReserva(Reserva reserva) throws SQLException{
        String insertar="INSERT INTO reservas (id, id_habitacion, cliente, fecha_entrada, noches, importe_total) VALUES (?,?,?,?,?,?);";
        String actualizar="UPDATE habitaciones SET ocupada=1 WHERE id=? ;";

        Connection conexion=null;//PONEMOS ESTA VARIABLE COMO NULA PARA PODER HACER EL COMMIT Y DEMAS DESPUES
        try {
            conexion=ConexionBD.conectar();
            conexion.setAutoCommit(false);//HASTA QUE NO SEA TRUE NO SE GUARDA
            //ESTE TRY ES PARA INSERTAR LA RESERVA
            try(PreparedStatement stmt = conexion.prepareStatement(actualizar)){
                stmt.setInt(1, reserva.getId());
                stmt.setInt(2,reserva.getId_habitacion());
                stmt.setString(3, reserva.getCliente());
                stmt.setString(4, reserva.getFecha_entrada());
                stmt.setInt(5, reserva.getNoches());
                stmt.setDouble(6, reserva.getImporte_total());
                stmt.executeUpdate();
            }
            //ESTE ES PARA MARCAR LA HABITACION COMO OCUPADA
            try(PreparedStatement stmt =conexion.prepareStatement(actualizar)){
                stmt.setInt(1, reserva.getId_habitacion());
                stmt.executeUpdate();

            }
            conexion.commit();//CONFIRMA LA TRANSACCION
            System.out.println("Reserva registrada correctamente");
            
        } catch (SQLException e) {
            System.out.println("Error de conexion");
            System.out.println(e.getMessage());
            if(conexion!=null){
                conexion.rollback();//DESHACE LOS CAMBIOS SI HUBO UN ERROR AL GUARDAR
            }
        }finally{
            if(conexion!=null){
                try{
                    conexion.setAutoCommit(true);//ESTO HACE QUE SE GUARDE LA INFORMACION
                    conexion.close();
                }catch(SQLException e){
                    System.out.println("Error de conexion");
                }
            }

        }
    }
    
}
