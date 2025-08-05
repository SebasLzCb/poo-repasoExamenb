package PrimerEjercicio.DAO.DAOImpl;
import PrimerEjercicio.DAO.AsignaturaDAO;
import PrimerEjercicio.models.Asignatura;
import java.util.ArrayList;
import java.util.List;

public class AsignaturaDAOImpl implements AsignaturaDAO {

    private List<Asignatura> listaAsignaturas;

    public AsignaturaDAOImpl() {
        this.listaAsignaturas = new ArrayList<>();
    }

    @Override
    public void registrar(Asignatura asignatura) {
        this.listaAsignaturas.add(asignatura);
    }

    @Override
    public Asignatura buscarPorCodigo(String codigo) {
        for (Asignatura asignatura : this.listaAsignaturas) {
            if (asignatura.getCodigo().equals(codigo)) {
                return asignatura;
            }
        }
        return null;
    }

    @Override
    public List<Asignatura> listarTodas() {
        return this.listaAsignaturas;
    }
}