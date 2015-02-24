package DAO.interfaces;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sevasan on 2/22/2015.
 */
public interface GenericDAO<T extends Serializable> {

    T create(T entity);

    List<T> findAll();

    T delete(T entity);

    T update(T entity);

    T findById(int id);

}
