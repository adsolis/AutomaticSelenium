package mx.nexsol.entity.proyectos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import mx.nexsol.entity.catalogos.CatComplejidad;
import mx.nexsol.entity.comun.SequenceGenerator;

@Entity
@Table(name = "FUNCIONALIDAD")
public class Funcionalidad extends SequenceGenerator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1845083029551231886L;

	
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	
	@Column(name = "IDENTIFICADOR", nullable = true)
	private String identificador;
	
	@Column(name = "COMPLEJIDAD_ID")
	private CatComplejidad complejidad;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "FUNCIONALIDAD_ID", nullable = true)
	private List<CasoPrueba> casosPrueba;

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

	public List<CasoPrueba> getCasosPrueba() {
		return casosPrueba;
	}

	public void setCasosPrueba(List<CasoPrueba> casosPrueba) {
		this.casosPrueba = casosPrueba;
	}
}
