package mx.nexsol.service.comun.impl;

import mx.nexsol.dao.comun.UsuarioDAO;
import mx.nexsol.dto.comun.UsuarioDTO;
import mx.nexsol.entity.comun.Usuario;
import mx.nexsol.response.UsuarioRespuestaDTO;
import mx.nexsol.service.comun.UsuarioService;
import mx.nexsol.util.ConstantesComunes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ironhide on 28/06/16.
 */

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;

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
        UsuarioRespuestaDTO usuarioRespuestaDTO = new UsuarioRespuestaDTO();
        usuarioDTO = null;
        try {
            usuario = usuarioDAO.guardarRegistro(usuario);
            usuarioRespuestaDTO.usuarioDTO = mapearEntityADto(usuario);
            usuarioRespuestaDTO.codigoRespuesta = ConstantesComunes.CODIGO_EXITO;
            usuarioRespuestaDTO.mensajeRespuesta = ConstantesComunes.MENSAJE_EXITO;
        }catch (Exception e) {
            usuarioRespuestaDTO.excepcion = e;
            usuarioRespuestaDTO.codigoRespuesta = ConstantesComunes.CODIGO_ERROR;
            usuarioRespuestaDTO.mensajeRespuesta = ConstantesComunes.MENSAJE_ERROR;
        }
        usuario = null;
        return usuarioRespuestaDTO;
    }

    public UsuarioRespuestaDTO editarUsuario(UsuarioDTO usuarioDTO) {
        return null;
    }

    public UsuarioRespuestaDTO eliminarUsuario(long id) {
        return null;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    private UsuarioDTO mapearEntityADto(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();

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

    private Usuario mapearDtoAEntity(UsuarioDTO usuarioDTO) {
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
