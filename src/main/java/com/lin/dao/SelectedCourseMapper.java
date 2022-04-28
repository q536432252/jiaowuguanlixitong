package com.lin.dao;

import com.lin.pojo.SelectedCourse;
import com.lin.pojo.SelectedCourseCustom;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SelectedCourseMapper {
    //增
    @Insert("insert into selectedcourse(courseID,studentID) values(#{courseID},#{studentID})")
    int insert(SelectedCourse record);
    //删
    int deleteByID(Integer userID);

    @Delete("delete from selectedcourse where courseID = #{courseID} and studentID = #{studentID}")
    int deleteByCourseIDAndStudentID(SelectedCourseCustom record);

    //改
    @Update("update selectedcourse set mark = #{mark} where courseID = #{courseID} and studentID = #{studentID}")
    int updateByID(SelectedCourse record);

    //查询一个
    SelectedCourse selectByID(Integer userID);

    @Select("select * from selectedcourse where courseID = #{courseID} and studentID = #{studentID}")
    SelectedCourseCustom selectByCourseIDAndStudentID(SelectedCourseCustom record);

    @Select("select * from selectedcourse where courseID = #{id}")
    List<SelectedCourseCustom> selectByCourseID(Integer id);

    //查询全部
    @Select("select * from selectedcourse")
    List<SelectedCourseCustom> selectAll();
}
