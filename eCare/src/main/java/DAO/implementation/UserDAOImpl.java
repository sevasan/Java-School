package DAO.implementation;

import DAO.interfaces.UserDAO;
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
        List<User> result = query.getResultList();
        return result;
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
        User result = manager.find(User.class, id);
        return result;
    }
}
