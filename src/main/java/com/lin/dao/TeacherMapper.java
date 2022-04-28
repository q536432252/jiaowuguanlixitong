package com.lin.dao;

import com.lin.pojo.StudentCustom;
import com.lin.pojo.Teacher;
import com.lin.pojo.TeacherCustom;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapper {
    //增
    @Insert("insert into teacher values(#{userID},#{userName},#{sex},#{birthYear},#{degree},#{title},#{grade},#{collegeID})")
    int insert(Teacher record);
    //删
    @Delete("delete from teacher where userID = #{userID}")
    int deleteByID(Integer userID);
    //改
    @Update("update teacher set userName = #{userName},sex=#{sex},birthYear=#{birthYear},degree=#{degree},title=#{title},grade=#{grade},collegeID=#{collegeID} where userID = #{userID}")
    int updateByID(Teacher record);
    //查询一个

    @Select("select teacher.*, college.collegeName from teacher,college where teacher.collegeID = college.collegeID and teacher.userID = #{userID}")
    TeacherCustom selectByID(Integer userID);

    //查询全部
    @Select("select * from teacher")
    List<Teacher> selectAll();

    @Select("select teacher.*, college.collegeName from teacher,college " +
            "where teacher.collegeID = college.collegeID")
    List<TeacherCustom> selectAllPage();
}
