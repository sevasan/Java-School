package ru.tsystems.eCare.DAO.implementation;

import ru.tsystems.eCare.DAO.interfaces.OptionDAO;
import ru.tsystems.eCare.entity.Option;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by sevasan on 2/23/2015.
 */
public class OptionDAOImpl implements OptionDAO {
    private static EntityManager manager = DAOFactory.manager;

    @Override
    public Option create(Option entity) {
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
    public List<Option> findAll() {
        Query query = manager.createNamedQuery("Option.findAll");
        return query.getResultList();
    }

    @Override
    public Option delete(Option entity) {
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
    public Option update(Option entity) {
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
    public Option findById(int id) {
        return manager.find(Option.class, id);
    }
}
