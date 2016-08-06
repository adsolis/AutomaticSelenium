package mx.nexsol.dao.comun;

import java.util.List;

public interface GenericDAO<T> {
	T guardarRegistro(T entity) throws Exception;
    T editarRegistro(T entity) throws Exception;
    boolean borrarRegistro(T entity) throws Exception;
    List <T> listarRegistros() throws  Exception;
    T recuperarRegistro (long id) throws Exception;
}
