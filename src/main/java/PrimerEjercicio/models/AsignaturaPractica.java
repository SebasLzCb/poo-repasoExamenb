package PrimerEjercicio.models;

public class AsignaturaPractica extends Asignatura{
    private int horasLaboratorio;

    public AsignaturaPractica(String nombre, String codigo, int horasLaboratorio) {
        super(codigo, nombre);
        this.horasLaboratorio =  horasLaboratorio;
    }

    public int getHorasLaboratorio() {
        return horasLaboratorio;
    }

    public void setHorasLaboratorio(int horasLaboratorio) {
        this.horasLaboratorio = horasLaboratorio;
    }

    @Override
    public double calcularCargaHorariaSemanal() {
        return this.horasLaboratorio * 2.0;
    }
}
