package mx.nexsol.dto.proyecto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;
import mx.nexsol.dto.comun.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.config.BeanDefinition;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ProyectoDTO implements Serializable {
	
	/**
	 * Propiedad para mantener el estado del objeto entre las capas
	 */
	private static final long serialVersionUID = 957383533972729569L;

	private long id;
	
	private String nombre;
	
	private Date fechaCreacion;
	
	private List<FuncionalidadDTO> funcionalidades;
	
	private String estrategia;
	
	private int resultado;
	
	private String estatus;

	@Autowired
	private UsuarioDTO usuarioDTO;

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}

	public String getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(String estrategia) {
		this.estrategia = estrategia;
	}

	public List<FuncionalidadDTO> getFuncionalidades() {
		return funcionalidades;
	}

	public void setFuncionalidades(List<FuncionalidadDTO> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
