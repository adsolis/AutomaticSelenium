package mx.nexsol.entity.comun;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO_ROL")
public class UsuarioRol extends SequenceGenerator {
	
	@Column(name = "rol")
	private String rol;
	
	@Column(name = "usuario")
	private String usuario;

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	

}
