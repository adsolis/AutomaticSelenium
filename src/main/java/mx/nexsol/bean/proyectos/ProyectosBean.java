package mx.nexsol.bean.proyectos;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import lombok.Data;
import mx.nexsol.dto.proyecto.ProyectoDTO;
import mx.nexsol.service.proyecto.impl.ProyectoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import javax.annotation.PostConstruct;

@Controller
@ManagedBean(name = "proyectosBean")
@Scope(value = "request")
@Data
public class ProyectosBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2129959138137885765L;
	
	@ManagedProperty(value="#{proyectos}")
	private List<ProyectoDTO> proyectos;
	
	@Autowired
	private ProyectoServiceImpl proyectoService;
	
	@ManagedProperty(value="#{contexto}")
	private String contexto;

	@PostConstruct
	public void init() {
		proyectos = proyectoService.consultarListaProyectos();
	}

}
