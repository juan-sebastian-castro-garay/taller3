package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Tiquete {

    // Atributos
    private String codigo;
    private Vuelo vuelo;
    private Cliente cliente;
    private int tarifa;

    /**
     * Constructor del tiquete.
     * @param codigo Código único del tiquete.
     * @param vuelo El vuelo asociado a este tiquete.
     * @param cliente El cliente que compró el tiquete.
     * @param tarifa El valor del tiquete.
     */
    public Tiquete(String codigo, Vuelo vuelo, Cliente cliente, int tarifa) {
        this.codigo = codigo;
        this.vuelo = vuelo;
        this.cliente = cliente;
        this.tarifa = tarifa;
    }

    // Getters y Setters

    /**
     * Obtiene el código del tiquete.
     * @return Código único del tiquete.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código del tiquete.
     * @param codigo El código único del tiquete.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtiene el vuelo asociado al tiquete.
     * @return El vuelo del tiquete.
     */
    public Vuelo getVuelo() {
        return vuelo;
    }

    /**
     * Establece el vuelo para el tiquete.
     * @param vuelo El vuelo asociado a este tiquete.
     */
    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    /**
     * Obtiene el cliente que compró el tiquete.
     * @return El cliente asociado al tiquete.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente para el tiquete.
     * @param cliente El cliente que compró el tiquete.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene el valor de la tarifa del tiquete.
     * @return La tarifa cobrada por el tiquete.
     */
    public int getTarifa() {
        return tarifa;
    }

    /**
     * Establece la tarifa del tiquete.
     * @param tarifa El valor del tiquete.
     */
    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    // Métodos adicionales

    /**
     * Representación en cadena del tiquete, útil para depuración y visualización.
     * @return Una cadena con los detalles del tiquete.
     */
    @Override
    public String toString() {
        return "Tiquete{" +
                "codigo='" + codigo + '\'' +
                ", vuelo=" + vuelo.getRuta().getCodigoRuta() +
                ", cliente=" + cliente.getNombre() +
                ", tarifa=" + tarifa +
                '}';
    }
}
