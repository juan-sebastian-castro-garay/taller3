package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {

    // Constantes para el cálculo
    private final int COSTO_POR_KM_NATURAL = 600;
    private final int COSTO_POR_KM_CORPORATIVO = 900;
    private final double DESCUENTO_PEQUENOS = 0.04;
    private final double DESCUENTO_GRANDES = 0.02;

    // Método para calcular la tarifa para un vuelo y cliente específico
    @Override
    public int calcularTarifaVuelo(Vuelo vuelo, Cliente cliente) {
        int costoBase = calcularCostoBase(vuelo, cliente);
        double descuento = calcularPorcentajeDescuento(cliente);
        int costoConDescuento = (int) (costoBase * (1 - descuento));
        int impuestos = calcularValorImpuestos(costoConDescuento);
        return costoConDescuento + impuestos;
    }

    // Método para calcular el costo base del vuelo
    @Override
    protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
        int distancia = calcularDistanciaVueloRuta(vuelo);
        // Si es cliente corporativo, usa un costo diferente por km
        if (cliente.getTipoCliente().equals("Corporativo")) {
            return distancia * COSTO_POR_KM_CORPORATIVO;
        } else {
            return distancia * COSTO_POR_KM_NATURAL;
        }
    }

    // Método para calcular el porcentaje de descuento
    @Override
    protected double calcularPorcentajeDescuento(Cliente cliente) {
        if (cliente.getTipoCliente().equals("Corporativo")) {
            // Descuento corporativo para empresas grandes o pequeñas
            if (cliente.getTiquetes().size() > 100) {
                return DESCUENTO_GRANDES;
            } else {
                return DESCUENTO_PEQUENOS;
            }
        }
        return 0; // Sin descuento para clientes naturales
    }

    // Método para calcular la distancia de la ruta del vuelo
    @Override
    protected int calcularDistanciaVueloRuta(Vuelo vuelo) {
        return Aeropuerto.calcularDistancia(vuelo.getRuta().getOrigen(), vuelo.getRuta().getDestino());
    }
}
