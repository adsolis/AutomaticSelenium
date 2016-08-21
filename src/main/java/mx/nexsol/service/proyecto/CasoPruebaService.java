package mx.nexsol.service.proyecto;

import mx.nexsol.dto.proyecto.CasoPruebaDTO;
import mx.nexsol.entity.proyectos.CasoPrueba;
import mx.nexsol.entity.proyectos.Funcionalidad;

import java.util.List;
import java.util.Set;

/**
 * Created by ironhide on 22/06/16.
 */
public interface CasoPruebaService {

    List<CasoPruebaDTO> recuperarCasosPrueba();

    Set<CasoPrueba> guardarCasoPrueba(List<CasoPruebaDTO> casosPruebaDTO, Funcionalidad funcionalidad) throws Exception;

}
