package com.lin.controller;

import com.github.pagehelper.PageInfo;
import com.lin.exception.CustomException;
import com.lin.pojo.CourseCustom;
import com.lin.pojo.SelectedCourse;
import com.lin.pojo.SelectedCourseCustom;
import com.lin.pojo.StudentCustom;
import com.lin.service.CourseService;
import com.lin.service.SelectedCourseService;
import com.lin.service.StudentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private SelectedCourseService selectedCourseService;
    @Autowired
    private StudentService studentService;

    //所有课程========================================================

    //展示课程
    @GetMapping("/showCourse")
    public String showCourse(Model model, Integer page) {
        //System.out.println("this is student showCourse");
        if (page == null) page = 1;
        PageInfo<CourseCustom> pageInfo = courseService.selectAllPage(page, 3);
        model.addAttribute("pageInfo",pageInfo);
        return "/student/allCourse";
    }

    //------------------------------------------------------------

    //进行 选课操作
    @GetMapping("/selectCourse")
    public String selectCourse(Integer id) throws CustomException {
        Subject subject = SecurityUtils.getSubject();
        //当前的学生
        String username = (String) subject.getPrincipal();
        SelectedCourseCustom selectedCourseCustom = new SelectedCourseCustom();
        selectedCourseCustom.setCourseID(id);
        selectedCourseCustom.setStudentID(Integer.parseInt(username));
        //System.out.println("当前学生getCourseID : " + selectedCourseCustom.getCourseID() + " getStudentID()  " + selectedCourseCustom.getStudentID() );
        List<SelectedCourseCustom> temp = selectedCourseService.selectAll();
        //0没有选过该课程，1已经选过该课程
        boolean isSelected = false;
        for (SelectedCourseCustom i : temp) {
            if (i.getCourseID().equals(selectedCourseCustom.getCourseID()) && i.getStudentID().equals(selectedCourseCustom.getStudentID())) {
                isSelected = true;
                break;
            }
        }
        if (isSelected) {
            throw new CustomException("已经选过该课程");
        } else {
            selectedCourseService.insert(selectedCourseCustom);
        }
        //如果数据库里面 有个完全一样的 courseID && studentID 说明重复 不再添加
        return "redirect:/student/selectedCourse";
    }

    // 跳转到 已选课程 页面
    @GetMapping("/selectedCourse")
    public String selectedCourse (Model model) {
        //获取当前活动对象
        Subject subject = SecurityUtils.getSubject();

        List<StudentCustom> studentCustomList = studentService.selectByName((String) subject.getPrincipal());

        model.addAttribute("studentCustomList",studentCustomList);
        return "/student/selectedCourse";

    }

    //退课操作
    @GetMapping("/outCourse")
    public String outCourse(Integer id) {
        Subject subject =SecurityUtils.getSubject();
        String username =(String) subject.getPrincipal();
        SelectedCourseCustom selectedCourseCustom =new SelectedCourseCustom();
        selectedCourseCustom.setStudentID(Integer.parseInt(username));
        selectedCourseCustom.setCourseID(id);
        selectedCourseService.deleteByCourseIDAndStudentID(selectedCourseCustom);
        return "redirect:/student/selectedCourse";
    }

    //------------------------------------------------------------

    //已修课程
    @GetMapping("/overCourse")
    public String overCourse(Model model) {
        //获取当前活动对象
        Subject subject = SecurityUtils.getSubject();
        List<StudentCustom> studentCustomList = studentService.selectOverCourseByName((String) subject.getPrincipal());
        model.addAttribute("studentCustomList",studentCustomList);
        return "/student/overCourse";
    }

//------------------------------------------------------------
    //修改密码
    @GetMapping("/passwordRest")
    public String passwordRest() throws Exception {
        return "student/passwordRest";
    }

}
