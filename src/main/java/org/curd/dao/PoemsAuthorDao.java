package org.curd.dao;


import org.curd.model.PoemsAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoemsAuthorDao extends JpaRepository<PoemsAuthor,Integer>,RandomPageable<PoemsAuthor> {

}
