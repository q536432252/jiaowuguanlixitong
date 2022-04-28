package com.lin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.dao.TeacherMapper;
import com.lin.pojo.Course;
import com.lin.pojo.Teacher;
import com.lin.pojo.TeacherCustom;
import com.lin.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public int insert(Teacher record) {
        return teacherMapper.insert(record);
    }

    @Override
    public int deleteByID(Integer userID) {
        return teacherMapper.deleteByID(userID);
    }

    @Override
    public int updateByID(Teacher record) {
        return teacherMapper.updateByID(record);
    }

    @Override
    public TeacherCustom selectByID(Integer userID) {
        return teacherMapper.selectByID(userID);
    }



    @Override
    public List<Teacher> selectAll() {
        return teacherMapper.selectAll();
    }

    @Override
    public PageInfo<TeacherCustom> selectAllPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TeacherCustom> teacherCustoms = teacherMapper.selectAllPage();
        PageInfo pageInfo = new PageInfo(teacherCustoms);
        return pageInfo;
    }
}
