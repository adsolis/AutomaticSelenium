package mx.nexsol.service.comun;

import mx.nexsol.dto.comun.UsuarioDTO;
import mx.nexsol.response.UsuarioRespuestaDTO;

import java.util.List;

/**
 * Created by ironhide on 28/06/16.
 */
public interface UsuarioService {


    UsuarioRespuestaDTO recuperarUsuarios();

    UsuarioRespuestaDTO recuperarUsuariosPorEmpresa();

    UsuarioRespuestaDTO guardarUsuario(UsuarioDTO usuarioDTO);

    UsuarioRespuestaDTO editarUsuario(UsuarioDTO usuarioDTO);

    UsuarioRespuestaDTO eliminarUsuario(long id);

}
