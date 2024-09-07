package DAL;

import java.util.List;

public interface IRepository<T> {
    void guardar(T entity) throws Exception;

    T recuperar(int id) throws Exception;

    List<T> listar() throws Exception;
}
