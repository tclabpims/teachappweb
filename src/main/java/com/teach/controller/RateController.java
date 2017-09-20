package com.teach.controller;

import com.teach.model.SchoolRateStatModel;
import com.teach.model.SteeringRatesModel;
import com.teach.model.TeachModel;
import com.teach.model.XiModel;
import com.teach.service.SteeringRatesService;
import com.teach.service.TeachService;
import com.teach.service.XiService;
import com.teach.util.Arith;
import com.teach.util.StatUtil;
import com.teach.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

/**
 * Created by LiuQi on 2017/9/10.
 */
@Controller
@RequestMapping("/rateStat")
public class RateController {

    @Autowired
    private SteeringRatesService steeringRatesService;

    @Autowired
    private XiService xiService;

    @Autowired
    private TeachService teachService;

    /**
     * 各系评价分的最值统计
     * @param map
     * @param schoolyear
     * @param semester
     * @return
     */
    @RequestMapping("/extremeStat")
    public String extremeStat(ModelMap map, String schoolyear, String semester) {
        List<XiModel> xiList = xiService.selectList(new HashMap());
        //获取评价的时间范围
        Map map_info = getTimeRange(schoolyear, semester);
        List<SteeringRatesModel> steerRateList = steeringRatesService.selectList(map_info);
        List<XiModel> list = StatUtil.statExtremeValue(steerRateList, xiList);
        map.put("list", list);
        map.put("schoolyear", map_info.get("schoolyear_str"));
        map.put("semester", semester != null ? semester.trim() : null);
        return "rateStat/extremeStat";
    }

    /**
     * 督导评价统计
     * @param map
     * @param schoolyear
     * @param semester
     * @return
     */
    @RequestMapping("/supervisorRateStat")
    public String supervisorStat(ModelMap map, String schoolyear, String semester) {
        Map map_info = getTimeRange(schoolyear, semester);
        List<TeachModel> list = teachService.superivorRateStat(map_info);
        map.put("list", list);
        map.put("schoolyear", map_info.get("schoolyear_str"));
        map.put("semester", semester != null ? semester.trim() : null);
        return "rateStat/supervisorRateStat";
    }

    /**
     * 统计学院的评分情况
     * @param map
     * @param schoolyear
     * @param semester
     * @return
     */
    @RequestMapping("/schoolRateStat")
    public String schoolRateStat(ModelMap map, String schoolyear, String semester) {
        Map map_info = getTimeRange(schoolyear, semester);
        List<SteeringRatesModel> list = steeringRatesService.selectList(map_info);
        SchoolRateStatModel schoolRateStatModel = new SchoolRateStatModel();
        int excellentNumber = 0;
        double excellentPerCent = 0.0;
        int goodNumber = 0;
        double goodPerCent = 0.0;
        int medium = 0;
        double mediumPerCent = 0.0;
        int qualifiedNumber = 0;
        double qualifiedPerCent = 0.0;
        for (SteeringRatesModel steeringRatesModel : list) {
            if (steeringRatesModel.getTotalRates() >= 90) {
                excellentNumber++;
            } else if (steeringRatesModel.getTotalRates() >= 80 && steeringRatesModel.getTotalRates() < 90) {
                goodNumber++;
            } else if (steeringRatesModel.getTotalRates() >= 70 && steeringRatesModel.getTotalRates() < 80) {
                medium++;
            } else if (steeringRatesModel.getTotalRates() >= 60 && steeringRatesModel.getTotalRates() < 70) {
                qualifiedNumber++;
            }
        }
        schoolRateStatModel.setExcellentNumber(excellentNumber);
        schoolRateStatModel.setGoodNumber(goodNumber);
        schoolRateStatModel.setMedium(medium);
        schoolRateStatModel.setQualifiedNumber(qualifiedNumber);
        int totalNumber = excellentNumber + goodNumber + medium + qualifiedNumber;
        if(totalNumber > 0) {
            excellentPerCent = Arith.div(excellentNumber, totalNumber, 4);
            goodPerCent = Arith.div(goodNumber, totalNumber, 4);
            mediumPerCent = Arith.div(medium, totalNumber, 4);
            qualifiedPerCent = Arith.div(qualifiedNumber, totalNumber, 4);
            schoolRateStatModel.setExcellentPerCent(excellentPerCent);
            schoolRateStatModel.setGoodPerCent(goodPerCent);
            schoolRateStatModel.setMediumPerCent(mediumPerCent);
            schoolRateStatModel.setQualifiedPerCent(qualifiedPerCent);
        }
        map.put("schoolRateStatModel", schoolRateStatModel);
        map.put("schoolyear", map_info.get("schoolyear_str"));
        map.put("semester", semester != null ? semester.trim() : null);
        return "rateStat/schoolRateStat";
    }

    /**
     * 各系评分统计
     * @param map
     * @param year
     * @return
     */
    @RequestMapping("/xiRateStat")
    public String xiRateStat(ModelMap map, String year) {
        List<XiModel> xiModels = xiService.selectList(new HashMap());
        if (year == null || year.trim().isEmpty()) {
            Calendar c = Calendar.getInstance();
            year = Integer.toString(c.get(Calendar.YEAR));
        }
        Date start_time = StringUtil.getDate(year.trim() + "-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
        Date end_time = StringUtil.getDate(year.trim() + "-12-31 23:59:59", "yyyy-MM-dd HH:mm:ss");
        Map<String, Object> map_info = new HashMap<String, Object>();
        map_info.put("start_time", start_time);
        map_info.put("end_time", end_time);
        List<SteeringRatesModel> steeringRatesModels = steeringRatesService.selectList(map_info);
        Date time_line = StringUtil.getDate(year.trim() + "-09-01", "yyyy-MM-dd");
        List<XiModel> firstSemesterList = new ArrayList<XiModel>();
        List<XiModel> secondSemesterList = new ArrayList<XiModel>();
        for (XiModel xiModel : xiModels) {
            XiModel xiModel1 = new XiModel();
            int excellentNumber1 = 0;
            int goodNumber1 = 0;
            int medium1 = 0;
            int qualifiedNumber1 = 0;
            XiModel xiModel2 = new XiModel();
            int excellentNumber2 = 0;
            int goodNumber2 = 0;
            int medium2 = 0;
            int qualifiedNumber2 = 0;
            for (SteeringRatesModel steeringRatesModel : steeringRatesModels) {
                if (steeringRatesModel.getTeachingTime() != null && steeringRatesModel.getTeachingTime().getTime() < time_line.getTime()) {
                    if (steeringRatesModel.getClassModel() != null && xiModel.getXiName().equals(steeringRatesModel.getClassModel().getXiName())) {
                        if (steeringRatesModel.getTotalRates() >= 90) {
                            excellentNumber1++;
                        } else if (steeringRatesModel.getTotalRates() >= 80 && steeringRatesModel.getTotalRates() < 90) {
                            goodNumber1++;
                        } else if (steeringRatesModel.getTotalRates() >= 70 && steeringRatesModel.getTotalRates() < 80) {
                            medium1++;
                        } else if (steeringRatesModel.getTotalRates() >= 60 && steeringRatesModel.getTotalRates() < 70) {
                            qualifiedNumber1++;
                        }
                    }
                } else {
                    if (steeringRatesModel.getClassModel() != null && xiModel.getXiName().equals(steeringRatesModel.getClassModel().getXiName())) {
                        if (steeringRatesModel.getTotalRates() >= 90) {
                            excellentNumber2++;
                        } else if (steeringRatesModel.getTotalRates() >= 80 && steeringRatesModel.getTotalRates() < 90) {
                            goodNumber2++;
                        } else if (steeringRatesModel.getTotalRates() >= 70 && steeringRatesModel.getTotalRates() < 80) {
                            medium2++;
                        } else if (steeringRatesModel.getTotalRates() >= 60 && steeringRatesModel.getTotalRates() < 70) {
                            qualifiedNumber2++;
                        }
                    }
                }
            }
            xiModel1.setXiName(xiModel.getXiName());
            xiModel2.setXiName(xiModel.getXiName());
            xiModel1.setExcellentNumber(excellentNumber1);
            xiModel1.setGoodNumber(goodNumber1);
            xiModel1.setMedium(medium1);
            xiModel1.setQualifiedNumber(qualifiedNumber1);
            xiModel2.setExcellentNumber(excellentNumber2);
            xiModel2.setGoodNumber(goodNumber2);
            xiModel2.setMedium(medium2);
            xiModel2.setQualifiedNumber(qualifiedNumber2);
            firstSemesterList.add(xiModel1);
            secondSemesterList.add(xiModel2);
        }
        map.put("firstSemester", Integer.parseInt(year.trim()) - 1 + "~" + year.trim() + "-2");
        map.put("secondSemester", year.trim() + "~" + (Integer.parseInt(year.trim()) + 1) + "-1");
        map.put("firstSemesterList", firstSemesterList);
        map.put("secondSemesterList", secondSemesterList);
        map.put("year", year.trim());
        return "rateStat/xiRateStat";
    }

    /**
     * 各系优秀占比统计
     * @param map
     * @param year
     * @param halfYear
     * @return
     */
    @RequestMapping("/excellentStat")
    public String excellentStat(ModelMap map, String year, String halfYear) {
        List<XiModel> xiModels = xiService.selectList(new HashMap());
        if (year == null || year.trim().isEmpty()) {
            Calendar c = Calendar.getInstance();
            year = Integer.toString(c.get(Calendar.YEAR));
        }
        Date start_time = null;
        Date end_time = null;
        if (halfYear == null || halfYear.trim().isEmpty()) {
            start_time = StringUtil.getDate(year.trim() + "-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
            end_time = StringUtil.getDate(year.trim() + "-12-31 23:59:59", "yyyy-MM-dd HH:mm:ss");
        } else {
            String semester  = null;
            if (halfYear.trim().equals("1")) {
                int start_year = Integer.parseInt(year.trim()) - 1;
                int end_year = Integer.parseInt(year.trim());
                start_time = StringUtil.getDate(year.trim() + "-02-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
                end_time = StringUtil.getDate(year.trim() + "-08-31 23:59:59", "yyyy-MM-dd HH:mm:ss");
                semester = Integer.toString(start_year) + "~" + Integer.toString(end_year) + "-1";
                map.put("semesterFalg", 1);
            } else {
                int start_year = Integer.parseInt(year.trim());
                int end_year = Integer.parseInt(year.trim()) + 1;
                start_time = StringUtil.getDate(year.trim() + "-09-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
                end_time = StringUtil.getDate(Integer.toString(end_year) + "-01-31 23:59:59", "yyyy-MM-dd HH:mm:ss");
                semester = Integer.toString(start_year) + "~" + Integer.toString(end_year) + "-2";
                map.put("semesterFalg", 1);
            }
            map.put("semester", semester);
        }
        Map<String, Object> map_info = new HashMap<String, Object>();
        map_info.put("start_time", start_time);
        map_info.put("end_time", end_time);
        List<SteeringRatesModel> steeringRatesModels = steeringRatesService.selectList(map_info);
        int count = 0;
        int totalNumber = 0;
        for (XiModel xiModel : xiModels) {
            int excellentNumber = 0;
            for (SteeringRatesModel steeringRatesModel : steeringRatesModels) {
                if (steeringRatesModel.getClassModel() != null && xiModel.getXiName().equals(steeringRatesModel.getClassModel().getXiName())
                        && steeringRatesModel.getTotalRates() >= 90) {
                    excellentNumber++;
                }
            }
            totalNumber += excellentNumber;
            xiModel.setExcellentNumber(excellentNumber);
            xiModels.set(count, xiModel);
            count++;
        }
        int count2 = 0;
        for (XiModel xiModel : xiModels) {
            if (totalNumber == 0) {
                xiModel.setExcellentPerCent(0.0);
            } else {
                xiModel.setExcellentPerCent(Arith.div(xiModel.getExcellentNumber(), totalNumber, 4));
            }
            xiModels.set(count2, xiModel);
            count2++;
        }
        map.put("list", xiModels);
        map.put("year", year.trim());
        return "rateStat/excellentStat";
    }

    /**
     * 各系良好占比统计
     * @param map
     * @param year
     * @param halfYear
     * @return
     */
    @RequestMapping("/goodStat")
    public String goodStat(ModelMap map, String year, String halfYear) {
        List<XiModel> xiModels = xiService.selectList(new HashMap());
        if (year == null || year.trim().isEmpty()) {
            Calendar c = Calendar.getInstance();
            year = Integer.toString(c.get(Calendar.YEAR));
        }
        Date start_time = null;
        Date end_time = null;
        if (halfYear == null || halfYear.trim().isEmpty()) {
            start_time = StringUtil.getDate(year.trim() + "-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
            end_time = StringUtil.getDate(year.trim() + "-12-31 23:59:59", "yyyy-MM-dd HH:mm:ss");
        } else {
            String semester  = null;
            if (halfYear.trim().equals("1")) {
                int start_year = Integer.parseInt(year.trim()) - 1;
                int end_year = Integer.parseInt(year.trim());
                start_time = StringUtil.getDate(year.trim() + "-02-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
                end_time = StringUtil.getDate(year.trim() + "-08-31 23:59:59", "yyyy-MM-dd HH:mm:ss");
                semester = Integer.toString(start_year) + "~" + Integer.toString(end_year) + "-1";
                map.put("semesterFlag", 1);
            } else {
                int start_year = Integer.parseInt(year.trim());
                int end_year = Integer.parseInt(year.trim()) + 1;
                start_time = StringUtil.getDate(year.trim() + "-09-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
                end_time = StringUtil.getDate(Integer.toString(end_year) + "-01-31 23:59:59", "yyyy-MM-dd HH:mm:ss");
                semester = Integer.toString(start_year) + "~" + Integer.toString(end_year) + "-2";
                map.put("semesterFlag", 1);
            }
            map.put("semester", semester);
        }
        Map<String, Object> map_info = new HashMap<String, Object>();
        map_info.put("start_time", start_time);
        map_info.put("end_time", end_time);
        List<SteeringRatesModel> steeringRatesModels = steeringRatesService.selectList(map_info);
        int count = 0;
        int totalNumber = 0;
        for (XiModel xiModel : xiModels) {
            int goodNumber = 0;
            for (SteeringRatesModel steeringRatesModel : steeringRatesModels) {
                if (steeringRatesModel.getClassModel() != null && xiModel.getXiName().equals(steeringRatesModel.getClassModel().getXiName())
                        && steeringRatesModel.getTotalRates() < 90 && steeringRatesModel.getTotalRates() >= 80) {
                    goodNumber++;
                }
            }
            totalNumber += goodNumber;
            xiModel.setGoodNumber(goodNumber);
            xiModels.set(count, xiModel);
            count++;
        }
        int count2 = 0;
        for (XiModel xiModel : xiModels) {
            if (totalNumber == 0) {
                xiModel.setGoodPerCent(0.0);
            } else {
                xiModel.setGoodPerCent(Arith.div(xiModel.getGoodNumber(), totalNumber, 4));
            }
            xiModels.set(count2, xiModel);
            count2++;
        }
        map.put("list", xiModels);
        map.put("year", year.trim());
        return "rateStat/goodStat";
    }

    /**
     * 各系中等占比统计
     * @param map
     * @param year
     * @param halfYear
     * @return
     */
    @RequestMapping("/mediumStat")
    public String mediumStat(ModelMap map, String year, String halfYear) {
        List<XiModel> xiModels = xiService.selectList(new HashMap());
        if (year == null || year.trim().isEmpty()) {
            Calendar c = Calendar.getInstance();
            year = Integer.toString(c.get(Calendar.YEAR));
        }
        Date start_time = null;
        Date end_time = null;
        if (halfYear == null || halfYear.trim().isEmpty()) {
            start_time = StringUtil.getDate(year.trim() + "-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
            end_time = StringUtil.getDate(year.trim() + "-12-31 23:59:59", "yyyy-MM-dd HH:mm:ss");
        } else {
            String semester  = null;
            if (halfYear.trim().equals("1")) {
                int start_year = Integer.parseInt(year.trim()) - 1;
                int end_year = Integer.parseInt(year.trim());
                start_time = StringUtil.getDate(year.trim() + "-02-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
                end_time = StringUtil.getDate(year.trim() + "-08-31 23:59:59", "yyyy-MM-dd HH:mm:ss");
                semester = Integer.toString(start_year) + "~" + Integer.toString(end_year) + "-1";
                map.put("semesterFlag", 1);
            } else {
                int start_year = Integer.parseInt(year.trim());
                int end_year = Integer.parseInt(year.trim()) + 1;
                start_time = StringUtil.getDate(year.trim() + "-09-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
                end_time = StringUtil.getDate(Integer.toString(end_year) + "-01-31 23:59:59", "yyyy-MM-dd HH:mm:ss");
                semester = Integer.toString(start_year) + "~" + Integer.toString(end_year) + "-2";
                map.put("semesterFlag", 1);
            }
            map.put("semester", semester);
        }
        Map<String, Object> map_info = new HashMap<String, Object>();
        map_info.put("start_time", start_time);
        map_info.put("end_time", end_time);
        List<SteeringRatesModel> steeringRatesModels = steeringRatesService.selectList(map_info);
        int count = 0;
        int totalNumber = 0;
        for (XiModel xiModel : xiModels) {
            int mediumNumber = 0;
            for (SteeringRatesModel steeringRatesModel : steeringRatesModels) {
                if (steeringRatesModel.getClassModel() != null && xiModel.getXiName().equals(steeringRatesModel.getClassModel().getXiName())
                        && steeringRatesModel.getTotalRates() < 80 && steeringRatesModel.getTotalRates() >= 70) {
                    mediumNumber++;
                }
            }
            totalNumber += mediumNumber;
            xiModel.setMedium(mediumNumber);
            xiModels.set(count, xiModel);
            count++;
        }
        int count2 = 0;
        for (XiModel xiModel : xiModels) {
            if (totalNumber == 0) {
                xiModel.setMediumPerCent(0.0);
            } else {
                xiModel.setMediumPerCent(Arith.div(xiModel.getMedium(), totalNumber, 4));
            }
            xiModels.set(count2, xiModel);
            count2++;
        }
        map.put("list", xiModels);
        map.put("year", year.trim());
        return "rateStat/mediumStat";
    }

    /**
     * 各系合格占比统计
     * @param map
     * @param year
     * @param halfYear
     * @return
     */
    @RequestMapping("/qualifiedStat")
    public String qualifiedStat(ModelMap map, String year, String halfYear) {
        List<XiModel> xiModels = xiService.selectList(new HashMap());
        if (year == null || year.trim().isEmpty()) {
            Calendar c = Calendar.getInstance();
            year = Integer.toString(c.get(Calendar.YEAR));
        }
        Date start_time = null;
        Date end_time = null;
        if (halfYear == null || halfYear.trim().isEmpty()) {
            start_time = StringUtil.getDate(year.trim() + "-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
            end_time = StringUtil.getDate(year.trim() + "-12-31 23:59:59", "yyyy-MM-dd HH:mm:ss");
        } else {
            String semester  = null;
            if (halfYear.trim().equals("1")) {
                int start_year = Integer.parseInt(year.trim()) - 1;
                int end_year = Integer.parseInt(year.trim());
                start_time = StringUtil.getDate(year.trim() + "-02-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
                end_time = StringUtil.getDate(year.trim() + "-08-31 23:59:59", "yyyy-MM-dd HH:mm:ss");
                semester = Integer.toString(start_year) + "~" + Integer.toString(end_year) + "-1";
                map.put("semesterFlag", 1);
            } else {
                int start_year = Integer.parseInt(year.trim());
                int end_year = Integer.parseInt(year.trim()) + 1;
                start_time = StringUtil.getDate(year.trim() + "-09-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
                end_time = StringUtil.getDate(Integer.toString(end_year) + "-01-31 23:59:59", "yyyy-MM-dd HH:mm:ss");
                semester = Integer.toString(start_year) + "~" + Integer.toString(end_year) + "-2";
                map.put("semesterFlag", 1);
            }
            map.put("semester", semester);
        }
        Map<String, Object> map_info = new HashMap<String, Object>();
        map_info.put("start_time", start_time);
        map_info.put("end_time", end_time);
        List<SteeringRatesModel> steeringRatesModels = steeringRatesService.selectList(map_info);
        int count = 0;
        int totalNumber = 0;
        for (XiModel xiModel : xiModels) {
            int qualifiedNumber = 0;
            for (SteeringRatesModel steeringRatesModel : steeringRatesModels) {
                if (steeringRatesModel.getClassModel() != null && xiModel.getXiName().equals(steeringRatesModel.getClassModel().getXiName())
                        && steeringRatesModel.getTotalRates() < 70 && steeringRatesModel.getTotalRates() >= 60) {
                    qualifiedNumber++;
                }
            }
            totalNumber += qualifiedNumber;
            xiModel.setQualifiedNumber(qualifiedNumber);
            xiModels.set(count, xiModel);
            count++;
        }
        int count2 = 0;
        for (XiModel xiModel : xiModels) {
            if (totalNumber == 0) {
                xiModel.setQualifiedPerCent(0.0);
            } else {
                xiModel.setQualifiedPerCent(Arith.div(xiModel.getQualifiedNumber(), totalNumber, 4));
            }
            xiModels.set(count2, xiModel);
            count2++;
        }
        map.put("list", xiModels);
        map.put("year", year.trim());
        return "rateStat/qualifiedStat";
    }

    private Map<String, Object> getTimeRange(String schoolyear, String semester) {
        String time_range = null;
        Date start_time = null;
        Date end_time = null;
        String schoolyear_str = null;
        Map<String, Object> map_info = new HashMap<String, Object>();
        if (schoolyear != null && !schoolyear.trim().isEmpty()) {
            String start_year = schoolyear.substring(0, 4);
            String end_year = schoolyear.substring(5);
            if (semester == null || semester.trim().isEmpty()) {
                time_range = start_year + "-09-01~" + end_year + "-08-01";
            } else {
                if (semester.trim().equals("2")) {
                    //第二学期
                    time_range = end_year + "-02-01~" + end_year + "-08-01";
                } else  {
                    //第一学期
                    time_range = start_year + "-09-01~" + end_year + "-02-01";
                }
            }
            schoolyear_str = schoolyear.trim();
        } else {
            String now_time =StringUtil.getFormatDate(new Date(), "yyyy-MM-dd");
            int year_now = Integer.parseInt(now_time.substring(0, 4));
            int month = Integer.parseInt(now_time.substring(5, 7));
            if (month >=9 ) {
                time_range = Integer.toString(year_now) + "-09-01~" + Integer.toString(year_now + 1) + "-08-01";
            } else {
                time_range = Integer.toString(year_now - 1) + "-09-01~" + Integer.toString(year_now) + "-08-01";
            }
            schoolyear_str = time_range.substring(0, 4) + "~" + time_range.substring(11, 15);
        }
        start_time = StringUtil.getDate(time_range.substring(0, 10), "yyyy-MM-dd");
        end_time = StringUtil.getDate(time_range.substring(11), "yyyy-MM-dd");
        map_info.put("start_time", start_time);
        map_info.put("end_time", end_time);
        map_info.put("schoolyear_str", schoolyear_str);
        return map_info;
    }
}
