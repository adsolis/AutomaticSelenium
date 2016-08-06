package mx.nexsol.service.proyecto;

import java.util.List;

import mx.nexsol.dto.proyecto.FuncionalidadDTO;
import mx.nexsol.dto.proyecto.ProyectoDTO;
import mx.nexsol.entity.proyectos.Funcionalidad;
import mx.nexsol.entity.proyectos.Proyecto;

public interface FuncionalidadService {
	
	List<FuncionalidadDTO> listarFuncionalidades();
	
	List<Funcionalidad> guardarFuncionalidades(List<FuncionalidadDTO> funcionalidades,
			Proyecto proyecto) throws Exception;

	FuncionalidadDTO guardarFuncionalidad(FuncionalidadDTO funcionalidadDTO, Proyecto proyecto) throws Exception;
	
	FuncionalidadDTO editarFuncionalidad(FuncionalidadDTO funcionalidad) throws Exception;
	
	int eliminarFuncionalidad(Funcionalidad funcionalidad);

	FuncionalidadDTO recuperarFuncionalidad(long id) throws Exception;

}
