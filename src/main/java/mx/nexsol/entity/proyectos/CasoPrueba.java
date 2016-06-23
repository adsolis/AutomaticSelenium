package mx.nexsol.entity.proyectos;

import mx.nexsol.entity.comun.SequenceGenerator;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CASO_PRUEBA")
public class CasoPrueba extends SequenceGenerator implements Serializable {

	/**
	 * PROPIEDAD PARA MANTENER EL ESTADO DEL OBJETO
	 */
	private static final long serialVersionUID = 8494685699529588557L;
	
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	
	@Column(name = "PASOS")
	private String pasos;

	@Column(name = "ID_CASO")
	private String idCasoPrueba;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPasos() {
		return pasos;
	}

	public void setPasos(String pasos) {
		this.pasos = pasos;
	}

	public String getIdCasoPrueba() {
		return idCasoPrueba;
	}

	public void setIdCasoPrueba(String idCasoPrueba) {
		this.idCasoPrueba = idCasoPrueba;
	}
}
