package mx.nexsol.service.proyecto.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.nexsol.dao.catalogos.impl.CatComplejidadDAOImpl;
import mx.nexsol.dto.proyecto.CasoPruebaDTO;
import mx.nexsol.entity.proyectos.CasoPrueba;
import mx.nexsol.service.catalogos.impl.CatComplejidadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.nexsol.dao.proyecto.FuncionalidadDAO;
import mx.nexsol.dto.proyecto.FuncionalidadDTO;
import mx.nexsol.entity.proyectos.Funcionalidad;
import mx.nexsol.entity.proyectos.Proyecto;
import mx.nexsol.service.proyecto.FuncionalidadService;

@Service
public class FuncionalidadServiceImpl implements FuncionalidadService, Serializable {
	
	@Autowired
	FuncionalidadDAO funcionalidadDAO;

	@Autowired
	ProyectoServiceImpl proyectoService;

	@Autowired
	private CasoPruebaServiceImpl casoPruebaService;

	@Autowired
	private CatComplejidadDAOImpl catComplejidadDAO;

	@Override
	public List<FuncionalidadDTO> listarFuncionalidades() {
		// TODO Auto-generated method stub
		return null;
	}

	public FuncionalidadDTO guardarFuncionalidad(FuncionalidadDTO funcionalidadDTO, Proyecto proyecto)
			throws Exception {

		Funcionalidad funcionalidad = mapearDtoAEntity(funcionalidadDTO);
		funcionalidad.setComplejidad(catComplejidadDAO.recuperarRegistro(funcionalidadDTO.getComplejidad().getId()));
		funcionalidadDTO = mapearEntityADto(funcionalidadDAO.guardarRegistro(funcionalidad));

		return funcionalidadDTO;
	}

	@Override
	public List<Funcionalidad> guardarFuncionalidades(List<FuncionalidadDTO> funcionalidadesDTO,
			Proyecto proyecto) throws Exception {
		List<Funcionalidad> funcionalidades = new ArrayList<Funcionalidad>();
		for(FuncionalidadDTO funcionalidadDTO: funcionalidadesDTO) {
			Funcionalidad funcionalidad = mapearDtoAEntity(funcionalidadDTO);
			funcionalidad.setComplejidad(catComplejidadDAO.recuperarRegistro(funcionalidadDTO.getComplejidad().getId()));
			funcionalidades.add(funcionalidad);
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
	//@Transactional(propagation = Propagation.REQUIRED)
	public FuncionalidadDTO recuperarFuncionalidad(long id) throws Exception {
		FuncionalidadDTO funcionalidadDTO = null;
		Funcionalidad funcionalidad = funcionalidadDAO.recuperarRegistro(id);
		funcionalidadDTO = mapearEntityADto(funcionalidad);
		funcionalidadDTO.setComplejidad(CatComplejidadServiceImpl.mapearEntityADto(funcionalidad.getComplejidad()));
		if(funcionalidad.getCasosPrueba()!=null && !funcionalidad.getCasosPrueba().isEmpty()) {
			funcionalidadDTO.setCasosPrueba(new ArrayList<CasoPruebaDTO>());
			for(CasoPrueba casoPrueba: funcionalidad.getCasosPrueba()) {
				funcionalidadDTO.getCasosPrueba().add(CasoPruebaServiceImpl.mapearEntityADto(casoPrueba));
			}
		}
		return funcionalidadDTO;
	}

	public FuncionalidadDTO guardarCasosPrueba(List<CasoPruebaDTO> casosPruebaDTO, FuncionalidadDTO funcionalidadDTO) {
		Set<CasoPrueba> casosPrueba = null;
		try {
			Funcionalidad funcionalidad = funcionalidadDAO.recuperarRegistro(funcionalidadDTO.getId());
			casosPrueba = casoPruebaService.guardarCasoPrueba(casosPruebaDTO);
			funcionalidad.setCasosPrueba(casosPrueba);
			funcionalidad = funcionalidadDAO.editarRegistro(funcionalidad);
			funcionalidadDTO = mapearEntityADto(funcionalidad);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return funcionalidadDTO;
	}

	@Override
	public FuncionalidadDTO editarFuncionalidad(FuncionalidadDTO funcionalidad) {
		FuncionalidadDTO funcionalidadDTO = null;

		return funcionalidadDTO;
	}

	@Override
	public int eliminarFuncionalidad(Funcionalidad funcionalidad) {
		try {
			boolean resultado = funcionalidadDAO.borrarRegistro(funcionalidad);
		} catch (Exception e) {

		}
		return 0;
	}


	private Funcionalidad mapearDtoAEntity(FuncionalidadDTO funcionalidadDTO) {
		Funcionalidad funcionalidad = new Funcionalidad();	
		funcionalidad.setNombre(funcionalidadDTO.getNombreFuncionalidad());
		funcionalidad.setIdentificador(funcionalidadDTO.getIdentificador());
		funcionalidad.setEstatus(funcionalidadDTO.getEstatusRegistro());
		return funcionalidad;
	}
	
	public FuncionalidadDTO mapearEntityADto(Funcionalidad funcionalidad) {
		FuncionalidadDTO funcionalidadDTO = new FuncionalidadDTO();

		funcionalidadDTO.setId(funcionalidad.getId());
		funcionalidadDTO.setNombreFuncionalidad(funcionalidad.getNombre());
		funcionalidadDTO.setIdentificador(funcionalidad.getIdentificador());
		/*if(funcionalidad.getCasosPrueba()!=null && !funcionalidad.getCasosPrueba().isEmpty()) {
			funcionalidadDTO.setCasosPrueba(new ArrayList<CasoPruebaDTO>());
			for (CasoPrueba casoPrueba: funcionalidad.getCasosPrueba()) {
				funcionalidadDTO.getCasosPrueba().add(CasoPruebaServiceImpl.mapearEntityADto(casoPrueba));
			}
		}*/
		//funcionalidadDTO.setProyectoDTO(proyectoService.mapearProyectoEntityADto(funcionalidad.getProyecto()));

		funcionalidad = null;
		
		return funcionalidadDTO;
	}

	public FuncionalidadDAO getFuncionalidadDAO() {
		return funcionalidadDAO;
	}

	public void setFuncionalidadDAO(FuncionalidadDAO funcionalidadDAO) {
		this.funcionalidadDAO = funcionalidadDAO;
	}

	public ProyectoServiceImpl getProyectoService() {
		return proyectoService;
	}

	public void setProyectoService(ProyectoServiceImpl proyectoService) {
		this.proyectoService = proyectoService;
	}

	public CasoPruebaServiceImpl getCasoPruebaService() {
		return casoPruebaService;
	}

	public void setCasoPruebaService(CasoPruebaServiceImpl casoPruebaService) {
		this.casoPruebaService = casoPruebaService;
	}

	public CatComplejidadDAOImpl getCatComplejidadDAO() {
		return catComplejidadDAO;
	}

	public void setCatComplejidadDAO(CatComplejidadDAOImpl catComplejidadDAO) {
		this.catComplejidadDAO = catComplejidadDAO;
	}
}
