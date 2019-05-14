package org.curd.services.impl;

import org.curd.dao.ShiJingDao;
import org.curd.dto.ShiJingDto;
import org.curd.services.ShiJingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ShiJingServiceImpl extends AbstractService<ShiJingDto,Integer> implements ShiJingService {

    @Autowired
    private ShiJingDao shiJingDao;

    @Override
    public CrudRepository getCurdRepository() {
        return shiJingDao;
    }

}
