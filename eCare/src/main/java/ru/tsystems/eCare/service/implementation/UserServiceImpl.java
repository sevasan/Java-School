package ru.tsystems.eCare.service.implementation;

import ru.tsystems.eCare.DAO.implementation.DAOFactory;
import ru.tsystems.eCare.DAO.implementation.UserDAOImpl;
import ru.tsystems.eCare.DAO.interfaces.UserDAO;
import ru.tsystems.eCare.entity.User;
import ru.tsystems.eCare.service.interfaces.UserService;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sevasan on 3/1/2015.
 */
public class UserServiceImpl implements UserService {
    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public User findUserByPhoneNumber(String phoneNumber) {
        return null;
    }

    @Override
    public List<String> getAllUsersShort() {
        DAOFactory factory = new DAOFactory();
        UserDAO userDAO = new UserDAOImpl();
        List<User> userList = userDAO.findAll();

        List<String> result = new LinkedList<String>();
        for (User u: userList) {
            result.add(u.getUserName() + " " + u.getUserLastName());
        }
        factory.close();
        return result;
    }
}
