package EXAMEN;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProgramaPrincipal {
    public static void main(String[] args) throws SQLException {

        ArrayList<Habitacion>habitacion=new ArrayList<>(); //CREAS EL ARRAYLIST PARA PODER INSERTAR LAS HABITACIONES

        HabitacionDAO hdao= new HabitacionDAO();//CREAS OBJETO DE LA CLASE HABITACIONDAO PARA PODER USAR SUS METODOS

        habitacion.add(new Habitacion(1, "101", "Individual", 55.0, 0));//AÑADES LAS HABITACIONES AL ARRAYLIST
        habitacion.add(new Habitacion(2, "102", "Doble", 75.0, 0));
        habitacion.add(new Habitacion(3, "201", "Suite", 130.0, 0));
        habitacion.add(new Habitacion(4, "202", "Familiar", 95.0, 0));

        for(Habitacion h : habitacion){//RECORRES EL ARRAYLIST Y LLAMAS AL METODO INSERTARHABITACION PARA INSERTAR CADA HABITACION EN LA BASE DE DATOS
            hdao.insertarHabitacion(h);
        }

        System.out.println("Habitaciones insertadas correctamente");

        System.out.println("---LISTADO DE HABITACIONES---");
        ArrayList<Habitacion>imprimir=hdao.obtenerHabitacion();//LLAMAS AL METODO OBTENERHABITACION PARA OBTENER TODAS LAS HABITACIONES DE LA BASE DE DATOS
        mostrarHabitaciones(imprimir);

        System.out.println("Resultado de la búsqueda de la habitación 2:");
        Habitacion habitacionEncontrada = hdao.buscarHabitacion(2);
        if (habitacionEncontrada != null) {//SI SE ENCUENTRA LA HABITACION, SE MUESTRA POR PANTALLA
            System.out.println("Habitación encontrada: " + habitacionEncontrada);
        } else {
            System.out.println("Habitación no encontrada.");
        }

        int filasActualizadas=hdao.actualizarPrecioNoche(1, 60.0);
        System.out.println("Filas actualizadas: " + filasActualizadas);
        int filasEliminadas=hdao.eliminarHabitacion(4);
        System.out.println("Filas eliminadas: " + filasEliminadas);

        ReservaDAO rdao=new ReservaDAO();
        Reserva reserva = new Reserva(1, 2, "Miryam Rodriguez", "2026-06-23", 3, 225.0);
        boolean registrarReserva=rdao.registrarReserva(reserva);
        if (registrarReserva) {
            System.out.println("Reserva registrada correctamente.");
        } else {
            System.out.println("Error al registrar la reserva.");
        }   

        System.out.println("---LISTADO FINAL DE HABITACIONES---");
        ArrayList<Habitacion>habitacionesFinales=hdao.obtenerHabitacion();//LLAMAS AL METODO OBTENERHABITACION PARA OBTENER TODAS LAS HABITACIONES DE LA BASE DE DATOS
        mostrarHabitaciones(habitacionesFinales);
    }   

        private static void mostrarHabitaciones(ArrayList<Habitacion> habitaciones) { 
            for (Habitacion habitacion : habitaciones) { 
                mostrarHabitacion(habitacion); 
            } 
        } 
        private static void mostrarHabitacion(Habitacion habitacion) { 
            String estado; 
            if (habitacion.getOcupada() == 1) { 
                estado = "Ocupada"; 
            } else { 
                estado = "Libre"; 
            } 
            System.out.println( habitacion.getId() + " - " + habitacion.getNumero() + " - " + habitacion.getTipo() + " - " + habitacion.getPrecio_noche() + " € - " + estado );
        }
}
