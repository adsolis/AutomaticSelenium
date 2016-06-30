package mx.nexsol.entity.proyectos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import mx.nexsol.entity.comun.SequenceGenerator;
import mx.nexsol.entity.comun.Usuario;

@Entity
@Table(name = "PROYECTO")
public class Proyecto extends SequenceGenerator implements Serializable {
	
	/**
	 * PROPIEDAD PARA MANTENER EL ESTADO DEL OBJETO1
	 */
	private static final long serialVersionUID = 1918524365583318395L;

	public Proyecto() {
		
	}
	
	
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	
	@Column(name = "ESTIMACION", nullable = true)
	private String estimacion;
	
	@Column(name = "ESTATUS", nullable = true)
	private int estatus;
	
	@Column(name = "DETALLE", nullable = true)
	private String detalle;
	
	@Column(name = "ESTRATEGIA")
	private String estrategia;

	@OneToOne
	@JoinColumn(name = "USUARIO")
	private Usuario usuario;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proyecto")
	private List<Funcionalidad> funcionalidad;
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstimacion() {
		return estimacion;
	}

	public void setEstimacion(String estimacion) {
		this.estimacion = estimacion;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public List<Funcionalidad> getFuncionalidad() {
		return funcionalidad;
	}

	public void setFuncionalidad(List<Funcionalidad> funcionalidad) {
		this.funcionalidad = funcionalidad;
	}

	public String getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(String estrategia) {
		this.estrategia = estrategia;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
