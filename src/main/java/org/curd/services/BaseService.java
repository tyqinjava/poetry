package org.curd.services;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BaseService<T,ID> {

    CrudRepository getCurdRepository();

    void save(T entity);

    void save(Iterable<T> entities);

    T findOne(ID id);

    boolean exists(ID id);

    List<T> findAll();

    List<T> findAll(Iterable<ID> ids);

    long count();

    void delete(ID id);

    void delete(Iterable<ID> ids);

    List<T> findByPage(Integer page, Integer size);

    List<T> findRandPage(Integer size);

}
