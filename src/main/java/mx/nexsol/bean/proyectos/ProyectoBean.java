package mx.nexsol.bean.proyectos;

import java.io.IOException;
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
	
	@ManagedProperty(value = "#{desabilitar}")
	private String desabilitar;
	
	@Autowired
	private ProyectoServiceImpl proyectoService;
	
	@PostConstruct
	public void init() {
		proyectoDTO.setId(1L);
		proyectoDTO.setNombre("Proyecto de Prueba");
		proyectoDTO.setFechaCreacion(new Date());
		desabilitar = "";
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

	public String getDesabilitar() {
		return desabilitar;
	}

	public void setDesabilitar(String desabilitar) {
		this.desabilitar = desabilitar;
	}
	
	

}
