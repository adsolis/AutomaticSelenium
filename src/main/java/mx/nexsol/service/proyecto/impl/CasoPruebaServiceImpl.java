package mx.nexsol.service.proyecto.impl;

import lombok.Data;
import mx.nexsol.dao.proyecto.CasoPruebaDAO;
import mx.nexsol.dto.proyecto.CasoPruebaDTO;
import mx.nexsol.entity.proyectos.CasoPrueba;
import mx.nexsol.service.proyecto.CasoPruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ironhide on 23/06/16.
 */

@Service
@Data
public class CasoPruebaServiceImpl implements CasoPruebaService, Serializable {

    @Autowired
    private CasoPruebaDAO casoPruebaDAO;

    public List<CasoPruebaDTO> recuperarCasosPrueba() {
        return null;
    }

    public List<CasoPrueba> guardarCasoPrueba(List<CasoPruebaDTO> casosPruebaDTO) throws Exception {
        List<CasoPrueba> casosPrueba = new ArrayList<CasoPrueba>();
        for(CasoPruebaDTO casoPruebaDTO: casosPruebaDTO) {
            casosPrueba.add(mapearDtoAEntity(casoPruebaDTO));
        }
        casosPruebaDTO.clear();

        for(CasoPrueba casoPrueba: casosPrueba) {
            casoPrueba = casoPruebaDAO.guardarRegistro(casoPrueba);
        }
        return casosPrueba;
    }

    private CasoPrueba mapearDtoAEntity(CasoPruebaDTO casoPruebaDTO) {
        CasoPrueba casoPrueba = new CasoPrueba();

        casoPrueba.setNombre(casoPruebaDTO.getNombreCasoPrueba());
        casoPrueba.setIdCasoPrueba(casoPruebaDTO.getIdentificador());

        return casoPrueba;
    }

    public CasoPruebaDTO mapearEntityADto(CasoPrueba casoPrueba) {
        CasoPruebaDTO casoPruebaDTO = new CasoPruebaDTO();

        casoPruebaDTO.setId(casoPrueba.getId());
        casoPruebaDTO.setNombreCasoPrueba(casoPrueba.getNombre());
        casoPruebaDTO.setIdentificador(casoPrueba.getIdCasoPrueba());
        casoPrueba = null;

        return casoPruebaDTO;
    }

}
