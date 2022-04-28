package com.lin.service.impl;

import com.lin.dao.SelectedCourseMapper;
import com.lin.dao.StudentMapper;
import com.lin.pojo.SelectedCourse;
import com.lin.pojo.SelectedCourseCustom;
import com.lin.service.SelectedCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectedCourseServiceImpl implements SelectedCourseService {

    @Autowired
    private SelectedCourseMapper selectedCourseMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int insert(SelectedCourse record) {
        return selectedCourseMapper.insert(record);
    }

    @Override
    public int deleteByID(Integer userID) {
        return selectedCourseMapper.deleteByID(userID);
    }

    @Override
    public int deleteByCourseIDAndStudentID(SelectedCourseCustom record) {
        return selectedCourseMapper.deleteByCourseIDAndStudentID(record);
    }

    @Override
    public int updateByID(SelectedCourse record) {
        return selectedCourseMapper.updateByID(record);
    }

    @Override
    public SelectedCourse selectByID(Integer userID) {
        return selectedCourseMapper.selectByID(userID);
    }

    @Override
    public SelectedCourseCustom selectByCourseIDAndStudentID(SelectedCourseCustom record) {
        return selectedCourseMapper.selectByCourseIDAndStudentID(record);
    }

    @Override
    //通过courseID 找到 选了这门课的学生信息
    public List<SelectedCourseCustom> selectStudentByCourseID(Integer id) {
        List<SelectedCourseCustom> selectedCourseCustomList = selectedCourseMapper.selectByCourseID(id);
        for (SelectedCourseCustom i : selectedCourseCustomList) {
            i.setStudent(studentMapper.selectByID(i.getStudentID()));
        }
        return selectedCourseCustomList;


    }

    @Override
    public List<SelectedCourseCustom> selectAll() {
        return selectedCourseMapper.selectAll();
    }
}
