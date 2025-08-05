package SegundoEjercicio.models;

public class Bus extends Transporte{
    private String numeroDeRuta;

    public Bus(String codigo, String nombreComercial, double tarifaPorKm, String numeroDeRuta) {
        super(codigo, nombreComercial, tarifaPorKm);
        this.numeroDeRuta = numeroDeRuta;
    }

    @Override
    public double calcularCostoViaje(double kilometros) {
        return super.getTarifaPorKm() * kilometros;
    }
}
