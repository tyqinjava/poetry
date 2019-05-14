package org.curd.services.impl;

import org.curd.dao.PoemsDao;
import org.curd.dto.PoemsDto;
import org.curd.services.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public class PoemServiceImpl extends AbstractService<PoemsDto,Integer> implements PoemService {


    @Autowired
    private PoemsDao poemsDao;

    @Override
    public CrudRepository getCurdRepository() {
        return poemsDao;
    }
}
