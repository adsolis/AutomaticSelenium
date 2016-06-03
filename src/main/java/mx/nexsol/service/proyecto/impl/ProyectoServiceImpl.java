package mx.nexsol.service.proyecto.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.nexsol.dao.proyecto.ProyectoDAO;
import mx.nexsol.dto.proyecto.ProyectoDTO;
import mx.nexsol.entity.proyectos.Proyecto;
import mx.nexsol.service.proyecto.ProyectoService;

@Service
public class ProyectoServiceImpl implements ProyectoService {
	
	@Autowired
	private ProyectoDAO proyectoDAO;

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
					proyectos.add(mapearProyectoENtityADto(proyecto));
				}
				proyectosEntity = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return proyectos;
	}

	@Override
	public ProyectoDTO guardarProyecto(ProyectoDTO proyectoDTO) {
		Proyecto proyecto = null;
		try {
			proyecto = mapearDTOaEntity(proyectoDTO);
			proyecto = proyectoDAO.guardarRegistro(proyecto);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return proyectoDTO;
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
	
	private ProyectoDTO mapearProyectoENtityADto(Proyecto proyecto) {
		ProyectoDTO proyectoDTO = new ProyectoDTO();
		
		proyectoDTO.setId(proyecto.getId());
		proyectoDTO.setNombre(proyecto.getNombre());
		
		return proyectoDTO;
	}
	
	private Proyecto mapearDTOaEntity(ProyectoDTO proyectoDTO) {
		Proyecto proyecto = new Proyecto();
		proyecto.setNombre(proyecto.getNombre());
		proyecto.setDetalle(proyecto.getDetalle());
		proyecto.setFechaCreacion(proyectoDTO.getFechaCreacion());
		return proyecto;
	}

	public ProyectoDAO getProyectoDAO() {
		return proyectoDAO;
	}

	public void setProyectoDAO(ProyectoDAO proyectoDAO) {
		this.proyectoDAO = proyectoDAO;
	}
	
	

}
