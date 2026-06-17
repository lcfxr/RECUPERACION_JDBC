package EXAMEN;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservaDAO {
    //ESTA PARTE DEL EJERCICIO ME CUESTA BASTANTE LA VERDAD
    public boolean registrarReserva(Reserva reserva) throws SQLException{
        String insertar="INSERT INTO reservas (id, id_habitacion, cliente, fecha_entrada, noches, importe_total) VALUES (?,?,?,?,?,?);";
        String actualizar="UPDATE habitaciones SET ocupada=1 WHERE id=? AND ocupada=0 ;";

        
        try(Connection conexion=ConexionBD.conectar()) {
            
            conexion.setAutoCommit(false);//HASTA QUE NO SEA TRUE NO SE GUARDA
            //ESTE TRY ES PARA INSERTAR LA RESERVA
            try(PreparedStatement stmtReserva = conexion.prepareStatement(insertar);
                PreparedStatement stmtHabitacion = conexion.prepareStatement(actualizar)){
                stmtReserva.setInt(1, reserva.getId());
                stmtReserva.setInt(2,reserva.getId_habitacion());
                stmtReserva.setString(3, reserva.getCliente());
                stmtReserva.setString(4, reserva.getFecha_entrada());
                stmtReserva.setInt(5, reserva.getNoches());
                stmtReserva.setDouble(6, reserva.getImporte_total());
                int filasReserva=stmtReserva.executeUpdate();

                stmtHabitacion.setInt(1, reserva.getId_habitacion());
                int filasHabitacion=stmtHabitacion.executeUpdate();
                if(filasReserva==1 || filasHabitacion==1){
                    conexion.commit();
                    return true;
                }else{
                    conexion.rollback();
                    return false;
                }
            } catch (SQLException e) {
                System.out.println("Error de conexion");
                System.out.println(e.getMessage());
                conexion.rollback();
                return false;
        
            }
        } catch (SQLException e) {
            System.out.println("Error de conexion");
            System.out.println(e.getMessage());
            return false;
        }
    }
}
