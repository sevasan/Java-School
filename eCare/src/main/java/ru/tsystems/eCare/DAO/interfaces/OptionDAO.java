package ru.tsystems.eCare.DAO.interfaces;

import ru.tsystems.eCare.entity.Option;

/**
 * Created by sevasan on 2/22/2015.
 */
public interface OptionDAO extends GenericDAO<Option> {
    public Option findByTitle(String title);
}
