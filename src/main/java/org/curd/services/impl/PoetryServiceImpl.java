package org.curd.services.impl;

import org.curd.dao.PoetryDao;
import org.curd.dto.PoetryDto;
import org.curd.services.PoetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PoetryServiceImpl extends AbstractService<PoetryDto,Integer> implements PoetryService {


    @Autowired
    private PoetryDao poetryDao;

    @Override
    public CrudRepository getCurdRepository() {
        return poetryDao;
    }
}
