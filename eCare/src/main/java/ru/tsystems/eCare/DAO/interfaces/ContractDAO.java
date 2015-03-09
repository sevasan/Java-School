package ru.tsystems.eCare.DAO.interfaces;

import ru.tsystems.eCare.entity.Contract;
import ru.tsystems.eCare.entity.User;

/**
 * Created by sevasan on 2/22/2015.
 */
public interface ContractDAO extends GenericDAO<Contract> {
    public Contract findByNumber(String number);
    public User findUserByNumber(String number);
}
