package org.curd.dao;


import org.curd.aspect.TargetDataSource;
import org.curd.datesource.DataSourceType;
import org.curd.model.MetaType;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class BaseRepository<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements RandomPageable<T> {

    private EntityManager entityManager;

    public BaseRepository(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    public BaseRepository(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
    }

    @Override
    public List<T> findRandPage(Integer size) {
        String tableName = (String) getTableName();
        String idName = (String) getIdName();
        String sql ="select * from " +
                tableName+" where " +
                idName +
                ">= (select floor(rand() * (select max(" +
                getIdName() +
                ") from " +
                getTableName() +
                "))) order by id limit 0,:size";
        Query query = entityManager.createNativeQuery(sql,getDomainClass());
        query.setParameter("size",size);
        return query.getResultList();

    }

    private Object getIdName() {
        MetaType metaType = (MetaType) newDomainBean(getDomainClass());
        return metaType.primaryKeyName();
    }

    private Object getTableName() {
        MetaType metaType = (MetaType) newDomainBean(getDomainClass());
        return metaType.tableName();
    }

    private T newDomainBean(Class<T> domainClass){
        try {
           return domainClass.newInstance();
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("new domain bean fail!");
        }
    }


    @Override
    public void setRepositoryMethodMetadata(CrudMethodMetadata crudMethodMetadata) {
        super.setRepositoryMethodMetadata(crudMethodMetadata);
    }

    @Override
    protected CrudMethodMetadata getRepositoryMethodMetadata() {
        return super.getRepositoryMethodMetadata();
    }

    @Override
    protected Class<T> getDomainClass() {
        return super.getDomainClass();
    }

    @Override
    @TargetDataSource(DataSourceType.WRITE)
    public void delete(ID id) {
        super.delete(id);
    }

    @Override
    @TargetDataSource(DataSourceType.WRITE)
    public void delete(T entity) {
        super.delete(entity);
    }

    @Override
    @TargetDataSource(DataSourceType.WRITE)
    public void delete(Iterable<? extends T> entities) {
        super.delete(entities);
    }

    @Override
    @TargetDataSource(DataSourceType.WRITE)
    public void deleteInBatch(Iterable<T> entities) {
        super.deleteInBatch(entities);
    }

    @Override
    @TargetDataSource(DataSourceType.WRITE)
    public void deleteAll() {
        super.deleteAll();
    }

    @Override
    @TargetDataSource(DataSourceType.WRITE)
    public void deleteAllInBatch() {
        super.deleteAllInBatch();
    }

    @Override
    public T findOne(ID id) {
        return super.findOne(id);
    }

    @Override
    protected Map<String, Object> getQueryHints() {
        return super.getQueryHints();
    }

    @Override
    public T getOne(ID id) {
        return super.getOne(id);
    }

    @Override
    public boolean exists(ID id) {
        return super.exists(id);
    }

    @Override
    public List<T> findAll() {
        return super.findAll();
    }

    @Override
    public List<T> findAll(Iterable<ID> ids) {
        return super.findAll(ids);
    }

    @Override
    public List<T> findAll(Sort sort) {
        return super.findAll(sort);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return super.findAll(pageable);
    }

    @Override
    public T findOne(Specification<T> spec) {
        return super.findOne(spec);
    }

    @Override
    public List<T> findAll(Specification<T> spec) {
        return super.findAll(spec);
    }

    @Override
    public Page<T> findAll(Specification<T> spec, Pageable pageable) {
        return super.findAll(spec, pageable);
    }

    @Override
    public List<T> findAll(Specification<T> spec, Sort sort) {
        return super.findAll(spec, sort);
    }

    @Override
    public <S extends T> S findOne(Example<S> example) {
        return super.findOne(example);
    }

    @Override
    public <S extends T> long count(Example<S> example) {
        return super.count(example);
    }

    @Override
    public <S extends T> boolean exists(Example<S> example) {
        return super.exists(example);
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example) {
        return super.findAll(example);
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
        return super.findAll(example, sort);
    }

    @Override
    public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
        return super.findAll(example, pageable);
    }

    @Override
    public long count() {
        return super.count();
    }

    @Override
    public long count(Specification<T> spec) {
        return super.count(spec);
    }

    @Override
    @TargetDataSource(DataSourceType.WRITE)
    public <S extends T> S save(S entity) {
        return super.save(entity);
    }

    @Override
    @TargetDataSource(DataSourceType.WRITE)
    public <S extends T> S saveAndFlush(S entity) {
        return super.saveAndFlush(entity);
    }

    @Override
    @TargetDataSource(DataSourceType.WRITE)
    public <S extends T> List<S> save(Iterable<S> entities) {
        return super.save(entities);
    }

    @Override
    public void flush() {
        super.flush();
    }


}
