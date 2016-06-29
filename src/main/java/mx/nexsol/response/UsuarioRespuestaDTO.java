package mx.nexsol.response;

import mx.nexsol.dto.comun.UsuarioDTO;
import mx.nexsol.entity.comun.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ironhide on 28/06/16.
 */

@Component
public class UsuarioRespuestaDTO extends RespuestaDTO {

    @Autowired
    public UsuarioDTO usuarioDTO;

    public List<UsuarioDTO> usuarios;

    public Exception excepcion;

    public List<UsuarioDTO> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioDTO> usuarios) {
        this.usuarios = usuarios;
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }
}
