package mx.nexsol.entity.proyectos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import mx.nexsol.entity.comun.SequenceGenerator;

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
	
	@OneToMany
	@JoinColumn(name = "CASOS_PRUEBA")
	private List<CasoPrueba> casosPrueba;
	

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

	public List<CasoPrueba> getCasosPrueba() {
		return casosPrueba;
	}

	public void setCasosPrueba(List<CasoPrueba> casosPrueba) {
		this.casosPrueba = casosPrueba;
	}

}
