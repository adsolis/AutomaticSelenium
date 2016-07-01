package mx.nexsol.dao.comun;

import mx.nexsol.entity.comun.UsuarioRol;

/**
 * Created by ironhide on 01/07/16.
 */
public interface UsuarioRolDAO extends GenericDAO<UsuarioRol> {

    UsuarioRol recuperarUsuarioRolPorUsuario(String username) throws Exception;

}
