package com.teach.dao;

import com.teach.model.CourseModel;

public interface CourseModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CourseModel record);

    int insertSelective(CourseModel record);

    CourseModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CourseModel record);

    int updateByPrimaryKey(CourseModel record);
}