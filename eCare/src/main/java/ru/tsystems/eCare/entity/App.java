package ru.tsystems.eCare.entity;

import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by sevasan on 2/16/2015.
 */
public class App {
    final static Logger logger = Logger.getLogger(App.class);

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("eCareDB");
    static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        em.getTransaction().begin();

        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
