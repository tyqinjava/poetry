package org.curd.services.impl;

import org.curd.dao.PoetryAuthorDao;
import org.curd.dto.PoetryAuthorDto;
import org.curd.services.PoetryAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public class PoetryAuthorServiceImpl extends AbstractService<PoetryAuthorDto,Integer> implements PoetryAuthorService {


    @Autowired
    private PoetryAuthorDao poetryAuthorDao;

    @Override
    public CrudRepository getCurdRepository() {
        return poetryAuthorDao;
    }
}
