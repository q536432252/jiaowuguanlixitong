package com.lin.dao;

import com.github.pagehelper.PageInfo;
import com.lin.pojo.Student;
import com.lin.pojo.StudentCustom;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //注明是Dao组件  和 @Controller作用一样
public interface StudentMapper {
    //增
    //@Insert("insert into tb_user(name,sex,age) values(#{name},#{sex},#{age})")
// useGeneratedKeys = true,表示使用自动增长的主键
// keyProperty = "id",表示插入数据库表时生成的主键设置到User对象的id属性.
    /*@Options(
            useGeneratedKeys = true,
            keyProperty = "id"
    )*/
    @Insert("insert into student(userID,userName,sex,birthYear,grade,collegeID) values(#{userID},#{userName},#{sex},#{birthYear},#{grade},#{collegeID})")
    int insert(Student record);

    //删
    @Delete("delete from student where userID = #{userID}")
    int deleteByID(@Param("userID") Integer userID);

    //改
    @Update("update student set userName = #{userName}, sex = #{sex}, birthYear = #{birthYear}, grade = #{grade}, collegeID = #{collegeID} where userID = #{userID};")
    int updateByID(StudentCustom record);

    //查询一个
    //@Select("select student.*, college.collegeName from student,college where student.collegeID = college.collegeID and student.userID = #{userID}")
    //@Select("select student.*, college.collegeName from student,college where student.collegeID = college.collegeID")
    @Select("select student.*, college.collegeName from student,college where student.collegeID = college.collegeID and student.userID = #{userID}")
    StudentCustom selectByID(@Param("userID") Integer userID2);

    //@Select("select student.*, college.collegeName, from student,college where student.collegeID = college.collegeID and student.userID = #{name}")
    //@Select("select student.*, college.collegeName, selectedcourse.* from student,college,selectedcourse where student.collegeID = college.collegeID and student.userID = #{name} and selectedcourse.studentID = student.userID")
    @Select("select course.*, selectedcourse.* from course,selectedcourse where selectedcourse.studentID = #{name} and selectedcourse.courseID = course.courseID")
    List<StudentCustom> selectByName(@Param("name") String name);
    //StudentCustom selectByName(@Param("name") String name);


    //查询全部
    List<Student> selectAll();

    @Select("select student.*, college.collegeName from student,college " +
            "where student.collegeID = college.collegeID")
    List<StudentCustom> selectAllPage();
}
