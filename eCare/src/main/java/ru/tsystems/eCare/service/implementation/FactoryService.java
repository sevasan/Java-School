package ru.tsystems.eCare.service.implementation;

import ru.tsystems.eCare.DAO.implementation.DAOFactory;

import javax.persistence.EntityManager;

/**
 * Service to access DAOFactory's methods
 * Created by sevasan on 3/2/2015.
 */
public class FactoryService {
    public static void createFactory() {
        DAOFactory.createFactory();
    }

    public static void close() {
        DAOFactory.close();
    }

    public static EntityManager createEntityManager() {
        return DAOFactory.createManager();
    }
}
