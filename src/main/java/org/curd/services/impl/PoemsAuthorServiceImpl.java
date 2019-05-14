package org.curd.services.impl;


import org.curd.dao.PoemsAuthorDao;
import org.curd.dto.PoemsAuthorDto;
import org.curd.services.PoemsAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public class PoemsAuthorServiceImpl extends AbstractService<PoemsAuthorDto,Integer> implements PoemsAuthorService {


    @Autowired
    private PoemsAuthorDao poemsAuthorDao;

    @Override
    public CrudRepository getCurdRepository() {
        return poemsAuthorDao;
    }
}
