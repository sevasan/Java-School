package ru.tsystems.eCare.DAO.implementation;

import ru.tsystems.eCare.DAO.interfaces.PlanDAO;
import ru.tsystems.eCare.entity.Plan;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by sevasan on 2/23/2015.
 */
public class PlanDAOImpl implements PlanDAO {
    private static EntityManager manager = DAOFactory.getEntityManager();

    @Override
    public Plan create(Plan entity) {
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
    public List<Plan> findAll() {
        Query query = manager.createNamedQuery("Plan.findAll");
        return query.getResultList();
    }

    @Override
    public Plan delete(Plan entity) {
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
    public Plan update(Plan entity) {
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
    public Plan findById(int id) {
        return manager.find(Plan.class, id);
    }
}
