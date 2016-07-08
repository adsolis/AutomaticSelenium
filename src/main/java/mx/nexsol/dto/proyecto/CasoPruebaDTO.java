package mx.nexsol.dto.proyecto;

import lombok.Data;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Data
public class CasoPruebaDTO implements Serializable {

	/**
	 * Propiedad para mantener el estado del objeto
	 */
	private static final long serialVersionUID = 5919272587484898506L;
	
	private long id;
	
	private String nombreCasoPrueba;
	
	private List<PasoCasoPruebaDTO> pasosCasoPrueba;

	private List<Map<String, String>> listaCampos;

	private String identificador;

	private String postCondiciones;

	private String preCondiciones;

}
