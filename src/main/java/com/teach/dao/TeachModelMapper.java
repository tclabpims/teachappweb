package com.teach.dao;

import com.teach.model.TeachModel;

import java.util.List;
import java.util.Map;

public interface TeachModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TeachModel record);

    int insertSelective(TeachModel record);

    TeachModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TeachModel record);

    int updateByPrimaryKey(TeachModel record);

    List<TeachModel> superivorRateStat(Map map);
}