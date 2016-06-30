package mx.nexsol.dao.proyecto.impl;

import org.springframework.stereotype.Repository;
import mx.nexsol.dao.comun.impl.GenericDAOImpl;
import mx.nexsol.dao.proyecto.FuncionalidadDAO;
import mx.nexsol.entity.proyectos.Funcionalidad;

import java.io.Serializable;

@Repository
public class FuncionalidadDAOImpl extends GenericDAOImpl<Funcionalidad> implements FuncionalidadDAO, Serializable {

}
