package SegundoEjercicio.DAO;

import SegundoEjercicio.models.Transporte;
import java.util.List;

public interface TransporteDAO {
    void registrar(Transporte transporte);
    Transporte buscarPorCodigo(String codigo);
    List<Transporte> listarTodos();
}