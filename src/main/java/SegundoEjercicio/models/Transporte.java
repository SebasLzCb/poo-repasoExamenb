package SegundoEjercicio.models;

public abstract class Transporte {
    private String codigo;
    private String nombreComercial;
    private double tarifaPorKm;

    public Transporte(String codigo, String nombreComercial, double tarifaPorKm) {
        this.codigo = codigo;
        this.nombreComercial = nombreComercial;
        this.tarifaPorKm = tarifaPorKm;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public double getTarifaPorKm() {
        return tarifaPorKm;
    }

    public void setTarifaPorKm(double tarifaPorKm) {
        this.tarifaPorKm = tarifaPorKm;
    }

    public abstract double calcularCostoViaje(double kilometros);
}
