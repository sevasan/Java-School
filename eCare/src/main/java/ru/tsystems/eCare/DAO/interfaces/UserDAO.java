package ru.tsystems.eCare.DAO.interfaces;

import ru.tsystems.eCare.entity.User;

import java.util.List;

/**
 * Created by sevasan on 2/22/2015.
 */
public interface UserDAO extends GenericDAO<User> {
    public User findByEmail(String email);
}
