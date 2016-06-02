package mx.nexsol.entity.proyectos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import mx.nexsol.entity.catalogos.CatComplejidad;
import mx.nexsol.entity.comun.SequenceGenerator;

@Entity
@Table(name = "Funcionalidad")
public class Funcionalidad extends SequenceGenerator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1845083029551231886L;

	
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	
	@Column(name = "IDENTIFICADOR", nullable = false)
	private String identificador;
	
	@Column(name = "COMPLEJIDAD_ID")
	@OneToOne
	private CatComplejidad complejidad;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public CatComplejidad getComplejidad() {
		return complejidad;
	}

	public void setComplejidad(CatComplejidad complejidad) {
		this.complejidad = complejidad;
	}
	
	
	

}
