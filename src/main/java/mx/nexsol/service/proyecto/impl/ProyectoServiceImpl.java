package mx.nexsol.service.proyecto.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import mx.nexsol.dao.comun.UsuarioDAO;
import mx.nexsol.dao.proyecto.FuncionalidadDAO;
import mx.nexsol.dto.comun.UsuarioDTO;
import mx.nexsol.service.comun.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.nexsol.dao.proyecto.ProyectoDAO;
import mx.nexsol.dto.proyecto.FuncionalidadDTO;
import mx.nexsol.dto.proyecto.ProyectoDTO;
import mx.nexsol.entity.proyectos.Funcionalidad;
import mx.nexsol.entity.proyectos.Proyecto;
import mx.nexsol.service.proyecto.ProyectoService;
import mx.nexsol.util.ConstantesComunes;

@Service("proyectoService")
public class ProyectoServiceImpl implements ProyectoService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProyectoDAO proyectoDAO;

	@Autowired
	FuncionalidadDAO funcionalidadDAO;

	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Autowired
	private FuncionalidadServiceImpl proyectoFuncionalidadServiceImpl;

	

	//TODO revisar viabilidad de manejar mapeo o enviar el objeto entity directamente hasta la vista para no afectar el performance
	@Override
	public List<ProyectoDTO> consultarListaProyectos() {
		List<Proyecto> proyectosEntity = null;
		List<ProyectoDTO> proyectos = null;
		try {
			proyectosEntity = proyectoDAO.listarRegistros();
			
			if(proyectosEntity != null && !proyectosEntity.isEmpty()) {
				proyectos = new ArrayList<ProyectoDTO>();
				for(Proyecto proyecto: proyectosEntity) {
					proyectos.add(mapearProyectoEntityADto(proyecto));
				}
				proyectosEntity = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return proyectos;
	}

	public List<ProyectoDTO> listarProyectosUsuario(UsuarioDTO usuarioDTO) {
		List<Proyecto> proyectosEntity = null;
		List<ProyectoDTO> proyectos = null;
		try {
			proyectosEntity = proyectoDAO.recuperarProyectosUsuario(usuarioDAO.recuperarRegistro(usuarioDTO.getId()));
			if(proyectosEntity != null && !proyectosEntity.isEmpty()) {
				proyectos = new ArrayList<ProyectoDTO>();
				for (Proyecto proyecto: proyectosEntity) {
					proyectos.add(mapearProyectoEntityADto(proyecto));
				}
				proyectosEntity = null;
			}
		} catch (Exception e) {

		}
		return proyectos;
	}

	@Override
	public ProyectoDTO guardarProyecto(ProyectoDTO proyectoDTO) {
		Proyecto proyecto = null;
		try {
			proyecto = mapearDTOaEntity(proyectoDTO);
			proyecto.setEstatus(ConstantesComunes.CODIGO_ESTATUS_PROYECTO_PENDIENTE);
			proyecto.setUsuario(UsuarioServiceImpl.mapearDtoAEntity(proyectoDTO.getUsuarioDTO()));
			proyecto = proyectoDAO.guardarRegistro(proyecto);
			proyectoDTO = mapearProyectoEntityADto(proyecto);
			proyectoDTO.setResultado(ConstantesComunes.CODIGO_EXITO);
		}catch(Exception e) {
			e.printStackTrace();
			proyectoDTO.setResultado(ConstantesComunes.CODIGO_ERROR);
		}
		return proyectoDTO;
	}
	
	@Override
	public ProyectoDTO consultarProyecto(long id) {
		ProyectoDTO proyecto = null;
		try {
			proyecto = mapearProyectoEntityADto(proyectoDAO.recuperarRegistro(id));
		} catch (Exception e) {
			e.printStackTrace();
			proyecto = new ProyectoDTO();
			proyecto.setResultado(ConstantesComunes.CODIGO_ERROR);
		}
		return proyecto;
	}
	

	@Override
	public ProyectoDTO editarProyecto(ProyectoDTO proyectoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int eliminarProyectoDTO(long idProyecto) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public ProyectoDTO agregarFuncionalidades(
			List<FuncionalidadDTO> funcionalidadesDTO, ProyectoDTO proyectoDTO)
			throws Exception {
		List<Funcionalidad> funcionalidades = null;
		Proyecto proyecto = proyectoDAO.recuperarRegistro(proyectoDTO.getId());
		try {
			funcionalidades =
					proyectoFuncionalidadServiceImpl.guardarFuncionalidades(funcionalidadesDTO, proyecto);
			proyecto.setFuncionalidad(funcionalidades);
			proyecto = proyectoDAO.editarRegistro(proyecto);
			proyectoDTO = mapearProyectoEntityADto(proyecto);
			funcionalidadesDTO.clear();
			for(Funcionalidad funcionalidad: funcionalidades) {
				proyectoDTO.getFuncionalidades()
				.add(proyectoFuncionalidadServiceImpl.mapearEntityADto(funcionalidad));
			}
		} catch(Exception e) {
			
		}
		
		return proyectoDTO;
	}

	public ProyectoDTO quitarFuncionalidad(FuncionalidadDTO funcionalidadDTO, ProyectoDTO proyectoDTO) {

		if(funcionalidadDTO.getEstatusRegistro()==4)
			eliminarFuncionalidad(funcionalidadDTO, proyectoDTO);
		else if(funcionalidadDTO.getEstatusRegistro()==3)
			modificarFuncionalidad(funcionalidadDTO);

		return proyectoDTO;
	}

	private void eliminarFuncionalidad(FuncionalidadDTO funcionalidadDTO, ProyectoDTO proyectoDTO) {
		Funcionalidad funcionalidad = null;
		boolean resultado = true;
		try {
			Proyecto proyecto = proyectoDAO.recuperarRegistro(proyectoDTO.getId());
			funcionalidad = funcionalidadDAO.recuperarRegistro(funcionalidadDTO.getId());
			proyecto.getFuncionalidad().remove(funcionalidad);
			proyectoDAO.editarRegistro(proyecto);
			resultado = funcionalidadDAO.borrarRegistro(funcionalidad);
		} catch(Exception e) {

		}
	}

	private void modificarFuncionalidad(FuncionalidadDTO funcionalidadDTO) {
		funcionalidadDTO = proyectoFuncionalidadServiceImpl.editarFuncionalidad(funcionalidadDTO);
	}
	
	public ProyectoDTO mapearProyectoEntityADto(Proyecto proyecto) {
		ProyectoDTO proyectoDTO = new ProyectoDTO();
		
		proyectoDTO.setId(proyecto.getId());
		proyectoDTO.setNombre(proyecto.getNombre());
		proyectoDTO.setFechaCreacion(proyecto.getFechaCreacion());
		
		if(proyecto.getEstatus()==ConstantesComunes.CODIGO_ESTATUS_PROYECTO_PENDIENTE)
			proyectoDTO.setEstatus(ConstantesComunes.ESTATUS_PROYECTO_PENDIENTE);
		else if(proyecto.getEstatus()==ConstantesComunes.CODIGO_ESTATUS_PROYECTO_EN_CURSO)
			proyectoDTO.setEstatus(ConstantesComunes.ESTATUS_PROYECTO_EN_CURSO);
		else if(proyecto.getEstatus()==ConstantesComunes.CODIGO_ESTATUS_PROYECTO_FINALIZADO)
			proyectoDTO.setEstatus(ConstantesComunes.ESTATUS_PROYECTO_FINALIZADO);

		if(proyecto.getFuncionalidad()!=null && !proyecto.getFuncionalidad().isEmpty()) {
			proyectoDTO.setFuncionalidades(new ArrayList<FuncionalidadDTO>());
			for(Funcionalidad funcionalidad: proyecto.getFuncionalidad()) {
				proyectoDTO.getFuncionalidades().add(proyectoFuncionalidadServiceImpl.mapearEntityADto(funcionalidad));
			}
		}
		
		return proyectoDTO;
	}
	
	private Proyecto mapearDTOaEntity(ProyectoDTO proyectoDTO) {
		Proyecto proyecto = new Proyecto();
		proyecto.setId(proyectoDTO.getId());
		proyecto.setNombre(proyectoDTO.getNombre());
		proyecto.setEstrategia(proyectoDTO.getEstrategia());
		proyecto.setFechaCreacion(proyectoDTO.getFechaCreacion());
		return proyecto;
	}

	public FuncionalidadServiceImpl getProyectoFuncionalidadServiceImpl() {
		return proyectoFuncionalidadServiceImpl;
	}

	public void setProyectoFuncionalidadServiceImpl(FuncionalidadServiceImpl proyectoFuncionalidadServiceImpl) {
		this.proyectoFuncionalidadServiceImpl = proyectoFuncionalidadServiceImpl;
	}

	public ProyectoDAO getProyectoDAO() {
		return proyectoDAO;
	}

	public void setProyectoDAO(ProyectoDAO proyectoDAO) {
		this.proyectoDAO = proyectoDAO;
	}

	public FuncionalidadDAO getFuncionalidadDAO() {
		return funcionalidadDAO;
	}

	public void setFuncionalidadDAO(FuncionalidadDAO funcionalidadDAO) {
		this.funcionalidadDAO = funcionalidadDAO;
	}
}
