package mx.nexsol.service.comun.impl;

import lombok.Data;
import mx.nexsol.dao.comun.UsuarioDAO;
import mx.nexsol.dao.comun.UsuarioRolDAO;
import mx.nexsol.dto.comun.UsuarioDTO;
import mx.nexsol.entity.comun.Usuario;
import mx.nexsol.entity.comun.UsuarioRol;
import mx.nexsol.response.UsuarioRespuestaDTO;
import mx.nexsol.service.comun.UsuarioService;
import mx.nexsol.util.ConstantesComunes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ironhide on 28/06/16.
 */

@Service("usuarioService")
@Data
public class UsuarioServiceImpl implements UsuarioService, Serializable {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    private UsuarioRolDAO usuarioRolDAO;

    public UsuarioRespuestaDTO recuperarUsuarios() {
        UsuarioRespuestaDTO usuarioRespuestaDTO = new UsuarioRespuestaDTO();
        try {
            List<Usuario> usuarios = usuarioDAO.listarRegistros();
            if(usuarios!=null && !usuarios.isEmpty()) {
                usuarioRespuestaDTO.usuarios = new ArrayList<UsuarioDTO>();
                for(Usuario usuario: usuarios) {
                    usuarioRespuestaDTO.usuarios.add(mapearEntityADto(usuario));
                }
                usuarioRespuestaDTO.codigoRespuesta = ConstantesComunes.CODIGO_EXITO;
                usuarioRespuestaDTO.mensajeRespuesta = ConstantesComunes.MENSAJE_EXITO;
                usuarios = null;
            }
        }catch (Exception e) {
            usuarioRespuestaDTO.codigoRespuesta = ConstantesComunes.CODIGO_ERROR;
            usuarioRespuestaDTO.mensajeRespuesta = ConstantesComunes.MENSAJE_ERROR;
            usuarioRespuestaDTO.excepcion = e;
        }

        return usuarioRespuestaDTO;
    }

    public UsuarioRespuestaDTO recuperarUsuariosPorEmpresa() {

        return null;
    }

    public UsuarioRespuestaDTO guardarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = mapearDtoAEntity(usuarioDTO);
        UsuarioRol usuarioRol = null;
        UsuarioRespuestaDTO usuarioRespuestaDTO = new UsuarioRespuestaDTO();
        try {
            usuario.setEnabled(true);
            usuario = usuarioDAO.guardarRegistro(usuario);
            usuarioRespuestaDTO.usuarioDTO = mapearEntityADto(usuario);
            usuarioRol = new UsuarioRol();
            usuarioRol.setRol(usuarioDTO.getRol());
            usuarioRol.setUsuario(usuarioDTO.getUsername());
            usuarioRol = usuarioRolDAO.guardarRegistro(usuarioRol);
            usuarioRespuestaDTO.usuarioDTO.setRol(usuarioDTO.getRol());
            usuarioRespuestaDTO.codigoRespuesta = ConstantesComunes.CODIGO_EXITO;
            usuarioRespuestaDTO.mensajeRespuesta = ConstantesComunes.MENSAJE_EXITO;
            usuarioRol = null;
            usuario = null;
            usuarioDTO = null;
        }catch (Exception e) {
            usuarioRespuestaDTO.excepcion = e;
            usuarioRespuestaDTO.codigoRespuesta = ConstantesComunes.CODIGO_ERROR;
            usuarioRespuestaDTO.mensajeRespuesta = ConstantesComunes.MENSAJE_ERROR;
        }
        usuario = null;
        return usuarioRespuestaDTO;
    }

    public UsuarioRespuestaDTO recuperarUsuario(long id) {
        UsuarioRespuestaDTO usuarioRespuestaDTO = new UsuarioRespuestaDTO();
        try {
            Usuario usuario = usuarioDAO.recuperarRegistro(id);
            usuarioRespuestaDTO.usuarioDTO = mapearEntityADto(usuario);
            usuarioRespuestaDTO.usuarioDTO
                    .setRol(usuarioRolDAO.recuperarUsuarioRolPorUsuario(usuario.getUsername()).getRol());
            usuarioRespuestaDTO.codigoRespuesta = ConstantesComunes.CODIGO_EXITO;
            usuarioRespuestaDTO.mensajeRespuesta = ConstantesComunes.MENSAJE_EXITO;
            usuario = null;
        } catch (Exception e) {
            usuarioRespuestaDTO.excepcion = e;
            usuarioRespuestaDTO.codigoRespuesta = ConstantesComunes.CODIGO_ERROR;
            usuarioRespuestaDTO.mensajeRespuesta = ConstantesComunes.MENSAJE_ERROR;
        }
        return usuarioRespuestaDTO;
    }

    public UsuarioRespuestaDTO editarUsuario(UsuarioDTO usuarioDTO) {
        return null;
    }

    public UsuarioRespuestaDTO eliminarUsuario(long id) {
        return null;
    }


    public static UsuarioDTO mapearEntityADto(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setUsername(usuario.getUsername());
        usuarioDTO.setContrasena(usuario.getContrasenia());
        usuarioDTO.setHabilitado(usuario.isEnabled());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setApellidoPaterno(usuario.getApellidoPaterno());
        usuarioDTO.setApellidoMaterno(usuario.getApellidoMaterno());
        usuarioDTO.setNumeroTelefonico(usuario.getNumeroTelefonico());
        usuarioDTO.setCorreoElectronico(usuario.getCorreoElectronico());

        return usuarioDTO;
    }

    public static Usuario mapearDtoAEntity(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();

        usuario.setUsername(usuarioDTO.getUsername());
        usuario.setContrasenia(usuarioDTO.getContrasena());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setApellidoPaterno(usuarioDTO.getApellidoPaterno());
        usuario.setApellidoMaterno(usuarioDTO.getApellidoMaterno());
        usuario.setNumeroTelefonico(usuarioDTO.getNumeroTelefonico());
        usuario.setCorreoElectronico(usuarioDTO.getCorreoElectronico());

        return usuario;
    }
}
