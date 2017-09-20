package com.teach.dao;

import com.teach.model.SteeringRatesModel;

import java.util.List;
import java.util.Map;

public interface SteeringRatesModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SteeringRatesModel record);

    int insertSelective(SteeringRatesModel record);

    SteeringRatesModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SteeringRatesModel record);

    int updateByPrimaryKey(SteeringRatesModel record);

    List<SteeringRatesModel> selectList(Map<String, Object> map);
}