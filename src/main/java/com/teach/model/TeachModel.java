package com.teach.model;

import java.util.Date;

public class TeachModel {
    private Long id;

    private String jobNum;

    private String password;

    private String name;

    private String xiName;

    private String xiNum;

    private String group;

    private String title;

    private String type;

    private Integer rateNum;

    private String courseNum;

    private Date createTime;

    private Date modifyTime;

    private String xiName_;

    private Integer rateTimes;

    private Integer maxRate;

    private Integer minRate;

    private Double avgRate;

    public String getXiName_() {
        return xiName_;
    }

    public void setXiName_(String xiName_) {
        this.xiName_ = xiName_;
    }

    public Integer getRateTimes() {
        return rateTimes;
    }

    public void setRateTimes(Integer rateTimes) {
        this.rateTimes = rateTimes;
    }

    public Integer getMaxRate() {
        return maxRate;
    }

    public void setMaxRate(Integer maxRate) {
        this.maxRate = maxRate;
    }

    public Integer getMinRate() {
        return minRate;
    }

    public void setMinRate(Integer minRate) {
        this.minRate = minRate;
    }

    public Double getAvgRate() {
        return avgRate;
    }

    public void setAvgRate(Double avgRate) {
        this.avgRate = avgRate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobNum() {
        return jobNum;
    }

    public void setJobNum(String jobNum) {
        this.jobNum = jobNum == null ? null : jobNum.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getXiName() {
        return xiName;
    }

    public void setXiName(String xiName) {
        this.xiName = xiName == null ? null : xiName.trim();
    }

    public String getXiNum() {
        return xiNum;
    }

    public void setXiNum(String xiNum) {
        this.xiNum = xiNum == null ? null : xiNum.trim();
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group == null ? null : group.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getRateNum() {
        return rateNum;
    }

    public void setRateNum(Integer rateNum) {
        this.rateNum = rateNum;
    }

    public String getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum == null ? null : courseNum.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}