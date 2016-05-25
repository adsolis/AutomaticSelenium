package mx.nexsol.entity.proyectos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Proyecto")
public class Proyecto implements Serializable {
	
	/**
	 * PROPIEDAD PARA MANTENER EL ESTADO DEL OBJETO1
	 */
	private static final long serialVersionUID = 1918524365583318395L;

	public Proyecto() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
