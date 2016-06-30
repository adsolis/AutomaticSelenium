package mx.nexsol.bean.seguridad;

import mx.nexsol.response.UsuarioRespuestaDTO;
import mx.nexsol.service.comun.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.io.Serializable;

/**
 * Created by ironhide on 28/06/16.
 */

@Controller
@ManagedBean(name = "usuariosBean")
@Scope(value = "request")
public class UsuariosBean implements Serializable {

    @ManagedProperty(value = "#{usuarioRespuestaDTO}")
    private UsuarioRespuestaDTO usuarioRespuestaDTO;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @PostConstruct
    public void init() {
        usuarioRespuestaDTO = usuarioService.recuperarUsuarios();
    }

    public UsuarioRespuestaDTO getUsuarioRespuestaDTO() {
        return usuarioRespuestaDTO;
    }

    public void setUsuarioRespuestaDTO(UsuarioRespuestaDTO usuarioRespuestaDTO) {
        this.usuarioRespuestaDTO = usuarioRespuestaDTO;
    }

    public UsuarioServiceImpl getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioServiceImpl usuarioService) {
        this.usuarioService = usuarioService;
    }
}
