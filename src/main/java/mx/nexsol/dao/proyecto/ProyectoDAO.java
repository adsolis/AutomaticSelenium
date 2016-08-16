package mx.nexsol.dao.proyecto;

import mx.nexsol.dao.comun.GenericDAO;
import mx.nexsol.entity.comun.Usuario;
import mx.nexsol.entity.proyectos.Proyecto;
import java.util.List;

/**
 * Clase DAO para la capa de persistencia de Proyecto
 * implementa la interface de GenericDAO que contiene los metodos del crud
 * @author Desarrollo
 *
 */
public interface ProyectoDAO extends GenericDAO<Proyecto> {

    List<Proyecto> recuperarProyectosUsuario(Usuario usuario);

}
