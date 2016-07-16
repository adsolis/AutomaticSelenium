package mx.nexsol.dto.catalogos;

import java.io.Serializable;

import lombok.Data;

import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@EqualsAndHashCode(callSuper = false, of = {"id"})
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Data
public class CatComplejidadDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4990026639899792666L;
	
	private long id;

	private String descripcionComplejidad;
	
	private int limiteTiempoMiutos;

	private String nombreComplejidad;

}
