package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.List;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {

    // Atributos comunes
    protected String nombre;
    protected String identificador;
    protected String correoElectronico;
    protected List<Tiquete> tiquetes;

    // Constructor
    public Cliente(String nombre, String identificador, String correoElectronico) {
        this.nombre = nombre;
        this.identificador = identificador;
        this.correoElectronico = correoElectronico;
        this.tiquetes = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public List<Tiquete> getTiquetes() {
        return tiquetes;
    }

    public void setTiquetes(List<Tiquete> tiquetes) {
        this.tiquetes = tiquetes;
    }

    // Método para agregar un tiquete a la lista de tiquetes del cliente
    public void agregarTiquete(Tiquete tiquete) {
        this.tiquetes.add(tiquete);
    }

    // Método abstracto para obtener el tipo de cliente (Natural o Corporativo)
    public abstract String getTipoCliente();
}
