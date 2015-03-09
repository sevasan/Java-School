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
//    private static EntityManager manager = DAOFactory.getEntityManager();
    private static EntityManager manager;

    public UserDAOImpl(EntityManager manager) {
        this.manager = manager;
    }

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
        return manager.createNamedQuery("User.findAll").getResultList();
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
    public User findById(long id) {
        return manager.find(User.class, id);
    }

    @Override
    public User findByEmail(String email) {
        List<User> result = manager.createQuery("select u from User u where u.userEmail = :email").setParameter
                ("email", email).getResultList();
        if (result.size() != 0) {
            return result.get(0);
        }
        return null;
    }
}
