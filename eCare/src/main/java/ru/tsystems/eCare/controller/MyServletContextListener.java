package ru.tsystems.eCare.controller;

import ru.tsystems.eCare.service.implementation.FactoryService;

import javax.persistence.EntityManager;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by sevasan on 3/2/2015.
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        FactoryService.createFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        FactoryService.close();
    }
}
