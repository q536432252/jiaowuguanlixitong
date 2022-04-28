package com.lin.controller;

import com.github.pagehelper.PageInfo;
import com.lin.pojo.Course;
import com.lin.pojo.CourseCustom;
import com.lin.pojo.SelectedCourseCustom;
import com.lin.service.CourseService;
import com.lin.service.SelectedCourseService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private SelectedCourseService selectedCourseService;

    //展示教师教的课程页面
    @GetMapping("/showCourse")
    public String showCourse(Model model, Integer page) {
      /*  if (page == null) page = 1;
        PageInfo<CourseCustom> pageInfo = courseService.selectAllPage(page, 3);
        model.addAttribute("pageInfo",pageInfo);
        return "/teacher/allCourse";*/
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        List<Course> courseList = courseService.selectByTeacherID(Integer.parseInt(username));
        model.addAttribute("courseList", courseList);
        return "/teacher/allCourse";
    }

    //跳转到 某课程 的学生名单
    @GetMapping("/showGrade")
    public String showGrade(Integer id, Model model) {
        List<SelectedCourseCustom> list = selectedCourseService.selectStudentByCourseID(id);
        model.addAttribute("selectedCourseList", list);
        return "teacher/showGrade";
    }

    //跳转到 打分的页面
    @GetMapping("/mark")
    public String mark(Model model, SelectedCourseCustom selectedCourseCustom){
        SelectedCourseCustom scc = selectedCourseService.selectByCourseIDAndStudentID(selectedCourseCustom);
        model.addAttribute("selectedCourse", scc);
        return "teacher/mark";
    }

    //打分操作
    @PostMapping("/mark")
    public String mark(SelectedCourseCustom selectedCourseCustom) {
        if (selectedCourseCustom != null) {
            System.out.println("scc : " + selectedCourseCustom.getCourseID()+ " ||||| " + selectedCourseCustom.getStudentID());
        } else {
            System.out.println("scc is null");
        }
        selectedCourseService.updateByID(selectedCourseCustom);
        return "redirect:/teacher/showGrade?id=" + selectedCourseCustom.getCourseID();
    }



    //修改密码
    @RequestMapping(value = "/passwordRest")
    public String passwordRest() throws Exception {
        return "teacher/passwordRest";
    }
}
