package mx.nexsol.converter;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mx.nexsol.dto.catalogos.CatComplejidadDTO;

import org.springframework.stereotype.Component;

@ManagedBean(name = "complejidadConverter")
@Component
public class ComplejidadConverter implements Converter {
	

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		HttpSession session =
				((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getSession();
		List<CatComplejidadDTO> listaCatalogoComplejidad = 
				(List<CatComplejidadDTO>) session.getAttribute("listaCatalogoComplejidad");
		CatComplejidadDTO complejidadDTO = null;
		
		for(CatComplejidadDTO complejidad: listaCatalogoComplejidad) {
			if(complejidad.getId()==Long.parseLong(value)) {
				complejidadDTO = complejidad;
				break;
			}
		}
		return complejidadDTO;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object object) {
		if(object != null) {
            return String.valueOf(((CatComplejidadDTO) object).getId());
        }
        else {
            return null;
        }
	}

}
