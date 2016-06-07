package mx.nexsol.bean.proyectos;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import mx.nexsol.dto.proyecto.ProyectoDTO;
import mx.nexsol.service.proyecto.impl.ProyectoServiceImpl;
import mx.nexsol.util.ConstantesComunes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "detalleProyectoBean")
@Scope(value = "request")
public class DetalleProyectoBean {
	
	@ManagedProperty(value="#{proyectoDTO}")
	private ProyectoDTO proyectoDTO;
	
	@Autowired
	private ProyectoServiceImpl proyectoService;
	
	public void consultarProyecto(ProyectoDTO proyecto) {
		proyectoDTO = proyecto;
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
        	externalContext.redirect(externalContext.getRequestContextPath()
                    .concat(ConstantesComunes.DETALLE_PROYECTO));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ProyectoDTO getProyectoDTO() {
		return proyectoDTO;
	}

	public void setProyectoDTO(ProyectoDTO proyectoDTO) {
		this.proyectoDTO = proyectoDTO;
	}

	public ProyectoServiceImpl getProyectoService() {
		return proyectoService;
	}

	public void setProyectoService(ProyectoServiceImpl proyectoService) {
		this.proyectoService = proyectoService;
	}

}
