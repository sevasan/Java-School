package ru.tsystems.eCare.DAO.interfaces;

import ru.tsystems.eCare.entity.Role;

import java.util.List;

/**
 * Created by sevasan on 2/22/2015.
 */
public interface RoleDAO extends GenericDAO<Role> {
    public List<Role> findByName(String name);
}
