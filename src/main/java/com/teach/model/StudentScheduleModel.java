package com.teach.model;

public class StudentScheduleModel {
    private Long id;

    private Long studentId;

    private String courseNum;

    private String courseName;

    private Integer section;

    private String classroom;

    private String week1;

    private Integer rowspan1;

    private String week2;

    private Integer rowspan2;

    private String week3;

    private Integer rowspan3;

    private String week4;

    private Integer rowspan4;

    private String week5;

    private Integer rowspan5;

    private String week6;

    private Integer rowspan6;

    private String week7;

    private Integer rowspan7;

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

    public Integer getSection() {
        return section;
    }

    public void setSection(Integer section) {
        this.section = section;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom == null ? null : classroom.trim();
    }

    public String getWeek1() {
        return week1;
    }

    public void setWeek1(String week1) {
        this.week1 = week1 == null ? null : week1.trim();
    }

    public Integer getRowspan1() {
        return rowspan1;
    }

    public void setRowspan1(Integer rowspan1) {
        this.rowspan1 = rowspan1;
    }

    public String getWeek2() {
        return week2;
    }

    public void setWeek2(String week2) {
        this.week2 = week2 == null ? null : week2.trim();
    }

    public Integer getRowspan2() {
        return rowspan2;
    }

    public void setRowspan2(Integer rowspan2) {
        this.rowspan2 = rowspan2;
    }

    public String getWeek3() {
        return week3;
    }

    public void setWeek3(String week3) {
        this.week3 = week3 == null ? null : week3.trim();
    }

    public Integer getRowspan3() {
        return rowspan3;
    }

    public void setRowspan3(Integer rowspan3) {
        this.rowspan3 = rowspan3;
    }

    public String getWeek4() {
        return week4;
    }

    public void setWeek4(String week4) {
        this.week4 = week4 == null ? null : week4.trim();
    }

    public Integer getRowspan4() {
        return rowspan4;
    }

    public void setRowspan4(Integer rowspan4) {
        this.rowspan4 = rowspan4;
    }

    public String getWeek5() {
        return week5;
    }

    public void setWeek5(String week5) {
        this.week5 = week5 == null ? null : week5.trim();
    }

    public Integer getRowspan5() {
        return rowspan5;
    }

    public void setRowspan5(Integer rowspan5) {
        this.rowspan5 = rowspan5;
    }

    public String getWeek6() {
        return week6;
    }

    public void setWeek6(String week6) {
        this.week6 = week6 == null ? null : week6.trim();
    }

    public Integer getRowspan6() {
        return rowspan6;
    }

    public void setRowspan6(Integer rowspan6) {
        this.rowspan6 = rowspan6;
    }

    public String getWeek7() {
        return week7;
    }

    public void setWeek7(String week7) {
        this.week7 = week7 == null ? null : week7.trim();
    }

    public Integer getRowspan7() {
        return rowspan7;
    }

    public void setRowspan7(Integer rowspan7) {
        this.rowspan7 = rowspan7;
    }
}