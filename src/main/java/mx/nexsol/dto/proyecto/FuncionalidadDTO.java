package mx.nexsol.dto.proyecto;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import mx.nexsol.dto.catalogos.CatComplejidadDTO;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class FuncionalidadDTO implements Serializable {
	
	/**
	 * Propiedad para mantener el estado del objeto
	 */
	private static final long serialVersionUID = 5438469381234739028L;

	private long id;
	
	private String nombreFuncionalidad;
	
	private String identificador;
	
	private CatComplejidadDTO complejidad;

	private ProyectoDTO proyectoDTO;

	private int statusVista;

	private int estatusRegistro;

	private List<CasoPruebaDTO> casosPrueba;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreFuncionalidad() {
		return nombreFuncionalidad;
	}

	public void setNombreFuncionalidad(String nombreFuncionalidad) {
		this.nombreFuncionalidad = nombreFuncionalidad;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public CatComplejidadDTO getComplejidad() {
		return complejidad;
	}

	public void setComplejidad(CatComplejidadDTO complejidad) {
		this.complejidad = complejidad;
	}

	public ProyectoDTO getProyectoDTO() {
		return proyectoDTO;
	}

	public void setProyectoDTO(ProyectoDTO proyectoDTO) {
		this.proyectoDTO = proyectoDTO;
	}

	public int getStatusVista() {
		return statusVista;
	}

	public void setStatusVista(int statusVista) {
		this.statusVista = statusVista;
	}

	public int getEstatusRegistro() {
		return estatusRegistro;
	}

	public void setEstatusRegistro(int estatusRegistro) {
		this.estatusRegistro = estatusRegistro;
	}

	public List<CasoPruebaDTO> getCasosPrueba() {
		return casosPrueba;
	}

	public void setCasosPrueba(List<CasoPruebaDTO> casosPrueba) {
		this.casosPrueba = casosPrueba;
	}
}
