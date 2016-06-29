package mx.nexsol.entity.catalogos;

import java.io.Serializable;

import mx.nexsol.entity.comun.SequenceGenerator;

import javax.persistence.*;

/**
 * Created by ironhide on 28/06/16.
 */

@Entity
@Table(name = "EMPRESA")
public class Empresa extends SequenceGenerator implements Serializable {

    public Empresa() {

    }


    /**
	 * 
	 */
	private static final long serialVersionUID = 6992659452221480923L;

	@Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @OneToOne
    @JoinColumn (name = "PAIS", nullable = false)
    private CatPais pais;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CatPais getPais() {
        return pais;
    }

    public void setPais(CatPais pais) {
        this.pais = pais;
    }
}
