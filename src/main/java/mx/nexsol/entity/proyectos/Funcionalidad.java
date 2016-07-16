package mx.nexsol.entity.proyectos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import mx.nexsol.entity.catalogos.CatComplejidad;
import mx.nexsol.entity.comun.SequenceGenerator;

@Entity
@Data
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
	
	@Column(name = "COMPLEJIDAD_ID")
	private CatComplejidad complejidad;

	@Column(name = "ESTATUS", nullable = true)
	private int estatus;

	@ManyToOne
	@JoinColumn(name = "PROYECTO")
	private Proyecto proyecto;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "funcionalidad")
	private List<CasoPrueba> casosPrueba;


}
