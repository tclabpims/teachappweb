package com.teach.model;

import java.util.Date;

public class StudentRatesModel {
    private Long id;

    private Long studentId;

    private String courseNum;

    private String courseName;

    private String section;

    private Long teachId;

    private Date toclassTime;

    private Integer rate1;

    private Integer rate2;

    private Integer rate3;

    private Integer rate4;

    private Integer rate5;

    private Integer total;

    private Date rateTime;

    private String rateContent1;

    private String rateContent2;

    private String rateContent3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum == null ? null : courseNum.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section == null ? null : section.trim();
    }

    public Long getTeachId() {
        return teachId;
    }

    public void setTeachId(Long teachId) {
        this.teachId = teachId;
    }

    public Date getToclassTime() {
        return toclassTime;
    }

    public void setToclassTime(Date toclassTime) {
        this.toclassTime = toclassTime;
    }

    public Integer getRate1() {
        return rate1;
    }

    public void setRate1(Integer rate1) {
        this.rate1 = rate1;
    }

    public Integer getRate2() {
        return rate2;
    }

    public void setRate2(Integer rate2) {
        this.rate2 = rate2;
    }

    public Integer getRate3() {
        return rate3;
    }

    public void setRate3(Integer rate3) {
        this.rate3 = rate3;
    }

    public Integer getRate4() {
        return rate4;
    }

    public void setRate4(Integer rate4) {
        this.rate4 = rate4;
    }

    public Integer getRate5() {
        return rate5;
    }

    public void setRate5(Integer rate5) {
        this.rate5 = rate5;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Date getRateTime() {
        return rateTime;
    }

    public void setRateTime(Date rateTime) {
        this.rateTime = rateTime;
    }

    public String getRateContent1() {
        return rateContent1;
    }

    public void setRateContent1(String rateContent1) {
        this.rateContent1 = rateContent1 == null ? null : rateContent1.trim();
    }

    public String getRateContent2() {
        return rateContent2;
    }

    public void setRateContent2(String rateContent2) {
        this.rateContent2 = rateContent2 == null ? null : rateContent2.trim();
    }

    public String getRateContent3() {
        return rateContent3;
    }

    public void setRateContent3(String rateContent3) {
        this.rateContent3 = rateContent3 == null ? null : rateContent3.trim();
    }
}