package ru.tsystems.eCare.DAO.implementation;

import ru.tsystems.eCare.DAO.interfaces.UserDAO;
import ru.tsystems.eCare.entity.User;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by sevasan on 2/22/2015.
 */
public class UserDAOImpl implements UserDAO {
    private static EntityManager manager = DAOFactory.manager;

    @Override
    public User create(User entity) {
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
    public List<User> findAll() {
        Query query = manager.createNamedQuery("User.findAll");
        return query.getResultList();
    }

    @Override
    public User delete(User entity) {
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
    public User update(User entity) {
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
    public User findById(int id) {
        return manager.find(User.class, id);
    }

    @Override
    public List<User> findByName(String name) {
        return manager.createQuery("select r from User r where r.userName = :name").setParameter("name", name)
                .getResultList();
    }

    @Override
    public List<User> findByNameAndLastName(String name, String lastname) {
        return manager.createQuery("select r from User r where r.userName = :name and r.userLastName = :lastname")
                .setParameter("name", name).setParameter("lastname", lastname).getResultList();
    }
}
