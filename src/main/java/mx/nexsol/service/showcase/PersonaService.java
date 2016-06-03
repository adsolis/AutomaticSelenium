package mx.nexsol.service.showcase;

import java.util.List;

import mx.nexsol.entity.showcase.Persona;

public interface PersonaService {
	
	List<Persona> listarPersonas();
	
	Persona guardarPersona();
	
	Persona editarPersona();
	
	Persona recuperarPersona(long id);
	
	void eliminarPersona();

}
