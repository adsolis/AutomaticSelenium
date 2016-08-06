package mx.nexsol.entity.proyectos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import mx.nexsol.entity.catalogos.CatComplejidad;
import mx.nexsol.entity.comun.SequenceGenerator;

@Entity
@Table(name = "FUNCIONALIDAD")
public class Funcionalidad extends SequenceGenerator implements Serializable {

	public Funcionalidad() {

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1845083029551231886L;

	
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	
	@Column(name = "IDENTIFICADOR", nullable = true)
	private String identificador;

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "COMPLEJIDAD")
	private CatComplejidad complejidad;

	@Column(name = "ESTATUS", nullable = true)
	private int estatus;

	@ManyToOne
	@JoinColumn(name = "PROYECTO")
	private Proyecto proyecto;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "funcionalidad")
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

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public List<CasoPrueba> getCasosPrueba() {
		return casosPrueba;
	}

	public void setCasosPrueba(List<CasoPrueba> casosPrueba) {
		this.casosPrueba = casosPrueba;
	}
}
