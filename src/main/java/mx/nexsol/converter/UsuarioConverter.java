package mx.nexsol.converter;

import mx.nexsol.dto.comun.UsuarioDTO;
import mx.nexsol.service.comun.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * Created by ironhide on 29/06/16.
 */

@ManagedBean(name = "usuarioConverter")
@Component
public class UsuarioConverter implements Converter {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
                              String value) {
        return (usuarioService.recuperarUsuario(Long.parseLong(value))).usuarioDTO;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
                              Object object) {
        if(object != null) {
            return String.valueOf(((UsuarioDTO) object).getId());
        }
        else {
            return null;
        }
    }

    public UsuarioServiceImpl getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioServiceImpl usuarioService) {
        this.usuarioService = usuarioService;
    }
}
