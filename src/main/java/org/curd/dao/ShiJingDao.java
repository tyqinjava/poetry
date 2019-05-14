package org.curd.dao;

import org.curd.model.ShiJing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiJingDao extends JpaRepository<ShiJing,Integer>,RandomPageable<ShiJing> {

}
