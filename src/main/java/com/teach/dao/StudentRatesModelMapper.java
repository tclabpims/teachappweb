package com.teach.dao;

import com.teach.model.StudentRatesModel;

public interface StudentRatesModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StudentRatesModel record);

    int insertSelective(StudentRatesModel record);

    StudentRatesModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StudentRatesModel record);

    int updateByPrimaryKey(StudentRatesModel record);
}