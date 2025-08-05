package SegundoEjercicio.models;

public class BicicletaPublica extends Transporte{
    private String idEstacion;

    public BicicletaPublica(String codigo, String nombreComercial, double tarifaPorKm, String idEstacion) {
        super(codigo, nombreComercial, tarifaPorKm);
        this.idEstacion = idEstacion;
    }

    @Override
    public double calcularCostoViaje(double kilometros) {
        return super.getTarifaPorKm() * kilometros;
    }
}
