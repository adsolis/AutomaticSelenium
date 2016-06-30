package mx.nexsol.dao.catalogos.impl;

import org.springframework.stereotype.Repository;

import mx.nexsol.dao.catalogos.CatComplejidadDAO;
import mx.nexsol.dao.comun.GenericDAO;
import mx.nexsol.dao.comun.impl.GenericDAOImpl;
import mx.nexsol.entity.catalogos.CatComplejidad;

import java.io.Serializable;

@Repository
public class CatComplejidadDAOImpl extends GenericDAOImpl<CatComplejidad> implements CatComplejidadDAO, Serializable {

}
