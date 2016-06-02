package mx.nexsol.entity.catalogos;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import mx.nexsol.entity.comun.SequenceGenerator;

@Entity
@Table(name = "CAT_COMPLEJIDAD")
public class CatComplejidad extends SequenceGenerator implements Serializable {

	/**
	 * Propiedad para mantener el estado del objeto
	 */
	private static final long serialVersionUID = -8097306406340913091L;
	
	@Column(name = "NOMBRE_COMPLEJIDAD", nullable = false)
	private String nombreComplejidad;
	
	@Column(name = "MUNUTOS", nullable = false)
	private int minutos;
	
	@Column(name = "CRITERIO")
	private String criterio;

	public String getNombreComplejidad() {
		return nombreComplejidad;
	}

	public void setNombreComplejidad(String nombreComplejidad) {
		this.nombreComplejidad = nombreComplejidad;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public String getCriterio() {
		return criterio;
	}

	public void setCriterio(String criterio) {
		this.criterio = criterio;
	}
	
	
	

}
