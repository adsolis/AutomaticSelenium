package mx.nexsol.entity.catalogos;

import mx.nexsol.entity.comun.SequenceGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ironhide on 28/06/16.
 */

@Entity
@Table(name = "CAT_PAIS")
public class CatPais extends SequenceGenerator implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 9093213048051760491L;

	public CatPais() {

    }

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
