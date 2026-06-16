package EXAMEN;

public class Habitacion {
    int id;
    String numero;
    String tipo;
    double precio_noche;
    int ocupada;
    public Habitacion(int id, String numero, String tipo, double precio_noche, int ocupada) {
        this.id = id;
        this.numero = numero;
        this.tipo = tipo;
        this.precio_noche = precio_noche;
        this.ocupada = ocupada;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public double getPrecio_noche() {
        return precio_noche;
    }
    public void setPrecio_noche(double precio_noche) {
        this.precio_noche = precio_noche;
    }
    public int getOcupada() {
        return ocupada;
    }
    public void setOcupada(int ocupada) {
        this.ocupada = ocupada;
    }
    @Override
    public String toString() {
        return "Habitacion [id=" + id + ", numero=" + numero + ", tipo=" + tipo + ", precio_noche=" + precio_noche
                + ", ocupada=" + ocupada + "]";
    }

    

    

    
}
