package DAO.implementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by sevasan on 2/22/2015.
 */
public class DAOFactory {
    public static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("eCareDB");
    public static final EntityManager manager = factory.createEntityManager();
}
