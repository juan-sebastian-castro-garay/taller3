package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas {

    // Constante para el cálculo de costos en temporada alta
    private final int COSTO_POR_KM = 1000;

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
        return distancia * COSTO_POR_KM;
    }

    // Método para calcular el porcentaje de descuento
    @Override
    protected double calcularPorcentajeDescuento(Cliente cliente) {
        // No hay descuentos en temporada alta
        return 0;
    }

    // Método para calcular la distancia de la ruta del vuelo
    @Override
    protected int calcularDistanciaVueloRuta(Vuelo vuelo) {
        return Aeropuerto.calcularDistancia(vuelo.getRuta().getOrigen(), vuelo.getRuta().getDestino());
    }
}
