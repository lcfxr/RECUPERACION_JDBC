package EXAMEN;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservaDAO {

    public boolean registrarReserva(Reserva reserva) throws SQLException{
        String insertar="INSERT INTO reservas (id, id_habitacion, cliente, fecha_entrada, noches, importe_total) VALUES (?,?,?,?,?,?);";
        String actualizar="UPDATE habitaciones SET ocupada=1 WHERE id=? AND ocupada=0 ;";

        
        try(Connection conexion=ConexionBD.conectar()) {
            
            conexion.setAutoCommit(false);//ESTO ES PARA QUE NO SE HAGA EL COMMIT AUTOMATICO, SINO QUE SE HAGA MANUALMENTE

            //ESTE TRY ES PARA INSERTAR LA RESERVA Y ACTUALIZAR LA HABITACION A OCUPADA, SI HAY UN ERROR, SE HACE EL ROLLBACK
            try(PreparedStatement stmtReserva = conexion.prepareStatement(insertar);
                PreparedStatement stmtHabitacion = conexion.prepareStatement(actualizar)){

                stmtReserva.setInt(1, reserva.getId());//INSERTA LA RESERVA EN LA TABLA RESERVAS
                stmtReserva.setInt(2,reserva.getId_habitacion());
                stmtReserva.setString(3, reserva.getCliente());
                stmtReserva.setString(4, reserva.getFecha_entrada());
                stmtReserva.setInt(5, reserva.getNoches());
                stmtReserva.setDouble(6, reserva.getImporte_total());
                int filasReserva=stmtReserva.executeUpdate();

                stmtHabitacion.setInt(1, reserva.getId_habitacion());//ACTUALIZA LA HABITACION A OCUPADA EN LA TABLA HABITACIONES
                int filasHabitacion=stmtHabitacion.executeUpdate();

                if(filasReserva==1 || filasHabitacion==1){//SI SE HA INSERTADO LA RESERVA Y SE HA ACTUALIZADO LA HABITACION, SE HACE EL COMMIT
                    conexion.commit();//HACE EL COMMIT DE LA TRANSACCION
                    return true;
                }else{
                    conexion.rollback();//SI NO SE HA INSERTADO LA RESERVA O NO SE HA ACTUALIZADO LA HABITACION, SE HACE EL ROLLBACK
                    return false;
                }
                
            } catch (SQLException e) {
                System.out.println("Error de conexion");
                System.out.println(e.getMessage());
                conexion.rollback();//SI HAY UN ERROR, SE HACE EL ROLLBACK
                return false;
        
            }
        } catch (SQLException e) {
            System.out.println("Error de conexion");
            System.out.println(e.getMessage());
            return false;
        }
    }
}
