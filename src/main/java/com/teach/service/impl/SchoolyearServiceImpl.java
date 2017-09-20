package com.teach.service.impl;

import com.teach.dao.SchoolyearModelMapper;
import com.teach.model.SchoolyearModel;
import com.teach.service.SchoolyearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by LiuQi on 2017/9/11.
 */
@Service
public class SchoolyearServiceImpl implements SchoolyearService {

    @Autowired
    private SchoolyearModelMapper schoolyearDao;

    public List<SchoolyearModel> selectList(Map map) {
        return schoolyearDao.selectList(map);
    }
}
