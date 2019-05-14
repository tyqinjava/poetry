package org.curd.services.impl;

import org.curd.dao.LunYuDao;
import org.curd.dto.LunYuDto;
import org.curd.services.LunYuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class LunYuServiceImpl extends AbstractService<LunYuDto,Integer> implements LunYuService {


    @Autowired
    private LunYuDao dao;

    @Override
    public CrudRepository getCurdRepository() {
        return this.dao;
    }

}
