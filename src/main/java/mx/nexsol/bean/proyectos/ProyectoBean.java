package mx.nexsol.bean.proyectos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	}
	
	public List<PasoCasoPruebaDTO> generarListaPasos(String descripcion, String resultadoEsperado) {
		List<PasoCasoPruebaDTO> temporal = null;
		if(pasosCaso!=null)
			pasosCaso = new ArrayList<PasoCasoPruebaDTO>();
		
		
		
		return null;
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
