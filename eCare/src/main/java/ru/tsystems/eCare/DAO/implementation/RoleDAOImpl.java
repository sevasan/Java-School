package ru.tsystems.eCare.DAO.implementation;

import ru.tsystems.eCare.DAO.interfaces.RoleDAO;
import ru.tsystems.eCare.entity.Role;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by sevasan on 2/23/2015.
 */
public class RoleDAOImpl implements RoleDAO {
//    private static EntityManager manager = DAOFactory.getEntityManager();
    private static EntityManager manager;

    public RoleDAOImpl(EntityManager manager) {
        this.manager = manager;
    }

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
        return query.getResultList();
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
    public Role findById(long id) {
        return manager.find(Role.class, id);
    }

    @Override
    public List<Role> findByName(String name) {
        return manager.createQuery("select r from Role r where r.roleName = :name").setParameter("name", name).getResultList();
    }
}
