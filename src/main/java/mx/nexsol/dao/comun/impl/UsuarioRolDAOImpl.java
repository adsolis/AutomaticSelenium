package mx.nexsol.dao.comun.impl;

import mx.nexsol.dao.comun.UsuarioRolDAO;
import mx.nexsol.entity.comun.UsuarioRol;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ironhide on 01/07/16.
 */

@Repository
public class UsuarioRolDAOImpl extends GenericDAOImpl<UsuarioRol> implements UsuarioRolDAO, Serializable {

    public UsuarioRol recuperarUsuarioRolPorUsuario(String username) throws Exception {
        UsuarioRol usuarioRol = null;
        Session session = getSession();
        Criteria criteria = null;
        Map<String, String> restricciones = new HashMap<String, String>();

        try {
            restricciones.put("usuario",username);
            criteria = session.createCriteria(getPersistentClass());
            session.getTransaction();
            criteria.add(Restrictions.allEq(restricciones));
            usuarioRol = (UsuarioRol)criteria.list().get(0);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            session.close();
        }

        return usuarioRol;
    }


}
