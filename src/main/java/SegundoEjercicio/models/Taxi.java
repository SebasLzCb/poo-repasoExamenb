package SegundoEjercicio.models;

public class Taxi extends Transporte{
    private double tarifaBase;
    
    public Taxi(String codigo, String nombreComercial, double tarifaPorKm, Double tarifaBase) {
        super(codigo, nombreComercial, tarifaPorKm);
        this.tarifaBase = tarifaBase;
    }

    @Override
    public double calcularCostoViaje(double kilometros) {
        return this.tarifaBase + (super.getTarifaPorKm() * kilometros);
    }
}
