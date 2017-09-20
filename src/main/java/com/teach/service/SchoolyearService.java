package com.teach.service;

import com.teach.model.SchoolyearModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LiuQi on 2017/9/11.
 */
public interface SchoolyearService {

    List<SchoolyearModel> selectList(Map map);
}
