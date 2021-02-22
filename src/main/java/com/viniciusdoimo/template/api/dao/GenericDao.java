package com.viniciusdoimo.template.api.dao;

import java.util.List;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
interface GenericDao<T, ID> {

    List<T> findAll();

    T findById(ID id) throws Exception;

    List<T> findAllById(Iterable<ID> ids);

    T create(T entity);

    List<T> createAll(Iterable<T> entities);

    void update(T entity);

    List<T> updateAll(Iterable<T> entities);

    void delete(T entity);

    List<T> deleteAll(Iterable<T> entities);

}
