package com.lin.controller;

import com.github.pagehelper.PageInfo;
import com.lin.exception.CustomException;
import com.lin.pojo.*;
import com.lin.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CollegeService collegeService;

    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private UserCountService userCountService;





    // 学生 ============= ============= =============

    //---------- 展示学生 ---------- ---------- ----------
    //遇到的问题：Student类中没有只有collegeID，没有collegeName，所以在页面展示的时候，只能展示collegeID，
    //新建了一个StudentCustom类继承了Student类，里面新增了collegeName字段，  在mapper层查询的时候，在sql语句里面也进行了两个表一起查询
    //学生信息展示页面
    @RequestMapping("/showStudent")
    public String showStudent(Model model, Integer page) throws Exception{
        System.out.println("this is AdminController");
        if (page == null) page = 1;
        PageInfo<StudentCustom> pageInfo = studentService.selectAllPage(page,3);
        model.addAttribute("pageInfo", pageInfo);

/*
        //redis 查询当前注册的用户
        String curCount = null;
        curCount = (String)redisTemplate.opsForValue().get("curCount");
        if(curCount == null){
            //redis缓存中无数据，从数据库中查询，并放入redis缓存中，设置生存时间为1小时
            System.out.println("从数据库中取当前已注册用户数量");
            curCount = Integer.toString(userCountService.selectCount());
            redisTemplate.opsForValue().set("curCount", curCount, 1, TimeUnit.HOURS);
        } else {
            System.out.println("从redis缓存中取当前已注册用户数量");
        }
        model.addAttribute("curCount", curCount);*/
        /*
        int curCount = userCountService.selectCount();
        model.addAttribute("curCount", curCount);
        */
        return "/admin/allStudent";

    }

    //---------- 新增学生 ---------- ---------- ----------

    //新增 学生页面展示
    @GetMapping("/addStudent")
    public String addStudent(Model model) {
        List<College> collegeList = collegeService.selectAll();
        model.addAttribute("collegeList",collegeList);
        return "/admin/addStudent";
    }

    //新增 学生操作
    @PostMapping("/addStudent2")
    public String addStudent(Student student) {
        System.out.println(student.getUserID() + " " + student.getUserName() + " " + student.getSex() + " " + student.getBirthYear()  + " " + student.getUserID());
        System.out.println("this is addStudent2");
        studentService.insert(student);
        UserLogin userLogin = new UserLogin();
        userLogin.setUserName(student.getUserID().toString());
        userLogin.setPassword("123456");
        userLogin.setRole(2);
        userLoginService.insert(userLogin);
        return "redirect:/admin/showStudent";
    }



    //---------- 修改学生 ---------- ---------- ----------

    //修改 学生页面展示
    @GetMapping("/updateStudent")
    public String UpdateStudent(Integer id, Model model) {
        StudentCustom student = studentService.selectByID(id);
        model.addAttribute("student",student);
        List<College> collegeList = collegeService.selectAll();
        model.addAttribute("collegeList", collegeList);
        return "/admin/updateStudent";
    }


    //修改 学生信息
    @PostMapping("/updateStudent2")
    public String UpdateStudent(StudentCustom student) {
        studentService.updateByID(student);
        System.out.println("this is updateStudent2");
        return "redirect:/admin/showStudent";
    }


    //---------- 删除学生 ---------- ----------

    //删除学生信息
    @GetMapping("/deleteStudent")
    public String deleteStudent(Integer id) {
        studentService.deleteByID(id);
        userLoginService.deleteByID(id+"");
        return "redirect:/admin/showStudent";
    }

    // 课程 ============= ============= ============= ============= ============= =============


    //课程信息展示页面
    @RequestMapping("/showCourse")
    public String showCourse(Model model, Integer page) throws Exception{
        if (page == null) page = 1;
        PageInfo<CourseCustom> pageInfo = courseService.selectAllPage(page, 3);
        model.addAttribute("pageInfo", pageInfo);
        return "/admin/allCourse";
    }

    //---------- 新增课程 ---------- ---------- ----------

    //跳转至新增课程页面展示
    @GetMapping("/addCourse")
    public String addCourse(Model model) {
        List<College> collegeList = collegeService.selectAll();
        List<Teacher> teacherList = teacherService.selectAll();
        model.addAttribute("collegeList",collegeList);
        model.addAttribute("teacherList",teacherList);
        return "/admin/addCourse";
    }

    //新增 课程操作
    @PostMapping("/addCourse2")
    public String addCourse(CourseCustom courseCustom) {
        //System.out.println(student.getUserName() + " " + student.getUserName() + " " + student.getSex() + " " + student.getBirthYear()  + " " + student.getUserID());
        //System.out.println("this is addcourseCustom2");
        courseService.insert(courseCustom);
     /*   studentService.insert(student);
        UserLogin userLogin = new UserLogin();
        userLogin.setUserName(student.getUserID().toString());
        userLogin.setPassword("123456");
        userLogin.setRole(2);
        userLoginService.insert(userLogin);*/
        return "redirect:/admin/showCourse";

    }



    //---------- 修改课程 ---------- ---------- ----------

    //修改 课程页面展示
    @GetMapping("/updateCourse")
    public String UpdateCourse(Integer id, Model model) {
        Course course = courseService.selectByID(id);
        model.addAttribute("course", course);

        List<Teacher> teacherList = teacherService.selectAll();
        model.addAttribute("teacherList",teacherList);

        List<College> collegeList = collegeService.selectAll();
        model.addAttribute("collegeList", collegeList);

        return "/admin/updateCourse";
    }


    //修改 课程信息
    @PostMapping("/updateCourse")
    public String UpdateCourse(Course course) {
        //studentService.updateByID(student);
        courseService.updateByID(course);
        System.out.println("this is updateStudent2");
        return "redirect:/admin/showCourse";
    }


    //---------- 删除课程 ---------- ----------
    //删除课程
    @GetMapping("/deleteCourse")
    public String deleteCourse(Integer id) {
        //studentService.deleteByID(id);
        courseService.deleteByID(id);
        //userLoginService.deleteByID(id);
        return "redirect:/admin/showCourse";
    }

    //===============教师管理=================教师管理=================教师管理===================

    //教师信息展示页面
    @RequestMapping("/showTeacher")
    public String showTeacher(Model model, Integer page) throws Exception{
        //System.out.println("this is showCourseController");
        if (page == null) page = 1;

        PageInfo<TeacherCustom> pageInfo = teacherService.selectAllPage(page, 3);

        model.addAttribute("pageInfo", pageInfo);
        return "/admin/allTeacher";

    }

    //---------- 新增教师 ---------- ---------- ----------

    //新增 教师页面展示
    @GetMapping("/addTeacher")
    public String addTeacher(Model model) {
        //System.out.println("this is addStudent");
        List<College> collegeList = collegeService.selectAll();
        model.addAttribute("collegeList",collegeList);
        return "/admin/addTeacher";
    }

    //新增 教师操作
    @PostMapping("/addTeacher2")
    public String addTeacher(TeacherCustom teacherCustom) {
        teacherService.insert(teacherCustom);
        UserLogin userLogin = new UserLogin();
        userLogin.setUserName(teacherCustom.getUserID().toString());
        userLogin.setPassword("123456");
        userLogin.setRole(1);
        userLoginService.insert(userLogin);
        return "redirect:/admin/showTeacher";
    }



    //---------- 修改教师 ---------- ---------- ----------

    //修改 教师页面展示
    @GetMapping("/updateTeacher")
    public String UpdateTeacher(Integer id, Model model) {
        TeacherCustom teacherCustom = teacherService.selectByID(id);
        model.addAttribute("teacherCustom", teacherCustom);
        List<College> collegeList = collegeService.selectAll();
        model.addAttribute("collegeList", collegeList);
        return "/admin/updateTeacher";
    }


    //修改 教师信息
    @PostMapping("/updateTeacher")
    public String UpdateTeacher(Teacher teacher) {
        //studentService.updateByID(student);
        //courseService.updateByID(course);
        teacherService.updateByID(teacher);
        return "redirect:/admin/showTeacher";
    }


    //---------- 删除教师 ---------- ----------
    //删除教师信息
    @GetMapping("/deleteTeacher")
    public String deleteTeacher(Integer id) {
        //studentService.deleteByID(id);
        //userLoginService.deleteByID(id);
        teacherService.deleteByID(id);
        userLoginService.deleteByID(id+"");
        return "redirect:/admin/showTeacher";
    }

    //===============================其他==================================

    //本账号
    //跳转到 密码修改 的页面
    @GetMapping("/passwordRest")
    public String PasswordRest() {
        return "/admin/passwordRest";
    }


    //管理员给其他用户重设密码
    //修改密码的页面展示
    @GetMapping("/userPasswordRest")
    public String userPasswordRest() {
        return "admin/userPasswordRest";
    }

    @PostMapping("/userPasswordRest")
    public String userPasswordRest(String userName, String password1) throws CustomException {
        UserLogin userLogin = userLoginService.selectByName(userName);
        if (userLogin == null) {
            throw new CustomException("没有该用户");
        } else {
            if (userLogin.getRole() == 0) {
                throw new CustomException("无法修改管理员密码");
            }
            userLogin.setPassword(password1);
            userLoginService.updateByName(userLogin);
        }

        return "redirect:/admin/showStudent";
    }





}
