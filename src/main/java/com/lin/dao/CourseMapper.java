package com.lin.dao;

import com.lin.pojo.Course;
import com.lin.pojo.CourseCustom;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {
    //增
    @Insert("insert into course values(#{courseID},#{courseName},#{teacherID},#{courseTime},#{classRoom},#{courseWeek},#{courseType},#{collegeID},#{score})")
    int insert(Course record);

    //删
    @Delete("delete from course where courseID = #{userID}")
    int deleteByID(Integer userID);

    //改
    @Update("update course set courseName = #{courseName}, teacherID = #{teacherID}, courseTime = #{courseTime}, classRoom = #{classRoom}, courseWeek = #{courseWeek}, courseType = #{courseType}, collegeID = #{collegeID}, score = #{score} " +
            "where courseID = #{courseID}")
    int updateByID(Course record);

    //查询一个
    @Select("select * from course where courseID = #{userID}")
    Course selectByID(Integer userID);
    @Select("select course.* from course where course.teacherID = #{teacherID}")
    List<Course> selectByTeacherID(Integer teacherID);

    //查询全部
    List<Course> selectAll();

    //分页查询
    @Select("select * from course")
    List<CourseCustom> selectAllPage();
}
