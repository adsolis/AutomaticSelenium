package mx.nexsol.bean.proyectos;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mx.nexsol.dto.proyecto.PasoCasoPruebaDTO;
import mx.nexsol.dto.proyecto.ProyectoDTO;

@ViewScoped
@ManagedBean(name = "proyectoBean")
public class ProyectoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2630444134154506428L;
	
	@ManagedProperty(value="#{proyectoDTO}")
	private ProyectoDTO proyectoDTO;
	
	@ManagedProperty(value="#{pasosCaso}")
	private List<PasoCasoPruebaDTO> pasosCaso;
	
	@PostConstruct
	public void init() {
		proyectoDTO.setId(1);
		proyectoDTO.setNombre("Proyecto de Prueba");
		proyectoDTO.setFechaCreacion(new Date());
		/**try {
			System.out.println("va a intentar ejecutar el jar");
			Runtime.getRuntime().exec("java -jar Users/ironhide/Desktop/EjecucionPrueba.jar");
			System.out.println("se supone que ya");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
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
	
	

}
