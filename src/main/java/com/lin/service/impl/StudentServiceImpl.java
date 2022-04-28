package com.lin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.dao.StudentMapper;
import com.lin.pojo.Student;
import com.lin.pojo.StudentCustom;
import com.lin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    //使用spring自动注入
    @Autowired
    private StudentMapper studentMapper;

    public int insert(Student record) {
        return studentMapper.insert(record);
    }

    public int deleteByID(Integer userID) {
        return studentMapper.deleteByID(userID);
    }

    public int updateByID(StudentCustom record) {
        return studentMapper.updateByID(record);
    }

    public StudentCustom selectByID(Integer userID) {
        return studentMapper.selectByID(userID);
    }

    @Override
    public List<StudentCustom> selectByName(String name) {
        //return studentMapper.selectByName(name);
        List<StudentCustom> studentCustoms = studentMapper.selectByName(name);

        List<StudentCustom> studentCustomsList = new ArrayList<>();

        //还没有打分的课程才放到已选课程列表里面
        for (StudentCustom i : studentCustoms) {
            if (i.getMark() == null) {
                studentCustomsList.add(i);
            }
        }
        return studentCustomsList;
    }

    @Override
    public List<StudentCustom> selectOverCourseByName(String name) {
        List<StudentCustom> studentCustoms = studentMapper.selectByName(name);

        List<StudentCustom> studentCustomsList = new ArrayList<>();

        //还没有打分的课程才放到已选课程列表里面
        for (StudentCustom i : studentCustoms) {
            if (i.getMark() != null) {
                studentCustomsList.add(i);
            }
        }
        return studentCustomsList;
    }


    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }

    @Override
    public PageInfo<StudentCustom> selectAllPage(Integer pageNum, Integer pageSize) {
        //PageHelper.offsetPage()使用偏移量分页查询，和第一条相比偏移多少条数据
        //开启分页
        PageHelper.startPage(pageNum, pageSize);
        //查询所有
        List<StudentCustom> list = studentMapper.selectAllPage();
        PageInfo pageInfo = new PageInfo(list);
        /*System.out.println("获取总页数" + pageInfo.getPages());
        System.out.println("获取当前页" + pageInfo.getPageNum());
        System.out.println("每页条数" + pageInfo.getPageSize());
        System.out.println("总记录数" + pageInfo.getTotal());
        System.out.println("获取第一页" + pageInfo.getNavigateFirstPage());
        System.out.println("获取最后一页" + pageInfo.getNavigateLastPage());
        System.out.println("上一页" + pageInfo.getPrePage());
        System.out.println("下一页" + pageInfo.getNextPage());
        System.out.println("获取当前页的数据" + pageInfo.getList());*/
        return pageInfo;
    }




}
