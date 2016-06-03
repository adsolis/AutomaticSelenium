package mx.nexsol.service.showcase.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.nexsol.dao.showcase.impl.PersonaDAOImpl;
import mx.nexsol.entity.showcase.Persona;
import mx.nexsol.service.showcase.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4015177210723301630L;
	@Autowired
	private PersonaDAOImpl personaDao;

	@Override
	public List<Persona> listarPersonas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona guardarPersona() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona editarPersona() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona recuperarPersona(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarPersona() {
		// TODO Auto-generated method stub
		
	}

	public PersonaDAOImpl getPersonaDao() {
		return personaDao;
	}

	public void setPersonaDao(PersonaDAOImpl personaDao) {
		this.personaDao = personaDao;
	}

}
