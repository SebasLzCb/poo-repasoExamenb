package PrimerEjercicio.models;

public class AsignaturaTeorica extends Asignatura {
    private int horasClase;

    public AsignaturaTeorica(String codigo, String nombre, int horasClase) {
        super(codigo, nombre);
        this.horasClase = horasClase;
    }

    public int getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(int horasClase) {
        this.horasClase = horasClase;
    }

    @Override
    public double calcularCargaHorariaSemanal() {
        return this.horasClase;
    }
}
