package mx.nexsol.entity.proyectos;

import mx.nexsol.entity.comun.SequenceGenerator;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "CASO_PRUEBA")
public class CasoPrueba extends SequenceGenerator implements Serializable {

	public CasoPrueba() {

	}

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

	@ManyToOne
	@JoinColumn(name = "FUNCIONALIDAD")
	private Funcionalidad funcionalidad;

	@Column(name = "TIEMPO_ESTIMACION")
	private int tiempoEstimacion;

	@Column(name = "TIEMPO_REAL")
	private int tiempoReal;

	@Column(name = "TIEMPO_ESTIMACION_ENTRADA")
	private int tiempoEstimadoEntrada;

	@Column(name = "TIEMPO_ESTIMACION_SALIDA")
	private int tiempoEstimadoSalida;

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

	public Funcionalidad getFuncionalidad() {
		return funcionalidad;
	}

	public void setFuncionalidad(Funcionalidad funcionalidad) {
		this.funcionalidad = funcionalidad;
	}

	public int getTiempoEstimacion() {
		return tiempoEstimacion;
	}

	public void setTiempoEstimacion(int tiempoEstimacion) {
		this.tiempoEstimacion = tiempoEstimacion;
	}

	public int getTiempoReal() {
		return tiempoReal;
	}

	public void setTiempoReal(int tiempoReal) {
		this.tiempoReal = tiempoReal;
	}

	public int getTiempoEstimadoEntrada() {
		return tiempoEstimadoEntrada;
	}

	public void setTiempoEstimadoEntrada(int tiempoEstimadoEntrada) {
		this.tiempoEstimadoEntrada = tiempoEstimadoEntrada;
	}

	public int getTiempoEstimadoSalida() {
		return tiempoEstimadoSalida;
	}

	public void setTiempoEstimadoSalida(int tiempoEstimadoSalida) {
		this.tiempoEstimadoSalida = tiempoEstimadoSalida;
	}
}
