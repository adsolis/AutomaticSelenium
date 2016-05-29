package mx.nexsol.entity.proyectos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PASO_CASO_PRUEBA")
public class PasoCasoPrueba implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5676423525134842785L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "NUMERO_DE_PASO", nullable = false)
	private int numeroDePaso;
	
	@Column(name = "DESCRIPCION_PASO", nullable = false)
	private String descripcionPaso;
	
}
