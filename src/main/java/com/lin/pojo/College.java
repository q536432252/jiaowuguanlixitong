package com.lin.pojo;

public class College {
    public Integer collegeID;
    public String collegeName;

    public College(Integer collegeID, String collegeName) {
        this.collegeID = collegeID;
        this.collegeName = collegeName;
    }

    public College() {
    }

    public Integer getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(Integer collegeID) {
        this.collegeID = collegeID;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
}
