package org.curd.dao;


import org.curd.model.MetaType;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;


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
        String sql ="select * from " +
                getTableName()+" where " +
                getIdName() +
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


}
