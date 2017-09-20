package com.teach.dao;

import com.teach.model.StudentScheduleModel;

public interface StudentScheduleModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StudentScheduleModel record);

    int insertSelective(StudentScheduleModel record);

    StudentScheduleModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StudentScheduleModel record);

    int updateByPrimaryKey(StudentScheduleModel record);
}