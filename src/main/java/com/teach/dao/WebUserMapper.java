package com.teach.dao;

import com.teach.model.WebUser;

public interface WebUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WebUser record);

    int insertSelective(WebUser record);

    WebUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WebUser record);

    int updateByPrimaryKey(WebUser record);

    WebUser selectByUserName(String userName);
}