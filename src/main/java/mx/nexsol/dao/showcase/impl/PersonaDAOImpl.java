package mx.nexsol.dao.showcase.impl;

import org.springframework.stereotype.Repository;

import mx.nexsol.dao.showcase.PersonaDAO;
import mx.nexsol.entity.showcase.Persona;
import mx.nexsol.util.impl.GenericDAOImpl;

@Repository
public class PersonaDAOImpl extends GenericDAOImpl<Persona> implements PersonaDAO{

}
