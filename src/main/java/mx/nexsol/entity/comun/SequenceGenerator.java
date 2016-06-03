package mx.nexsol.entity.comun;

import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.*;

@MappedSuperclass
public abstract class SequenceGenerator {
    @Id
    @TableGenerator(name="SEQUENCE_TABLE",
            table="SEQUENCE_TABLE",
            pkColumnName="TABLE_SEQUENCE_NAME",
            valueColumnName="TABLE_SEQUENCE_VAL",
            initialValue=1,
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQUENCE_TABLE")
    private Long id;

    @Column(name="FECHA_ACTUALIZACION", nullable = true)
    private Date fechaActualizacion;

    @Column(name="FECHA_CREACION", nullable = true)
    private Date fechaCreacion;

    @Column(name = "FECHA_BORRADO", nullable = true)
    private Date fechaBorrado;

    /*@OneToOne
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "USUARIO_CREO", nullable = true)
    private Usuario usuarioCreo;

    @OneToOne
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "USUARIO_MODIFICA", nullable = true)
    private Usuario usuarioModifica;

    @OneToOne
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "USUARIO_BORRA", nullable = true)
    private Usuario usuarioBorra;*/

    @Column(name="VERSION", nullable = true)
    private Long version;

    public SequenceGenerator(){}

    //Getters y Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaBorrado() {
		return fechaBorrado;
	}

	public void setFechaBorrado(Date fechaBorrado) {
		this.fechaBorrado = fechaBorrado;
	}

	/*public Usuario getUsuarioCreo() {
		return usuarioCreo;
	}

	public void setUsuarioCreo(Usuario usuarioCreo) {
		this.usuarioCreo = usuarioCreo;
	}

	public Usuario getUsuarioModifica() {
		return usuarioModifica;
	}

	public void setUsuarioModifica(Usuario usuarioModifica) {
		this.usuarioModifica = usuarioModifica;
	}

	public Usuario getUsuarioBorra() {
		return usuarioBorra;
	}

	public void setUsuarioBorra(Usuario usuarioBorra) {
		this.usuarioBorra = usuarioBorra;
	}*/

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
    
}
