package mx.nexsol.bean.proyectos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import mx.nexsol.dto.proyecto.PasoCasoPruebaDTO;
import mx.nexsol.dto.proyecto.ProyectoDTO;
import mx.nexsol.service.proyecto.impl.ProyectoServiceImpl;
import mx.nexsol.util.ConstantesComunes;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;

@Controller
@ManagedBean(name = "proyectoBean")
@Scope(value = "request")
public class ProyectoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2630444134154506428L;
	
	@Autowired
	@ManagedProperty(value="#{proyectoDTO}")
	private ProyectoDTO proyectoDTO;
	
	@ManagedProperty(value="#{pasosCaso}")
	private List<PasoCasoPruebaDTO> pasosCaso;
	
	@Autowired
	private ProyectoServiceImpl proyectoService;
	
	@PostConstruct
	public void init() {
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
	
	public List<PasoCasoPruebaDTO> generarListaPasos(HttpServletRequest request, String descripcion, String resultadoEsperado) {
		PasoCasoPruebaDTO paso = new PasoCasoPruebaDTO();
		HttpSession session = request.getSession();
		pasosCaso = (List<PasoCasoPruebaDTO>) session.getAttribute("listaPasos");
		if(pasosCaso!=null)
			pasosCaso = new ArrayList<PasoCasoPruebaDTO>();
		paso.setNumeroDePaso(pasosCaso.size()+1);
		paso.setDescripcionPaso(descripcion);
		paso.setResultadoEsperado(resultadoEsperado);
		pasosCaso.add(paso);
		session.setAttribute("listaPasos", pasosCaso);
		
		return pasosCaso;
	}
	
	public List<PasoCasoPruebaDTO> quitarPaso(HttpServletRequest request, int numeroPaso) {
		HttpSession session = request.getSession();
		pasosCaso = (List<PasoCasoPruebaDTO>) session.getAttribute("listaPasos");
		pasosCaso.remove(numeroPaso);
		
		for(PasoCasoPruebaDTO paso: pasosCaso) {
			paso.setNumeroDePaso(paso.getNumeroDePaso()-1);
		}
		
		return pasosCaso;
	}

	public ProyectoDTO getProyectoDTO() {
		return proyectoDTO;
	}

	public void setProyectoDTO(ProyectoDTO proyectoDTO) {
		this.proyectoDTO = proyectoDTO;
	}

	public List<PasoCasoPruebaDTO> getPasosCaso() {
		return pasosCaso;
	}

	public void setPasosCaso(List<PasoCasoPruebaDTO> pasosCaso) {
		this.pasosCaso = pasosCaso;
	}

	public ProyectoServiceImpl getProyectoService() {
		return proyectoService;
	}

	public void setProyectoService(ProyectoServiceImpl proyectoService) {
		this.proyectoService = proyectoService;
	}

}
