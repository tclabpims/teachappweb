package com.teach.service.impl;

import com.teach.dao.WebUserMapper;
import com.teach.model.WebUser;
import com.teach.service.WebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WebUserServiceImpl implements WebUserService {

	@Autowired
	private WebUserMapper userDao;

	public WebUser selectById(Long id) {
		return userDao.selectByPrimaryKey(id);
	}

	public WebUser selectByUserName(String userName) {
		return userDao.selectByUserName(userName);
	}
}
