package com.teach.service;

import com.teach.model.XiModel;

import java.util.List;
import java.util.Map;

/**
 * Created by LiuQi on 2017/9/11.
 */
public interface XiService {
    List<XiModel> selectList(Map map);
}
