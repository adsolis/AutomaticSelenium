package mx.nexsol.dao.showcase.impl;

import org.springframework.stereotype.Repository;

import mx.nexsol.dao.comun.impl.GenericDAOImpl;
import mx.nexsol.dao.showcase.PersonaDAO;
import mx.nexsol.entity.showcase.Persona;

@Repository
public class PersonaDAOImpl extends GenericDAOImpl<Persona> implements PersonaDAO{

}
