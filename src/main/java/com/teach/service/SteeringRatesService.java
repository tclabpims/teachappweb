package com.teach.service;

import com.teach.model.SteeringRatesModel;

import java.util.List;
import java.util.Map;

/**
 * Created by LiuQi on 2017/9/11.
 */
public interface SteeringRatesService {
    List<SteeringRatesModel> selectList(Map<String, Object> map);
}
