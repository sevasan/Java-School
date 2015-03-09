package ru.tsystems.eCare.DAO.implementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Handles creation and closing of EntityManagerFactory. Provides method to create EntityManager.
 * Created by sevasan on 2/22/2015.
 */
public class DAOFactory {
    private static EntityManagerFactory factory;
//    private static EntityManager manager;

    public static void createFactory() {
        factory = Persistence.createEntityManagerFactory("eCareDB");
    }

    public static void close() {
        factory.close();
    }

    public static EntityManager createManager() {
        if (factory == null) {
            throw new IllegalStateException("Context is not initialized yet.");
        }
        return factory.createEntityManager();
//        manager = factory.createEntityManager();
//        return manager;
    }

//    public static EntityManager getEntityManager() {
//        return manager;
//    }
}
