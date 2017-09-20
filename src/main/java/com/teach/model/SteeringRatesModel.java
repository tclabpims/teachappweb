package com.teach.model;

import java.util.Date;

public class SteeringRatesModel {
    private Long id;

    private Long steeringId;

    private Long teachId;

    private Date teachingTime;

    private Long courseId;

    private Integer section;

    private String courseType;

    private Long classId;

    private Integer tonum;

    private Integer latenum;

    private String classroom;

    private String teachContent;

    private Date saveTime1;

    private Integer rates1;

    private Integer rates2;

    private Integer rates3;

    private Integer rates4;

    private Integer rates5;

    private Integer rates6;

    private Integer rates7;

    private Integer rates8;

    private Integer rates9;

    private Integer totalRates;

    private Date saveTime2;

    private String ratesContent1;

    private String ratesTeachName1;

    private Date ratesTime1;

    private String ratesContent2;

    private String ratesTeachName2;

    private Date ratesTime2;

    private String ratesContent3;

    private String ratesTeachName3;

    private Date ratesTime3;

    private String ratesContent4;

    private String ratesTeachName4;

    private Date ratesTime4;

    private String ratesContent5;

    private String ratesTeachName5;

    private Date ratesTime5;

    private String status;

    private ClassModel classModel;

    public ClassModel getClassModel() {
        return classModel;
    }

    public void setClassModel(ClassModel classModel) {
        this.classModel = classModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSteeringId() {
        return steeringId;
    }

    public void setSteeringId(Long steeringId) {
        this.steeringId = steeringId;
    }

    public Long getTeachId() {
        return teachId;
    }

    public void setTeachId(Long teachId) {
        this.teachId = teachId;
    }

    public Date getTeachingTime() {
        return teachingTime;
    }

    public void setTeachingTime(Date teachingTime) {
        this.teachingTime = teachingTime;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Integer getSection() {
        return section;
    }

    public void setSection(Integer section) {
        this.section = section;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType == null ? null : courseType.trim();
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Integer getTonum() {
        return tonum;
    }

    public void setTonum(Integer tonum) {
        this.tonum = tonum;
    }

    public Integer getLatenum() {
        return latenum;
    }

    public void setLatenum(Integer latenum) {
        this.latenum = latenum;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom == null ? null : classroom.trim();
    }

    public String getTeachContent() {
        return teachContent;
    }

    public void setTeachContent(String teachContent) {
        this.teachContent = teachContent == null ? null : teachContent.trim();
    }

    public Date getSaveTime1() {
        return saveTime1;
    }

    public void setSaveTime1(Date saveTime1) {
        this.saveTime1 = saveTime1;
    }

    public Integer getRates1() {
        return rates1;
    }

    public void setRates1(Integer rates1) {
        this.rates1 = rates1;
    }

    public Integer getRates2() {
        return rates2;
    }

    public void setRates2(Integer rates2) {
        this.rates2 = rates2;
    }

    public Integer getRates3() {
        return rates3;
    }

    public void setRates3(Integer rates3) {
        this.rates3 = rates3;
    }

    public Integer getRates4() {
        return rates4;
    }

    public void setRates4(Integer rates4) {
        this.rates4 = rates4;
    }

    public Integer getRates5() {
        return rates5;
    }

    public void setRates5(Integer rates5) {
        this.rates5 = rates5;
    }

    public Integer getRates6() {
        return rates6;
    }

    public void setRates6(Integer rates6) {
        this.rates6 = rates6;
    }

    public Integer getRates7() {
        return rates7;
    }

    public void setRates7(Integer rates7) {
        this.rates7 = rates7;
    }

    public Integer getRates8() {
        return rates8;
    }

    public void setRates8(Integer rates8) {
        this.rates8 = rates8;
    }

    public Integer getRates9() {
        return rates9;
    }

    public void setRates9(Integer rates9) {
        this.rates9 = rates9;
    }

    public Integer getTotalRates() {
        return totalRates;
    }

    public void setTotalRates(Integer totalRates) {
        this.totalRates = totalRates;
    }

    public Date getSaveTime2() {
        return saveTime2;
    }

    public void setSaveTime2(Date saveTime2) {
        this.saveTime2 = saveTime2;
    }

    public String getRatesContent1() {
        return ratesContent1;
    }

    public void setRatesContent1(String ratesContent1) {
        this.ratesContent1 = ratesContent1 == null ? null : ratesContent1.trim();
    }

    public String getRatesTeachName1() {
        return ratesTeachName1;
    }

    public void setRatesTeachName1(String ratesTeachName1) {
        this.ratesTeachName1 = ratesTeachName1 == null ? null : ratesTeachName1.trim();
    }

    public Date getRatesTime1() {
        return ratesTime1;
    }

    public void setRatesTime1(Date ratesTime1) {
        this.ratesTime1 = ratesTime1;
    }

    public String getRatesContent2() {
        return ratesContent2;
    }

    public void setRatesContent2(String ratesContent2) {
        this.ratesContent2 = ratesContent2 == null ? null : ratesContent2.trim();
    }

    public String getRatesTeachName2() {
        return ratesTeachName2;
    }

    public void setRatesTeachName2(String ratesTeachName2) {
        this.ratesTeachName2 = ratesTeachName2 == null ? null : ratesTeachName2.trim();
    }

    public Date getRatesTime2() {
        return ratesTime2;
    }

    public void setRatesTime2(Date ratesTime2) {
        this.ratesTime2 = ratesTime2;
    }

    public String getRatesContent3() {
        return ratesContent3;
    }

    public void setRatesContent3(String ratesContent3) {
        this.ratesContent3 = ratesContent3 == null ? null : ratesContent3.trim();
    }

    public String getRatesTeachName3() {
        return ratesTeachName3;
    }

    public void setRatesTeachName3(String ratesTeachName3) {
        this.ratesTeachName3 = ratesTeachName3 == null ? null : ratesTeachName3.trim();
    }

    public Date getRatesTime3() {
        return ratesTime3;
    }

    public void setRatesTime3(Date ratesTime3) {
        this.ratesTime3 = ratesTime3;
    }

    public String getRatesContent4() {
        return ratesContent4;
    }

    public void setRatesContent4(String ratesContent4) {
        this.ratesContent4 = ratesContent4 == null ? null : ratesContent4.trim();
    }

    public String getRatesTeachName4() {
        return ratesTeachName4;
    }

    public void setRatesTeachName4(String ratesTeachName4) {
        this.ratesTeachName4 = ratesTeachName4 == null ? null : ratesTeachName4.trim();
    }

    public Date getRatesTime4() {
        return ratesTime4;
    }

    public void setRatesTime4(Date ratesTime4) {
        this.ratesTime4 = ratesTime4;
    }

    public String getRatesContent5() {
        return ratesContent5;
    }

    public void setRatesContent5(String ratesContent5) {
        this.ratesContent5 = ratesContent5 == null ? null : ratesContent5.trim();
    }

    public String getRatesTeachName5() {
        return ratesTeachName5;
    }

    public void setRatesTeachName5(String ratesTeachName5) {
        this.ratesTeachName5 = ratesTeachName5 == null ? null : ratesTeachName5.trim();
    }

    public Date getRatesTime5() {
        return ratesTime5;
    }

    public void setRatesTime5(Date ratesTime5) {
        this.ratesTime5 = ratesTime5;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}