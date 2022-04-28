package com.lin.service;

import com.github.pagehelper.PageInfo;
import com.lin.pojo.Student;
import com.lin.pojo.StudentCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    /*
    service层里面为什么要建立一个接口，一个实现类?
    分别定义接口和实现类是java架构思想中开闭原则的体现，对扩展开放，对修改关闭。
    举个例子：
    1、便于扩展
    假如是一个注册程序，你这个注册刚开始是对国内用户开放，中国用户注册成功返回“注册成功”，
    随着业务扩展，需要海外用户开放，假如美国用户返回“register success”，
    如果你有接口，可以再美国的AmericaUserServiceImpl.java中实现一个UserService.java的接口，来定义美国用户的注册业务，
    而不是在之前ChineseUserServiceImpl.java中增加if else来对不同逻辑进行处理，
    这样，后续如果某个地区的注册业务有变动，只需要修改对应地区的实现类，修改不会影响到其他地区的实现类，降低了耦合性。
    2、可以分工合作
    多人分层合作，有人负责 Controller 层，有人负责 Service 层，有人负责 DAO 层，
    大家可以先定义好接口然后就开始各写各的代码了，互不影响。
     */

    //增
    int insert (Student record);
    //删
    int deleteByID(Integer userID);
    //改
    int updateByID (StudentCustom record);
    //查询一个
    StudentCustom selectByID(Integer userID);

    //StudentCustom selectByName(String name);
    List<StudentCustom> selectByName(String name);

    //查询已修（已打分）的课程
    List<StudentCustom> selectOverCourseByName(String name);


    //查询全部
    List<Student> selectAll();

    //分页查询
    PageInfo<StudentCustom> selectAllPage(Integer pageNum, Integer pageSize);


    //创建好service接口之后，光标放在类名，ALT+回车实现
    //在实现类类名上添加@Service注解
    //实现类中：service业务层需要调用dao层，所以要把dao层放进来
        //private XxxMapper xxxMapper;
        //1、set方法
        //2、@Autowired
    //实现类中：service业务层还可以增加一些其他的操作，例如判断，事务等等
}
