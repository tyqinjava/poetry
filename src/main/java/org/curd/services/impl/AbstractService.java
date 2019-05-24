package org.curd.services.impl;

import org.curd.converts.Converter;
import org.curd.converts.DtoConverter;
import org.curd.dao.RandomPageable;
import org.curd.services.BaseService;
import org.curd.util.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;


public abstract class AbstractService<T,ID> implements BaseService<T,ID> {

    @Override
    public abstract CrudRepository getCurdRepository();

    protected final Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public void save(Object entity) {
        getCurdRepository().save(entity);
    }

    @Override
    public void save(Iterable entities) {
        getCurdRepository().save(entities);
    }

    @Override
    public T findOne(Object id) {
        Object t =  getCurdRepository().findOne((Serializable) id);
        Converter dtoConverter = new DtoConverter();
        return (T) dtoConverter.convertTo(t);
    }

    @Override
    public boolean exists(Object o) {
        return getCurdRepository().exists((Serializable) o);
    }

    @Override
    public List<T> findAll() {
        Iterable iterable = getCurdRepository().findAll();
        if(iterable != null) {
            Converter dtoConverter = new DtoConverter();
            return ConvertUtils.iterableConvert(iterable,dtoConverter);
        }
        return null;
    }

    @Override
    public List<T> findAll(Iterable iterable) {
        Iterable r = getCurdRepository().findAll(iterable);
        if(r != null) {
            Converter dtoConverter = new DtoConverter();
            return ConvertUtils.iterableConvert(r,dtoConverter);
        }
        return Collections.emptyList();
    }

    @Override
    public long count() {
        return getCurdRepository().count();
    }

    @Override
    public void delete(Object o) {
        getCurdRepository().delete(o);
    }

    @Override
    public void delete(Iterable iterable) {
        getCurdRepository().delete(iterable);
    }

    @Override
    public List<T> findByPage(Integer page, Integer size) {
        PageRequest pageRequest= new PageRequest(page,size);
        JpaRepository<T,Integer> jpaRepository = (JpaRepository<T, Integer>) getCurdRepository();
        Page<T>  pages = jpaRepository.findAll(pageRequest);
        if(pages != null) {
            Converter dtoConverter = new DtoConverter();
            return ConvertUtils.iterableConvert(pages,dtoConverter);
        }
        return Collections.emptyList();
    }
    public List<T> findRandPage(Integer size) {
        CrudRepository repository =  getCurdRepository();
        if(!(repository instanceof RandomPageable)) {
            throw new RuntimeException(repository.getClass().getName() + " is not a RandomPageable");
        }
        RandomPageable randomPageable = (RandomPageable) repository;
        if(logger.isDebugEnabled()) {
            logger.debug("RandomPageable =" +randomPageable.getClass().getName());
        }
        List<T> results =  randomPageable.findRandPage(size);
        if(results != null) {
            Converter dtoConverter = new DtoConverter();
            return ConvertUtils.iterableConvert(results,dtoConverter);
        }
        return Collections.emptyList();
    }
}
