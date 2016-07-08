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
@Data
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

}
