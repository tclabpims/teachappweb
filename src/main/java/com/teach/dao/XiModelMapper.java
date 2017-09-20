package com.teach.dao;

import com.teach.model.XiModel;

import java.util.List;
import java.util.Map;

public interface XiModelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XiModel record);

    int insertSelective(XiModel record);

    XiModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(XiModel record);

    int updateByPrimaryKey(XiModel record);

    List<XiModel> selectList(Map map);
}