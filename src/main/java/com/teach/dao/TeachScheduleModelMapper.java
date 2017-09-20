package com.teach.dao;

import com.teach.model.TeachScheduleModel;

public interface TeachScheduleModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TeachScheduleModel record);

    int insertSelective(TeachScheduleModel record);

    TeachScheduleModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TeachScheduleModel record);

    int updateByPrimaryKey(TeachScheduleModel record);
}