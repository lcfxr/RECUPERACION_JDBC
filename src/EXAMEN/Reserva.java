package EXAMEN;

public class Reserva {
    
    int id;
    int id_habitacion;
    String cliente;
    String fecha_entrada;
    int noches;
    double importe_total;
    public Reserva(int id, int id_habitacion, String cliente, String fecha_entrada, int noches, double importe_total) {
        this.id = id;
        this.id_habitacion = id_habitacion;
        this.cliente = cliente;
        this.fecha_entrada = fecha_entrada;
        this.noches = noches;
        this.importe_total = importe_total;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId_habitacion() {
        return id_habitacion;
    }
    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }
    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public String getFecha_entrada() {
        return fecha_entrada;
    }
    public void setFecha_entrada(String fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }
    public int getNoches() {
        return noches;
    }
    public void setNoches(int noches) {
        this.noches = noches;
    }
    public double getImporte_total() {
        return importe_total;
    }
    public void setImporte_total(double importe_total) {
        this.importe_total = importe_total;
    }
    @Override
    public String toString() {
        return "Reserva [id=" + id + ", id_habitacion=" + id_habitacion + ", cliente=" + cliente + ", fecha_entrada="
                + fecha_entrada + ", noches=" + noches + ", importe_total=" + importe_total + "]";
    }

    

    

    
}
