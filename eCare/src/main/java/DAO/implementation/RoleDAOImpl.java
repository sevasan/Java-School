package DAO.implementation;

import DAO.interfaces.RoleDAO;
import ru.tsystems.eCare.entity.Role;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by sevasan on 2/23/2015.
 */
public class RoleDAOImpl implements RoleDAO {
    private static EntityManager manager = DAOFactory.manager;

    @Override
    public Role create(Role entity) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(entity);
            transaction.commit();
        } finally {
            if (transaction.isActive())
                transaction.rollback();
        }
        return entity;
    }

    @Override
    public List<Role> findAll() {
        Query query = manager.createNamedQuery("Role.findAll");
        List<Role> result = query.getResultList();
        return result;
    }

    @Override
    public Role delete(Role entity) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.remove(entity);
            transaction.commit();
        } finally {
            if (transaction.isActive())
                transaction.rollback();
        }
        return entity;
    }

    @Override
    public Role update(Role entity) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.merge(entity);
            transaction.commit();
        } finally {
            if (transaction.isActive())
                transaction.rollback();
        }
        return entity;
    }

    @Override
    public Role findById(int id) {
        Role result = manager.find(Role.class, id);
        return result;
    }
}
