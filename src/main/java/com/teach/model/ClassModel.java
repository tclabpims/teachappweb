package com.teach.model;

public class ClassModel {
    private Long id;

    private String className;

    private String xiNum;

    private String xiName;

    private String graduates;

    private Integer totalNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getXiNum() {
        return xiNum;
    }

    public void setXiNum(String xiNum) {
        this.xiNum = xiNum == null ? null : xiNum.trim();
    }

    public String getXiName() {
        return xiName;
    }

    public void setXiName(String xiName) {
        this.xiName = xiName == null ? null : xiName.trim();
    }

    public String getGraduates() {
        return graduates;
    }

    public void setGraduates(String graduates) {
        this.graduates = graduates == null ? null : graduates.trim();
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }
}