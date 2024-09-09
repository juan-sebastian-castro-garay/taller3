package uniandes.dpoo.aerolinea.modelo;

public class Avion {

    // Atributos
    private String nombre;
    private String modelo;
    private int capacidad;
    private String fabricante;

    // Constructor
    public Avion(String nombre, String modelo, int capacidad, String fabricante) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.fabricante = fabricante;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    /**
     * Retorna una representación en texto del avión.
     */
    @Override
    public String toString() {
        return "Avion{" +
                "nombre='" + nombre + '\'' +
                ", modelo='" + modelo + '\'' +
                ", capacidad=" + capacidad +
                ", fabricante='" + fabricante + '\'' +
                '}';
    }
}
