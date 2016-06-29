package mx.nexsol.bean.seguridad;

import mx.nexsol.dto.comun.UsuarioDTO;
import mx.nexsol.response.UsuarioRespuestaDTO;
import mx.nexsol.service.comun.impl.UsuarioServiceImpl;
import mx.nexsol.util.ConstantesComunes;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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

    @PostConstruct
    public void init() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        if(request.getParameter("id")!=null) {
            Long idUsuario = Long.parseLong(request.getParameter("id"));
            usuarioDTO = (usuarioService.recuperarUsuario(idUsuario)).usuarioDTO;
        }
    }

    public void guardarUsuario() {
        try {
            UsuarioRespuestaDTO usuarioRespuestaDTO = usuarioService.guardarUsuario(usuarioDTO);
            if(usuarioRespuestaDTO.codigoRespuesta==ConstantesComunes.CODIGO_EXITO) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.getExternalContext().getFlash().setKeepMessages(true);

                FacesContext.getCurrentInstance().addMessage
                        (null, new FacesMessage
                                (FacesMessage.SEVERITY_INFO,"Exito", "Se ha guardado el proyecto"));

                ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
                externalContext.redirect(externalContext.getRequestContextPath()
                        .concat(ConstantesComunes.DETALLE_USUARIO));
            }
            else {
                FacesContext.getCurrentInstance().addMessage
                        (null, new FacesMessage
                                (FacesMessage.SEVERITY_ERROR,"Error", "Ocurrio un problema al guardar el usuario"));
                RequestContext.getCurrentInstance().execute("errorDialog.show()");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

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
