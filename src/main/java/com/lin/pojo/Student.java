package com.lin.pojo;

import java.util.Date;

public class Student {
    public Integer userID;
    public String userName;
    public String sex;
    public Date birthYear;
    public Date grade;
    public Integer collegeID;

    public Student() {
    }

    public Student(Integer userID, String userName, String sex, Date birthYear, Date grade, Integer collegeID) {
        this.userID = userID;
        this.userName = userName;
        this.sex = sex;
        this.birthYear = birthYear;
        this.grade = grade;
        this.collegeID = collegeID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Date birthYear) {
        this.birthYear = birthYear;
    }

    public Date getGrade() {
        return grade;
    }

    public void setGrade(Date grade) {
        this.grade = grade;
    }

    public Integer getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(Integer collegeID) {
        this.collegeID = collegeID;
    }
}
