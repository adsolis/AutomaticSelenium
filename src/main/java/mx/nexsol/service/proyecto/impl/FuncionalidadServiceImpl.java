package mx.nexsol.service.proyecto.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.nexsol.dao.proyecto.FuncionalidadDAO;
import mx.nexsol.dto.proyecto.FuncionalidadDTO;
import mx.nexsol.entity.proyectos.Funcionalidad;
import mx.nexsol.entity.proyectos.Proyecto;
import mx.nexsol.service.proyecto.FuncionalidadService;

@Service
public class FuncionalidadServiceImpl implements FuncionalidadService {
	
	@Autowired
	FuncionalidadDAO funcionalidadDAO;

	@Override
	public List<FuncionalidadDTO> listarFuncionalidades() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionalidad> guardarFuncionalidades(List<FuncionalidadDTO> funcionalidadesDTO,
			Proyecto proyecto) throws Exception {
		List<Funcionalidad> funcionalidades = new ArrayList<Funcionalidad>();
		for(FuncionalidadDTO funcionalidadDTO: funcionalidadesDTO) {
			funcionalidades.add(mapearDtoAEntity(funcionalidadDTO));
		}
		funcionalidadesDTO.clear();
		for(Funcionalidad funcionalidad: funcionalidades) {
			try {
				funcionalidad.setProyecto(proyecto);
				funcionalidad = funcionalidadDAO.guardarRegistro(funcionalidad);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
		return funcionalidades;
	}

	@Override
	public FuncionalidadDTO recuperarFuncionalidad(long id) throws Exception {
		FuncionalidadDTO funcionalidadDTO = null;

		funcionalidadDTO = mapearEntityADto(funcionalidadDAO.recuperarRegistro(id));

		return funcionalidadDTO;
	}

	@Override
	public FuncionalidadDTO editarFuncionalidad(FuncionalidadDTO funcionalidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int eliminarFuncionalidad(long idFuncionalidad) {
		// TODO Auto-generated method stub
		return 0;
	}

	private Funcionalidad mapearDtoAEntity(FuncionalidadDTO funcionalidadDTO) {
		Funcionalidad funcionalidad = new Funcionalidad();	
		funcionalidad.setNombre(funcionalidadDTO.getNombreFuncionalidad());
		funcionalidad.setIdentificador(funcionalidadDTO.getIdentificador());
		return funcionalidad;
	}
	
	public FuncionalidadDTO mapearEntityADto(Funcionalidad funcionalidad) {
		FuncionalidadDTO funcionalidadDTO = new FuncionalidadDTO();

		funcionalidadDTO.setId(funcionalidad.getId());
		funcionalidadDTO.setNombreFuncionalidad(funcionalidad.getNombre());
		funcionalidadDTO.setIdentificador(funcionalidad.getIdentificador());
		funcionalidad = null;
		
		return funcionalidadDTO;
	}
	
}
