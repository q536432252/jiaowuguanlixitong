package com.lin.pojo;

public class Course {
    public Integer courseID;
    public String courseName;
    public Integer teacherID;
    public String courseTime;
    public String classRoom;
    public Integer courseWeek;
    public String courseType;
    public Integer collegeID;
    public Integer score;

    public Course(Integer courseID, String courseName, Integer teacherID, String courseTime, String classRoom, Integer courseWeek, String courseType, Integer collegeID, Integer score) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.teacherID = teacherID;
        this.courseTime = courseTime;
        this.classRoom = classRoom;
        this.courseWeek = courseWeek;
        this.courseType = courseType;
        this.collegeID = collegeID;
        this.score = score;
    }

    public Course() {
    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Integer teacherID) {
        this.teacherID = teacherID;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public Integer getCourseWeek() {
        return courseWeek;
    }

    public void setCourseWeek(Integer courseWeek) {
        this.courseWeek = courseWeek;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public Integer getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(Integer collegeID) {
        this.collegeID = collegeID;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
