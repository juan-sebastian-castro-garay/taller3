package uniandes.dpoo.aerolinea.modelo;

import java.util.Objects;
import java.util.Set;

import uniandes.dpoo.aerolinea.exceptions.AeropuertoDuplicadoException;

/**
 * Esta clase encapsula la información sobre los aeropuertos e implementa algunas operaciones relacionadas con la ubicación geográfica de los aeropuertos.
 * 
 * No puede haber dos aeropuertos con el mismo código.
 */
public class Aeropuerto {

    // Atributos
    private String codigo;
    private String nombre;
    private double latitud;
    private double longitud;
    private String pais;
    private String ciudad;

    // Constante para el radio de la Tierra en kilómetros
    private static final double RADIO_TERRESTRE = 6371.0;

    // Constructor
    public Aeropuerto(String codigo, String nombre, double latitud, double longitud, String pais, String ciudad) throws AeropuertoDuplicadoException {
        this.codigo = codigo;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.pais = pais;
        this.ciudad = ciudad;
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    // Método para calcular la distancia entre dos aeropuertos
    public static int calcularDistancia(Aeropuerto aeropuerto1, Aeropuerto aeropuerto2) {
        // Convertir los ángulos a radianes para facilitar las operaciones trigonométricas
        double latAeropuerto1 = Math.toRadians(aeropuerto1.getLatitud());
        double lonAeropuerto1 = Math.toRadians(aeropuerto1.getLongitud());
        double latAeropuerto2 = Math.toRadians(aeropuerto2.getLatitud());
        double lonAeropuerto2 = Math.toRadians(aeropuerto2.getLongitud());

        // Calcular la distancia debido a la diferencia de latitud y de longitud
        double deltaX = (lonAeropuerto2 - lonAeropuerto1) * Math.cos((latAeropuerto1 + latAeropuerto2) / 2);
        double deltaY = (latAeropuerto2 - latAeropuerto1);

        // Calcular la distancia real en kilómetros
        double distancia = Math.sqrt(deltaX * deltaX + deltaY * deltaY) * RADIO_TERRESTRE;

        return (int) Math.round(distancia);
    }

    // Sobrescribir equals y hashCode para comparar aeropuertos por su código
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Aeropuerto that = (Aeropuerto) obj;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    // Verificación de duplicados (manejando la excepción AeropuertoDuplicadoException)
    public static void verificarDuplicado(Set<Aeropuerto> aeropuertos, Aeropuerto nuevoAeropuerto) throws AeropuertoDuplicadoException {
        if (aeropuertos.contains(nuevoAeropuerto)) {
            throw new AeropuertoDuplicadoException("El aeropuerto con el código " + nuevoAeropuerto.getCodigo() + " ya existe.");
        }
    }
}
