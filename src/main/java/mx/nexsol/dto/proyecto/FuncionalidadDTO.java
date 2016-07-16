package mx.nexsol.dto.proyecto;

import java.io.Serializable;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;
import mx.nexsol.dto.catalogos.CatComplejidadDTO;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Data
public class FuncionalidadDTO implements Serializable {
	
	/**
	 * Propiedad para mantener el estado del objeto
	 */
	private static final long serialVersionUID = 5438469381234739028L;

	private long id;
	
	private String nombreFuncionalidad;
	
	private String identificador;
	
	private CatComplejidadDTO complejidad;

	private ProyectoDTO proyectoDTO;

	private int statusVista;

	private int estatusRegistro;

}
