package mx.nexsol.util;

import java.util.List;

public interface GenericDAO<T> {
	T guardarRegistro(T entity) throws Exception;
    T editarRegistro(T entity) throws Exception;
    T borrarRegistro(T entity) throws Exception;    
    List <T> listarRegistros() throws  Exception;
}
