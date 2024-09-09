package uniandes.dpoo.aerolinea.modelo;

import java.util.ArrayList;
import java.util.List;

import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Vuelo {

    // Atributos
    private Ruta ruta;
    private String fecha;
    private Avion avion;
    private List<Tiquete> tiquetes;
    private int capacidadMaxima;

    // Constructor
    public Vuelo(Ruta ruta, String fecha, Avion avion) {
        this.ruta = ruta;
        this.fecha = fecha;
        this.avion = avion;
        this.capacidadMaxima = avion.getCapacidad();
        this.tiquetes = new ArrayList<Tiquete>();
    }

    // Getters y Setters
    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public List<Tiquete> getTiquetes() {
        return tiquetes;
    }

    public void setTiquetes(List<Tiquete> tiquetes) {
        this.tiquetes = tiquetes;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    // Métodos adicionales

    /**
     * Método para agregar un tiquete al vuelo.
     * Verifica si hay capacidad antes de agregar el tiquete.
     * @param tiquete El tiquete que se quiere agregar
     * @throws VueloSobrevendidoException Si el vuelo ya está lleno
     */
    public void agregarTiquete(Tiquete tiquete) throws VueloSobrevendidoException {
        if (tiquetes.size() >= capacidadMaxima) {
            throw new VueloSobrevendidoException(this);
        }
        tiquetes.add(tiquete);
    }

    /**
     * Verifica cuántos asientos disponibles hay en el vuelo
     * @return Número de asientos disponibles
     */
    public int asientosDisponibles() {
        return capacidadMaxima - tiquetes.size();
    }

    /**
     * Verifica si el avión está disponible en la misma fecha para otro vuelo
     * @param fecha La fecha del vuelo
     * @return true si el avión está disponible, false si ya está ocupado
     */
    public boolean verificarDisponibilidadAvion(String fecha) {
        return !this.fecha.equals(fecha); // El avión está disponible si no tiene vuelos en la misma fecha
    }

    /**
     * Vende una cierta cantidad de tiquetes para el vuelo
     * @param cantidad La cantidad de tiquetes que se quieren vender
     * @param cliente El cliente que compra los tiquetes
     * @throws VueloSobrevendidoException Si no hay suficiente capacidad
     */
    public void venderTiquetes(int cantidad, Cliente cliente) throws VueloSobrevendidoException {
        if (asientosDisponibles() < cantidad) {
            throw new VueloSobrevendidoException(this);
        }
        for (int i = 0; i < cantidad; i++) {
            Tiquete tiquete = new Tiquete(this, cliente);  // Creación del tiquete correcto con vuelo y cliente
            agregarTiquete(tiquete);
        }
    }
}
