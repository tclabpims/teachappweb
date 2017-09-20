package com.teach.controller;

import com.teach.model.SchoolyearModel;
import com.teach.service.SchoolyearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.Oneway;
import java.util.*;

/**
 * Created by LiuQi on 2017/9/11.
 */
@Controller
@RequestMapping("/schoolyear")
public class SchoolyearController {

    @Autowired
    private SchoolyearService schoolyearService;

    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> selectList() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<SchoolyearModel> schoolyearList = schoolyearService.selectList(new HashMap());
        Set<String> set = new TreeSet<String>();
        List<SchoolyearModel> list = new ArrayList<SchoolyearModel>();
        for (SchoolyearModel schoolyearModel : schoolyearList) {
            set.add(schoolyearModel.getName());
        }
        for (String name : set) {
            SchoolyearModel schoolyearModel = new SchoolyearModel();
            schoolyearModel.setName(name);
            list.add(schoolyearModel);
        }
        map.put("list", list);
        return map;
    }
}
