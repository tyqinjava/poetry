package org.curd.dao;

import org.curd.model.Poetry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoetryDao extends JpaRepository<Poetry,Integer>,RandomPageable<Poetry> {

}
