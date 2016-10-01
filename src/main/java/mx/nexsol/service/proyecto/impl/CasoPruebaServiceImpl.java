package mx.nexsol.service.proyecto.impl;

import lombok.Data;
import mx.nexsol.dao.proyecto.CasoPruebaDAO;
import mx.nexsol.dto.proyecto.CasoPruebaDTO;
import mx.nexsol.entity.proyectos.CasoPrueba;
import mx.nexsol.entity.proyectos.Funcionalidad;
import mx.nexsol.service.proyecto.CasoPruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ironhide on 23/06/16.
 */

@Service
public class CasoPruebaServiceImpl implements CasoPruebaService, Serializable {

    @Autowired
    private CasoPruebaDAO casoPruebaDAO;

    public List<CasoPruebaDTO> recuperarCasosPrueba() {
        return null;
    }

    public Set<CasoPrueba> guardarCasoPrueba(List<CasoPruebaDTO> casosPruebaDTO, Funcionalidad funcionalidad) throws Exception {
        Set<CasoPrueba> casosPrueba = new HashSet<CasoPrueba>();
        for(CasoPruebaDTO casoPruebaDTO: casosPruebaDTO) {
            if(casoPruebaDTO.isCasoPruebaNuevo())
                casosPrueba.add(mapearDtoAEntity(casoPruebaDTO));
        }
        casosPruebaDTO.clear();
        for(CasoPrueba casoPrueba: casosPrueba) {
            casoPrueba.setFuncionalidad(funcionalidad);
            casoPrueba = casoPruebaDAO.guardarRegistro(casoPrueba);
        }
        return casosPrueba;
    }

    private CasoPrueba mapearDtoAEntity(CasoPruebaDTO casoPruebaDTO) {
        CasoPrueba casoPrueba = new CasoPrueba();
        casoPrueba.setNombre(casoPruebaDTO.getNombreCasoPrueba());
        casoPrueba.setIdCasoPrueba(casoPruebaDTO.getIdentificador());
        casoPrueba.setTiempoEstimadoEntrada(casoPruebaDTO.getEstimacionEntrada());
        casoPrueba.setTiempoEstimadoSalida(casoPruebaDTO.getEstimacionSalida());
        return casoPrueba;
    }

    public static CasoPruebaDTO mapearEntityADto(CasoPrueba casoPrueba) {
        CasoPruebaDTO casoPruebaDTO = new CasoPruebaDTO();

        casoPruebaDTO.setId(casoPrueba.getId());
        casoPruebaDTO.setNombreCasoPrueba(casoPrueba.getNombre());
        casoPruebaDTO.setIdentificador(casoPrueba.getIdCasoPrueba());
        casoPrueba = null;

        return casoPruebaDTO;
    }

    public CasoPruebaDAO getCasoPruebaDAO() {
        return casoPruebaDAO;
    }

    public void setCasoPruebaDAO(CasoPruebaDAO casoPruebaDAO) {
        this.casoPruebaDAO = casoPruebaDAO;
    }
}
