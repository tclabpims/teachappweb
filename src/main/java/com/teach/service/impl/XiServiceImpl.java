package com.teach.service.impl;

import com.teach.dao.XiModelMapper;
import com.teach.model.XiModel;
import com.teach.service.XiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by LiuQi on 2017/9/11.
 */
@Service
public class XiServiceImpl implements XiService {

    @Autowired
    private XiModelMapper xiDao;

    public List<XiModel> selectList(Map map) {
        return xiDao.selectList(map);
    }
}
