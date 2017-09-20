package com.teach.service;

import com.teach.model.WebUser;

/**
 * Created by wang on 2017-07-03.
 */
public interface WebUserService {
    WebUser selectById(Long id);

    WebUser selectByUserName(String userName);
}
