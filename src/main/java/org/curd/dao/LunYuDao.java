package org.curd.dao;

import org.curd.model.LunYu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LunYuDao extends JpaRepository<LunYu,Integer>,RandomPageable<LunYu>{

}
