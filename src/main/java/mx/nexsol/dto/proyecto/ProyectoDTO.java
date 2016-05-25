package mx.nexsol.dto.proyecto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ProyectoDTO implements Serializable {
	
	/**
	 * Propiedad para mantener el estado del objeto entre las capas
	 */
	private static final long serialVersionUID = 957383533972729569L;

	private long id;
	
	private String nombre;
	
	private Date fechaCreacion;
	
	private List<CasoPruebaDTO> casosPrueba;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<CasoPruebaDTO> getCasosPrueba() {
		return casosPrueba;
	}

	public void setCasosPrueba(List<CasoPruebaDTO> casosPrueba) {
		this.casosPrueba = casosPrueba;
	}
	
	
	

}
