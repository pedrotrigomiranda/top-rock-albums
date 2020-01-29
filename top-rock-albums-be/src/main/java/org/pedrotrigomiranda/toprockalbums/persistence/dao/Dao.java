package org.pedrotrigomiranda.toprockalbums.persistence.dao;

import org.pedrotrigomiranda.toprockalbums.persistence.model.Model;

import java.util.List;

public interface Dao<T extends Model> {

    List<T> findAll();

    T findById(Integer id);

}
