package mx.nexsol.bean.seguridad;

import mx.nexsol.dto.comun.UsuarioDTO;
import mx.nexsol.response.UsuarioRespuestaDTO;
import mx.nexsol.service.comun.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * Created by ironhide on 29/06/16.
 */

@Controller
@ManagedBean(name = "usuarioBean")
@Scope(value = "request")
@ViewScoped
public class UsuarioBean {

    @Autowired
    @ManagedProperty(value = "#{usuarioDTO}")
    private UsuarioDTO usuarioDTO;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    public void guardarUsuario() {
        UsuarioRespuestaDTO usuarioRespuestaDTO = usuarioService.guardarUsuario(usuarioDTO);

    }


    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }

    public UsuarioServiceImpl getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioServiceImpl usuarioService) {
        this.usuarioService = usuarioService;
    }
}
