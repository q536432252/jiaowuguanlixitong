package com.lin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.dao.CourseMapper;
import com.lin.pojo.Course;
import com.lin.pojo.CourseCustom;
import com.lin.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public int insert(Course record) {
        return courseMapper.insert(record);
    }

    @Override
    public int deleteByID(Integer userID) {
        return courseMapper.deleteByID(userID);
    }

    @Override
    public int updateByID(Course record) {
        return courseMapper.updateByID(record);
    }

    @Override
    public Course selectByID(Integer userID) {
        return courseMapper.selectByID(userID);
    }

    @Override
    public List<Course> selectByTeacherID(Integer teacherID) {
        return courseMapper.selectByTeacherID(teacherID);
    }

    @Override
    public List<Course> selectAll() {
        return courseMapper.selectAll();
    }

    @Override
    public PageInfo<CourseCustom> selectAllPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<CourseCustom> list = courseMapper.selectAllPage();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }
}
