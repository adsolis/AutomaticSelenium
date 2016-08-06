package mx.nexsol.dto.catalogos;

import java.io.Serializable;

import lombok.Data;

import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@EqualsAndHashCode(callSuper = false, of = {"id"})
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CatComplejidadDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4990026639899792666L;
	
	private long id;

	private String descripcionComplejidad;
	
	private int limiteTiempoMiutos;

	private String nombreComplejidad;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcionComplejidad() {
		return descripcionComplejidad;
	}

	public void setDescripcionComplejidad(String descripcionComplejidad) {
		this.descripcionComplejidad = descripcionComplejidad;
	}

	public int getLimiteTiempoMiutos() {
		return limiteTiempoMiutos;
	}

	public void setLimiteTiempoMiutos(int limiteTiempoMiutos) {
		this.limiteTiempoMiutos = limiteTiempoMiutos;
	}

	public String getNombreComplejidad() {
		return nombreComplejidad;
	}

	public void setNombreComplejidad(String nombreComplejidad) {
		this.nombreComplejidad = nombreComplejidad;
	}
}
