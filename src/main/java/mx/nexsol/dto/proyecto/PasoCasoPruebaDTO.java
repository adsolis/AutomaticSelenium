package mx.nexsol.dto.proyecto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Clase que representa cada paso de los casos de prueba
 * @author ironhide
 *
 */

@Data
@Component
public class PasoCasoPruebaDTO implements Serializable {

	/**
	 * Propiedad para mantener el estado del objeto
	 */
	private static final long serialVersionUID = 1821457443366170129L;
	
	private long id;
	
	private int numeroDePaso;
	
	private String descripcionPaso;
	
	private String resultadoEsperado;

}
