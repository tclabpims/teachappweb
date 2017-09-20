package com.teach.dao;

import com.teach.model.ClassModel;

public interface ClassModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClassModel record);

    int insertSelective(ClassModel record);

    ClassModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClassModel record);

    int updateByPrimaryKey(ClassModel record);
}