package com.teach.controller;

import com.teach.service.XiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LiuQi on 2017/9/11.
 */
@Controller
@RequestMapping("/xi")
public class XiController {

    @Autowired
    private XiService xiService;

    @RequestMapping("/extremelist")
    @ResponseBody
    public Map<String, Object> extremeList() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", xiService.selectList(new HashMap<String, Object>()));
        return map;
    }
}
