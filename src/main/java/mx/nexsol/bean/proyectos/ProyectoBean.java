package mx.nexsol.bean.proyectos;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import mx.nexsol.dto.catalogos.CatComplejidadDTO;
import mx.nexsol.dto.proyecto.FuncionalidadDTO;
import mx.nexsol.dto.proyecto.ProyectoDTO;
import mx.nexsol.service.catalogos.impl.CatComplejidadServiceImpl;
import mx.nexsol.service.proyecto.impl.ProyectoServiceImpl;
import mx.nexsol.util.ConstantesComunes;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;

@Controller
@ManagedBean(name = "proyectoBean")
@Scope(value = "request")
@ViewScoped
public class ProyectoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2630444134154506428L;
	
	@Autowired
	@ManagedProperty(value="#{proyectoDTO}")
	private ProyectoDTO proyectoDTO;
	
	
	@ManagedProperty(value="#{funcionalidadesDTO}")
	private List<FuncionalidadDTO> funcionalidadesDTO;
	
	@Autowired
	@ManagedProperty(value = "#{funcionalidadDTO}")
	private FuncionalidadDTO funcionalidadDTO;
	
	private List<CatComplejidadDTO> listaCatalogoComplejidad;
	
	@Autowired
	private ProyectoServiceImpl proyectoService;
	
	@Autowired
	private CatComplejidadServiceImpl catComplejidadService;
	
	@PostConstruct
	public void init() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = request.getSession();
		if(request.getParameter("id")!=null) {
			Long idProyecto = Long.parseLong(request.getParameter("id"));
			proyectoDTO = proyectoService.consultarProyecto(idProyecto);
			funcionalidadesDTO = proyectoDTO.getFuncionalidades();
			if(request.getParameter("detalle")!=null) {
				listaCatalogoComplejidad = catComplejidadService.listarCatalogoComplejidad();
				listaCatalogoComplejidad = (List<CatComplejidadDTO>) session.getAttribute("listaCatalogoComplejidad");
				session.setAttribute("listaCatalogoComplejidad", listaCatalogoComplejidad);
			}
		}
		
		
		/**try {
			System.out.println("va a intentar ejecutar el jar");
			Runtime.getRuntime().exec("java -jar Users/ironhide/Desktop/EjecucionPrueba.jar");
			System.out.println("se supone que ya");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	public void guardarProyecto() throws Exception {
		try {
			proyectoDTO = proyectoService.guardarProyecto(proyectoDTO);
			if(proyectoDTO.getResultado()==ConstantesComunes.EXITO) {
				FacesContext context = FacesContext.getCurrentInstance();
	            context.getExternalContext().getFlash().setKeepMessages(true);

	            FacesContext.getCurrentInstance().addMessage
	                    (null, new FacesMessage
	                            (FacesMessage.SEVERITY_INFO,"Exito", "Se ha guardado el proyecto"));

	            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	            externalContext.redirect(externalContext.getRequestContextPath()
	                    .concat(ConstantesComunes.DETALLE_PROYECTO));
			}
			else {
				FacesContext.getCurrentInstance().addMessage
                (null, new FacesMessage
                        (FacesMessage.SEVERITY_ERROR,"Error", "Ocurrio un problema al generar el acta de nacimiento"));
        RequestContext.getCurrentInstance().execute("errorDialog.show()");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
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
	
	public void guardarFuncionalidades() {
		HttpSession session = 
				((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getSession();
		List<FuncionalidadDTO> funcionalidades = (List<FuncionalidadDTO>) session.getAttribute("listaFuncionalidades");
		try {
			proyectoDTO = proyectoService.agregarFuncionalidades(funcionalidades, proyectoDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void generarListaFuncionalidades() {
		HttpServletRequest request = 
				(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = request.getSession();
		funcionalidadesDTO = (List<FuncionalidadDTO>) session.getAttribute("listaFuncionalidades");
		listaCatalogoComplejidad = (List<CatComplejidadDTO>) session.getAttribute("listaCatalogoComplejidad");
		if(funcionalidadesDTO==null)
			funcionalidadesDTO = new ArrayList<FuncionalidadDTO>();
		/*for(CatComplejidadDTO complejidad: listaCatalogoComplejidad) {
			if(complejidad.getId() == Long.parseLong(idComplejidad)) {
				funcionalidad.setComplejidad(complejidad);
			}
		}*/
		funcionalidadesDTO.add(funcionalidadDTO);
		session.setAttribute("listaFuncionalidades", funcionalidadesDTO);

	}
	
	public void quitarFuncionalidad(String nombre) {
		HttpServletRequest request = 
				(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = request.getSession();
		FuncionalidadDTO fun = null;
		funcionalidadesDTO = (List<FuncionalidadDTO>) session.getAttribute("listaFuncionalidades");
		for(FuncionalidadDTO funcionalidad: funcionalidadesDTO) {
			if(funcionalidad.getNombreFuncionalidad().equals(nombre)) {
				fun = funcionalidad;
				break;
			}
		}
		funcionalidadesDTO.remove(fun);
		fun = null;
		session.setAttribute("listaFuncionalidades", funcionalidadesDTO);

	}

	public ProyectoDTO getProyectoDTO() {
		return proyectoDTO;
	}

	public void setProyectoDTO(ProyectoDTO proyectoDTO) {
		this.proyectoDTO = proyectoDTO;
	}

	public List<FuncionalidadDTO> getFuncionalidadesDTO() {
		return funcionalidadesDTO;
	}

	public void setFuncionalidadesDTO(List<FuncionalidadDTO> funcionalidadesDTO) {
		this.funcionalidadesDTO = funcionalidadesDTO;
	}

	public ProyectoServiceImpl getProyectoService() {
		return proyectoService;
	}

	public void setProyectoService(ProyectoServiceImpl proyectoService) {
		this.proyectoService = proyectoService;
	}

	public List<CatComplejidadDTO> getListaCatalogoComplejidad() {
		return listaCatalogoComplejidad;
	}

	public void setListaCatalogoComplejidad(
			List<CatComplejidadDTO> listaCatalogoComplejidad) {
		this.listaCatalogoComplejidad = listaCatalogoComplejidad;
	}

	public CatComplejidadServiceImpl getCatComplejidadService() {
		return catComplejidadService;
	}

	public void setCatComplejidadService(
			CatComplejidadServiceImpl catComplejidadService) {
		this.catComplejidadService = catComplejidadService;
	}

	public FuncionalidadDTO getFuncionalidadDTO() {
		return funcionalidadDTO;
	}

	public void setFuncionalidadDTO(FuncionalidadDTO funcionalidadDTO) {
		this.funcionalidadDTO = funcionalidadDTO;
	}

}
