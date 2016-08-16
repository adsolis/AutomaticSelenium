package mx.nexsol.dao.proyecto.impl;

import mx.nexsol.entity.comun.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.nexsol.dao.comun.impl.GenericDAOImpl;
import mx.nexsol.dao.proyecto.ProyectoDAO;
import mx.nexsol.entity.proyectos.Proyecto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProyectoDAOImpl extends GenericDAOImpl<Proyecto> implements ProyectoDAO, Serializable {

	
	public List<Proyecto> recuperarProyectosUsuario(Usuario usuario) {
        Session session = getSession();
        Criteria criteria = null;
        Map<String, Usuario> filtro = new HashMap<String, Usuario>();
        List<Proyecto> listaProyectos = null;
        try {
            session.getTransaction().begin();
            criteria= session.createCriteria(Proyecto.class);
            criteria.addOrder(Order.asc("id"));
            filtro.put("USUARIO", usuario);
            criteria.add(Restrictions.allEq(filtro));
            listaProyectos = criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return listaProyectos;
    }
	
	
}
