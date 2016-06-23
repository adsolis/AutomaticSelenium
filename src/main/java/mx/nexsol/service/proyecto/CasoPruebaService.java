package mx.nexsol.service.proyecto;

import mx.nexsol.dto.proyecto.CasoPruebaDTO;
import mx.nexsol.entity.proyectos.CasoPrueba;

import java.util.List;

/**
 * Created by ironhide on 22/06/16.
 */
public interface CasoPruebaService {

    List<CasoPruebaDTO> recuperarCasosPrueba();

    List<CasoPrueba> guardarCasoPrueba(List<CasoPruebaDTO> casosPruebaDTO) throws Exception;

}
