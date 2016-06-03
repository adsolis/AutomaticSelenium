package mx.nexsol.entity.showcase;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import mx.nexsol.entity.comun.SequenceGenerator;

@Entity
@Table(name = "PERSONA")
public class Persona extends SequenceGenerator implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2388684966588050359L;

	public Persona() {
		
	}
	
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	
	@Column(name = "EDAD", nullable = true)
	private String edad;
	
	@Column(name = "FECHA_NACIMIENTO", nullable = true)
	private Date fechaNacimiento;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	

}
