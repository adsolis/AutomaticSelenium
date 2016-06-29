package mx.nexsol.dao.comun.impl;

import mx.nexsol.dao.comun.UsuarioDAO;
import mx.nexsol.entity.catalogos.Empresa;
import mx.nexsol.entity.comun.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ironhide on 28/06/16.
 */

@Repository
public class UsuarioDAOImpl extends GenericDAOImpl<Usuario> implements UsuarioDAO {

    public List<Usuario> recuperarUsuariosPorEmpresa(Empresa empresa) throws Exception {
        List<Usuario> usuarios = null;
        Session session = getSession();
        Criteria criteria = null;
        Map<String, Empresa> restricciones = new HashMap<String, Empresa>();
        try {
            restricciones.put("empresa", empresa);
            criteria = session.createCriteria(getPersistentClass());
            session.getTransaction();
            criteria.add(Restrictions.allEq(restricciones));
            usuarios = criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            session.close();
        }

        return usuarios;
    }
}
