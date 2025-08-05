package SegundoEjercicio.DAO.DAOimpl;

import SegundoEjercicio.DAO.TransporteDAO;
import SegundoEjercicio.models.Transporte;

import java.util.ArrayList;
import java.util.List;

public class TransporteDAOImpl implements TransporteDAO {
    private List<Transporte> transportesDisponibles; // La "base de datos"

    public TransporteDAOImpl() {
        this.transportesDisponibles = new ArrayList<>();
    }

    @Override
    public void registrar(Transporte transporte) {

    }

    @Override
    public Transporte buscarPorCodigo(String codigo) {
        return null;
    }

    @Override
    public List<Transporte> listarTodos() {
        return List.of();
    }

    // ... Implementación de los métodos usando la lista
}
