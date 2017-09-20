package com.teach.model;

public class XiModel {
    private Integer id;

    private String xiNum;

    private String xiName;

    private Integer maxValue;

    private Integer minValue;

    private Double avgValue;

    private Double middleValue;

    private Integer excellentNumber;

    private Double excellentPerCent;

    private Integer goodNumber;

    private Double goodPerCent;

    private Integer medium;

    private Double mediumPerCent;

    private Integer qualifiedNumber;

    private Double qualifiedPerCent;

    public Integer getExcellentNumber() {
        return excellentNumber;
    }

    public void setExcellentNumber(Integer excellentNumber) {
        this.excellentNumber = excellentNumber;
    }

    public Double getExcellentPerCent() {
        return excellentPerCent;
    }

    public void setExcellentPerCent(Double excellentPerCent) {
        this.excellentPerCent = excellentPerCent;
    }

    public Integer getGoodNumber() {
        return goodNumber;
    }

    public void setGoodNumber(Integer goodNumber) {
        this.goodNumber = goodNumber;
    }

    public Double getGoodPerCent() {
        return goodPerCent;
    }

    public void setGoodPerCent(Double goodPerCent) {
        this.goodPerCent = goodPerCent;
    }

    public Integer getMedium() {
        return medium;
    }

    public void setMedium(Integer medium) {
        this.medium = medium;
    }

    public Double getMediumPerCent() {
        return mediumPerCent;
    }

    public void setMediumPerCent(Double mediumPerCent) {
        this.mediumPerCent = mediumPerCent;
    }

    public Integer getQualifiedNumber() {
        return qualifiedNumber;
    }

    public void setQualifiedNumber(Integer qualifiedNumber) {
        this.qualifiedNumber = qualifiedNumber;
    }

    public Double getQualifiedPerCent() {
        return qualifiedPerCent;
    }

    public void setQualifiedPerCent(Double qualifiedPerCent) {
        this.qualifiedPerCent = qualifiedPerCent;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    public Integer getMinValue() {
        return minValue;
    }

    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }

    public Double getAvgValue() {
        return avgValue;
    }

    public void setAvgValue(Double avgValue) {
        this.avgValue = avgValue;
    }

    public Double getMiddleValue() {
        return middleValue;
    }

    public void setMiddleValue(Double middleValue) {
        this.middleValue = middleValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}