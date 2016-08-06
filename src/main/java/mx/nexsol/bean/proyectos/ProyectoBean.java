package mx.nexsol.bean.proyectos;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import lombok.Data;
import mx.nexsol.request.FuncionalidadRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mx.nexsol.dto.comun.UsuarioDTO;
import mx.nexsol.service.catalogos.CatComplejidadService;
import mx.nexsol.service.comun.UsuarioService;
import mx.nexsol.service.proyecto.ProyectoService;
import mx.nexsol.dto.catalogos.CatComplejidadDTO;
import mx.nexsol.dto.proyecto.FuncionalidadDTO;
import mx.nexsol.dto.proyecto.ProyectoDTO;
import mx.nexsol.util.ConstantesComunes;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;

@Data
@ManagedBean(name = "proyectoBean")
@ViewScoped
public class ProyectoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2630444134154506428L;
	
	@Autowired
	@ManagedProperty(value="#{proyectoDTO}")
	private ProyectoDTO proyectoDTO;

	@ManagedProperty(value = "#{banderaFuncionalidadesModificadas}")
	private boolean banderaFuncionalidadesModificadas;

	@ManagedProperty(value="#{funcionalidadesDTO}")
	private List<FuncionalidadDTO> funcionalidadesDTO;
	
	@Autowired
	@ManagedProperty(value = "#{funcionalidadDTO}")
	private FuncionalidadDTO funcionalidadDTO;

	@ManagedProperty(value = "#{listaCatalogoComplejidad}")
	private List<CatComplejidadDTO> listaCatalogoComplejidad;

	@ManagedProperty(value = "#{usuarioDTOs}")
	private List<UsuarioDTO> usuarioDTOs;

	@ManagedProperty(name = "proyectoService", value = "#{proyectoService}")
	private ProyectoService proyectoService;

	@ManagedProperty(name = "catComplejidadService", value = "#{catComplejidadService}")
	private CatComplejidadService catComplejidadService;

	@ManagedProperty(name = "usuarioService", value = "#{usuarioService}")
	private UsuarioService usuarioService;

	@Autowired
	@ManagedProperty(value = "#{funcionalidadRequestDTO}")
	private FuncionalidadRequestDTO funcionalidadRequestDTO;
	
	@PostConstruct
	public void init() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = request.getSession();
		if(request.getParameter("id")!=null) {
			Long idProyecto = Long.parseLong(request.getParameter("id"));
			proyectoDTO = proyectoService.consultarProyecto(idProyecto);
			funcionalidadesDTO = proyectoDTO.getFuncionalidades();
			session.setAttribute("listaFuncionalidadesExistentes", funcionalidadesDTO);
			if(request.getParameter("detalle")!=null) {
				listaCatalogoComplejidad = catComplejidadService.listarCatalogoComplejidad();
				session.setAttribute("listaCatalogoComplejidad", listaCatalogoComplejidad);
			}
		}

		if(request.getParameter("registro")!=null) {
			usuarioDTOs = (usuarioService.recuperarUsuarios()).getUsuarios();
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
			if(proyectoDTO.getResultado()==ConstantesComunes.CODIGO_EXITO) {
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
                        (FacesMessage.SEVERITY_ERROR,"Error", "Ocurrio un problema al g"));
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

		funcionalidadDTO.setEstatusRegistro(1);
		funcionalidadesDTO.add(funcionalidadDTO);
		banderaFuncionalidadesModificadas = true;

		session.setAttribute("listaFuncionalidades", funcionalidadesDTO);

	}

	public void editarFuncionalidad(int posicionFuncionalidad) {
		HttpServletRequest request =
				(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = request.getSession();
		funcionalidadesDTO = (List<FuncionalidadDTO>) session.getAttribute("listaFuncionalidades");

		for(FuncionalidadDTO fun: funcionalidadesDTO) {
			if(funcionalidadesDTO.indexOf(fun)==posicionFuncionalidad)
				fun = funcionalidadDTO;
			fun.setEstatusRegistro(2);
		}
		banderaFuncionalidadesModificadas = true;
		session.setAttribute("listaFuncionalidades", funcionalidadesDTO);
	}

	//TODO verificar validaciones y literales
	public void quitarFuncionalidad(int posicionFuncionalidad) {
		HttpServletRequest request = 
				(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = request.getSession();
		funcionalidadesDTO = (List<FuncionalidadDTO>) session.getAttribute("listaFuncionalidades");
		FuncionalidadDTO fun = null;
		for(FuncionalidadDTO funcionalidad: funcionalidadesDTO) {
			if(funcionalidadesDTO.indexOf(funcionalidad)==posicionFuncionalidad) {
				if(proyectoDTO.getEstatus().equals("creado") && funcionalidad.getId()!=0L) {
					funcionalidad.setEstatusRegistro(4);
					fun = funcionalidad;
				}
			}
		}

		if(fun!=null)
			eliminarFuncionalidadExistente(fun);

		funcionalidadesDTO.remove(fun);
		fun = null;
		session.setAttribute("listaFuncionalidades", funcionalidadesDTO);

	}

	private void eliminarFuncionalidadExistente(FuncionalidadDTO funcionalidadDTO) {
		proyectoService.quitarFuncionalidad(funcionalidadDTO, proyectoDTO);
	}

}
