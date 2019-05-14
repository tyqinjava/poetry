package org.curd.dao;

import org.curd.model.Poems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoemsDao extends JpaRepository<Poems,Integer> ,RandomPageable<Poems>{

}
