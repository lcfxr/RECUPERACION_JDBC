package EXAMEN;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProgramaPrincipal {
    public static void main(String[] args) throws SQLException {
        ArrayList<Habitacion>habitacion=new ArrayList<>();
        HabitacionDAO hdao= new HabitacionDAO();
        habitacion.add(new Habitacion(1, "101", "Individual", 55.0, 0));
        habitacion.add(new Habitacion(2, "102", "Doble", 75.0, 0));
        habitacion.add(new Habitacion(3, "201", "Suite", 130.0, 0));
        habitacion.add(new Habitacion(4, "202", "Familiar", 95.0, 0));

        for(Habitacion h : habitacion){
            hdao.insertarHabitacion(h);
        }
        System.out.println("Habitaciones insertadas correctamente");

        System.out.println("---LISTADO DE HABITACIONES---");
        ArrayList<Habitacion>imprimir=hdao.obtenerHabitacion();
        for(Habitacion ver: imprimir){
            System.out.println(ver);
        }
        Habitacion encontrar =hdao.buscarHabitacion(2);
        if(encontrar==null){
            System.out.println("Habitacion no encontrada");
        }else{
             System.out.println(encontrar);
            }
        }
        //EN ESTA PARTE NO SABRIA COMO HACER EL IF PARA SABER SI ESTAN ACTUALIZADAS/ELIMINADAS O NO
        /*int actualizar=hdao.actualizarPrecioNoche(1, 60.0);
        if(actualizar=null){
            System.out.println("No se ha podido actualizar la habitacion");
        }else{
             for (Habitacion h : habitaciones){
                System.out.println(h);
            }
        }
        int eliminar=hdao.eliminarHabitacion(4);
        if(eliminar=null){
            System.out.println("No se pudo eliminar la habitacion");
        }else{
            for (Habitacion h : habitaciones){
                System.out.println(h);
            }
        }*/
        ReservaDAO rdao = new ReservaDAO();
        Reserva reserva = new Reserva(1, 2, "Miryam Rodriguez", "2026-06-23", 3, 225.0);
        rdao.registrarReserva(reserva); //NO SE DONDE ESTA EL ERROR AQUI

        System.out.println("---LISTADO FINAL DE HABITACIONES---");
        for (Habitacion h : habitacion){
                System.out.println(h);
            }





    }
 
}
