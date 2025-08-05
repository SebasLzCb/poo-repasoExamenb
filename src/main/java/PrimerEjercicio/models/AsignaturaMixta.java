package PrimerEjercicio.models;

public class AsignaturaMixta extends Asignatura {
    private int horasClase;
    private int horasLaboratorio;

    public AsignaturaMixta(String codigo, String nombre, int horasClase, int horasLaboratorio) {
        super(codigo, nombre); // Y pasarlos con super()
        this.horasClase = horasClase;
        this.horasLaboratorio = horasLaboratorio;
    }

    public int getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(int horasClase) {
        this.horasClase = horasClase;
    }

    public int getHorasLaboratorio() {
        return horasLaboratorio;
    }

    public void setHorasLaboratorio(int horasLaboratorio) {
        this.horasLaboratorio = horasLaboratorio;
    }

    @Override
    public double calcularCargaHorariaSemanal() {
        return this.horasClase + (this.horasLaboratorio * 1.5);
    }
}
