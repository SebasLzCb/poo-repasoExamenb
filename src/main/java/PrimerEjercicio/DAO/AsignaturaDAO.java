package PrimerEjercicio.DAO;
import PrimerEjercicio.models.Asignatura;
import java.util.List;

public interface AsignaturaDAO {
    void registrar(Asignatura asignatura);
    Asignatura buscarPorCodigo(String codigo);
    List<Asignatura> listarTodas();
}