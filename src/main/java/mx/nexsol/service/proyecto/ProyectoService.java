package mx.nexsol.service.proyecto;

import java.util.List;

import mx.nexsol.dto.proyecto.ProyectoDTO;

public interface ProyectoService {
	
	List<ProyectoDTO> consultarListaProyectos();
	
	ProyectoDTO guardarProyecto(ProyectoDTO proyecto);
	
	ProyectoDTO editarProyecto(ProyectoDTO proyecto);
	
	int eliminarProyectoDTO(long idProyecto);
	
	ProyectoDTO consultarProyecto(long id);
	

}
