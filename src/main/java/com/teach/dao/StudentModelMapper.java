package com.teach.dao;

import com.teach.model.StudentModel;

public interface StudentModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StudentModel record);

    int insertSelective(StudentModel record);

    StudentModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StudentModel record);

    int updateByPrimaryKey(StudentModel record);
}