package com.teach.service.impl;

import com.teach.dao.TeachModelMapper;
import com.teach.model.TeachModel;
import com.teach.service.TeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by LiuQi on 2017/9/12.
 */
@Service
public class TeachServiceImpl implements TeachService {

    @Autowired
    private TeachModelMapper teachDao;

    public List<TeachModel> superivorRateStat(Map map) {
        return teachDao.superivorRateStat(map);
    }
}
