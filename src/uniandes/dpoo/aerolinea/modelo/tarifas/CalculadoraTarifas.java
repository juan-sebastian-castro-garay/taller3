package uniandes.dpoo.aerolinea.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas {

    // Atributo constante para el impuesto
    protected final double IMPUESTO = 0.28;

    // Método para calcular la tarifa para un vuelo y cliente específico
    public abstract int calcularTarifaVuelo(Vuelo vuelo, Cliente cliente);

    // Método para calcular el costo base del vuelo (según las reglas de cada subclase)
    protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);

    // Método para calcular el porcentaje de descuento para un cliente específico
    protected abstract double calcularPorcentajeDescuento(Cliente cliente);

    // Método para calcular la distancia entre los aeropuertos de la ruta y el costo por km
    protected abstract int calcularDistanciaVueloRuta(Vuelo vuelo);

    // Método para calcular el valor de los impuestos
    public int calcularValorImpuestos(int costoBase) {
        return (int) (costoBase * IMPUESTO);
    }
}
