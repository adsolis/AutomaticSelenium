package mx.nexsol.dto.proyecto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.config.BeanDefinition;


@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ProyectoDTO implements Serializable {
	
	/**
	 * Propiedad para mantener el estado del objeto entre las capas
	 */
	private static final long serialVersionUID = 957383533972729569L;

	private long id;
	
	private String nombre;
	
	private Date fechaCreacion;
	
	private List<CasoPruebaDTO> casosPrueba;
	
	private String estrategia;

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

	public String getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(String estrategia) {
		this.estrategia = estrategia;
	}
	
	
	

}
