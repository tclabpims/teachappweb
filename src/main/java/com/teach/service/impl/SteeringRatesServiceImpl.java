package com.teach.service.impl;

import com.teach.dao.SteeringRatesModelMapper;
import com.teach.model.SteeringRatesModel;
import com.teach.service.SteeringRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by LiuQi on 2017/9/11.
 */
@Service
public class SteeringRatesServiceImpl implements SteeringRatesService{

    @Autowired
    private SteeringRatesModelMapper steeringRatesDao;

    public List<SteeringRatesModel> selectList(Map<String, Object> map) {
        return steeringRatesDao.selectList(map);
    }
}
