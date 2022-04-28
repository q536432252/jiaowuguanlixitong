package com.lin.service;

import com.github.pagehelper.PageInfo;
import com.lin.pojo.Course;
import com.lin.pojo.Teacher;
import com.lin.pojo.TeacherCustom;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherService {
    //增
    int insert(Teacher record);
    //删
    int deleteByID(Integer userID);
    //改
    int updateByID(Teacher record);
    //查询一个
    TeacherCustom selectByID(Integer userID);

    //查询全部
    List<Teacher> selectAll();

    PageInfo<TeacherCustom> selectAllPage(Integer pageNum, Integer pageSize);
}
