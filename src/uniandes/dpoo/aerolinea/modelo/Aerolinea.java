package uniandes.dpoo.aerolinea.modelo;

import java.util.HashMap;
import java.util.Map;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteNatural;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;

public class Aerolinea {

    // Mapa para almacenar clientes
    private Map<String, Cliente> clientes;
    
    // Mapa para almacenar vuelos
    private Map<String, Vuelo> vuelos;

    public Aerolinea() {
        this.clientes = new HashMap<>();
        this.vuelos = new HashMap<>();
    }

    // Métodos para gestionar clientes

    public void agregarClienteNatural(ClienteNatural clienteNatural) {
        if (!clientes.containsKey(clienteNatural.getIdentificador())) {
            clientes.put(clienteNatural.getIdentificador(), clienteNatural);
        } else {
            System.out.println("El cliente ya existe en el sistema.");
        }
    }

    public void agregarClienteCorporativo(ClienteCorporativo clienteCorporativo) {
        if (!clientes.containsKey(clienteCorporativo.getIdentificador())) {
            clientes.put(clienteCorporativo.getIdentificador(), clienteCorporativo);
        } else {
            System.out.println("El cliente ya existe en el sistema.");
        }
    }

    public Cliente buscarCliente(String identificador) {
        return clientes.get(identificador);
    }

    // Métodos para gestionar vuelos
    public void agregarVuelo(Vuelo vuelo) {
        String claveVuelo = vuelo.getRuta().getCodigoRuta() + "-" + vuelo.getFecha();
        if (!vuelos.containsKey(claveVuelo)) {
            vuelos.put(claveVuelo, vuelo);
        } else {
            System.out.println("El vuelo ya está registrado.");
        }
    }

    // Método para vender tiquetes
    public void venderTiquete(String identificadorCliente, String codigoRuta, String fecha, int cantidad)
            throws VueloSobrevendidoException, Exception {

        // Buscar cliente
        Cliente cliente = buscarCliente(identificadorCliente);
        if (cliente == null) {
            throw new Exception("El cliente no existe.");
        }

        // Buscar vuelo
        String claveVuelo = codigoRuta + "-" + fecha;
        Vuelo vuelo = vuelos.get(claveVuelo);
        if (vuelo == null) {
            throw new Exception("El vuelo no existe.");
        }

        // Vender los tiquetes
        vuelo.venderTiquetes(cantidad);

        // Asociar los tiquetes al cliente
        for (int i = 0; i < cantidad; i++) {
            Tiquete tiquete = new Tiquete(vuelo, cliente);  // Asocia vuelo y cliente
            cliente.agregarTiquete(tiquete);
        }

        System.out.println("Tiquetes vendidos exitosamente para el cliente: " + cliente.getNombre());
    }
}
