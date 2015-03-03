package ru.tsystems.eCare;

import org.apache.log4j.Logger;
import ru.tsystems.eCare.DAO.implementation.DAOFactory;
import ru.tsystems.eCare.DAO.implementation.RoleDAOImpl;
import ru.tsystems.eCare.DAO.implementation.UserDAOImpl;
import ru.tsystems.eCare.DAO.interfaces.RoleDAO;
import ru.tsystems.eCare.DAO.interfaces.UserDAO;
import ru.tsystems.eCare.entity.Role;
import ru.tsystems.eCare.entity.User;
import ru.tsystems.eCare.service.implementation.UserServiceImpl;
import ru.tsystems.eCare.service.interfaces.UserService;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sevasan on 2/16/2015.
 */
public class App {
    final static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {
        DAOFactory factory = new DAOFactory();

//        RoleDAO roleDAO = new RoleDAOImpl();
//        Role role = roleDAO.findByName("Client").get(0);
//
//        User user = new User();
//        user.setUserName("Вася");
//        user.setUserLastName("Пупкин");
//        user.setRole(role);
//        user.setUserIDCard("ID333");
//        user.setUserEmail("Vasya@gmail.com");
//        user.setUserAddress("Nowhere");
//        user.setUserBirthday(new Date());
//        user.setUserPassword("secret");
//
//        UserDAO userDAO = new UserDAOImpl();
//        userDAO.createFactory(user);

        UserService userService = new UserServiceImpl();
        List<String> userList = userService.getAllUsersShort();

        for (String s: userList) {
            logger.info(s);
        }
        factory.close();
    }
}
