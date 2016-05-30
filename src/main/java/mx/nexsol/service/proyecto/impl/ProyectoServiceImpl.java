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
		List<ProyectoDTO> proyectosDTO = null;
		try {
			List<Proyecto> proyectosEntity = proyectoDAO.listarRegistros();
			if(proyectosEntity!=null && !proyectosEntity.isEmpty()) {
				proyectosDTO = new ArrayList<ProyectoDTO>();
				for(Proyecto proyecto: proyectosEntity) {
					proyectosDTO.add(mapearProyectoENtityADto(proyecto));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return proyectosDTO;
	}

	@Override
	public ProyectoDTO guardarProyecto(ProyectoDTO proyecto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProyectoDTO editarProyecto(ProyectoDTO proyecto) {
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

	public ProyectoDAO getProyectoDAO() {
		return proyectoDAO;
	}

	public void setProyectoDAO(ProyectoDAO proyectoDAO) {
		this.proyectoDAO = proyectoDAO;
	}
	
	

}
