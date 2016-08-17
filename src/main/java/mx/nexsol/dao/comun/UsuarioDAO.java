package mx.nexsol.dao.comun;

import mx.nexsol.entity.catalogos.Empresa;
import mx.nexsol.entity.comun.Usuario;

import java.util.List;

/**
 * Created by ironhide on 28/06/16.
 */
public interface UsuarioDAO extends GenericDAO<Usuario> {

    List<Usuario> recuperarUsuariosPorEmpresa(Empresa empresa) throws Exception;

    Usuario recuperarUsuarioPorUserName(String userName) throws Exception;

}
