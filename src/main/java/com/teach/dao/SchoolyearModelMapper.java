package com.teach.dao;

import com.teach.model.SchoolyearModel;

import java.util.List;
import java.util.Map;

public interface SchoolyearModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SchoolyearModel record);

    int insertSelective(SchoolyearModel record);

    SchoolyearModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SchoolyearModel record);

    int updateByPrimaryKey(SchoolyearModel record);

    List<SchoolyearModel> selectList(Map map);
}