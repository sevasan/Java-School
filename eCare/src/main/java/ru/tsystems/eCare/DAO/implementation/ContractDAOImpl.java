package ru.tsystems.eCare.DAO.implementation;

import ru.tsystems.eCare.DAO.interfaces.ContractDAO;
import ru.tsystems.eCare.entity.Contract;
import ru.tsystems.eCare.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by sevasan on 2/23/2015.
 */
public class ContractDAOImpl implements ContractDAO {
    private static EntityManager manager;

    public ContractDAOImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Contract create(Contract entity) {
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
    public List<Contract> findAll() {
        Query query = manager.createNamedQuery("Contract.findAll");
        return query.getResultList();
    }

    @Override
    public Contract delete(Contract entity) {
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
    public Contract update(Contract entity) {
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
    public Contract findById(long id) {
        return manager.find(Contract.class, id);
    }

    @Override
    public Contract findByNumber(String number) {
        List<Contract> result = manager.createQuery("select c from Contract where c.phonenumber = :number")
                .setParameter("number", number).getResultList();
        if (result.size() != 0) {
            return result.get(0);
        }

        return null;
    }

    @Override
    public User findUserByNumber(String number) {
        Contract result = findByNumber(number);
        if (result != null) {
            return result.getClient();
        }

        return null;
    }
}
