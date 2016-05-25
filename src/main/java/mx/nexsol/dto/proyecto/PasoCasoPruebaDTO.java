package mx.nexsol.dto.proyecto;

import java.io.Serializable;

/**
 * Clase que representa cada paso de los casos de prueba
 * @author ironhide
 *
 */
public class PasoCasoPruebaDTO implements Serializable {

	/**
	 * Propiedad para mantener el estado del objeto
	 */
	private static final long serialVersionUID = 1821457443366170129L;
	
	private long id;
	
	private int numeroDePaso;
	
	private String descripcionPaso;
	
	private String resultadoEsperado;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumeroDePaso() {
		return numeroDePaso;
	}

	public void setNumeroDePaso(int numeroDePaso) {
		this.numeroDePaso = numeroDePaso;
	}

	public String getDescripcionPaso() {
		return descripcionPaso;
	}

	public void setDescripcionPaso(String descripcionPaso) {
		this.descripcionPaso = descripcionPaso;
	}

	public String getResultadoEsperado() {
		return resultadoEsperado;
	}

	public void setResultadoEsperado(String resultadoEsperado) {
		this.resultadoEsperado = resultadoEsperado;
	}
	
	
	

}
