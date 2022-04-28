package com.lin.dao;

import com.lin.pojo.UserLogin;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //注明是Dao组件  和 @Controller作用一样
public interface UserLoginMapper {
    //增
    @Insert("insert into userlogin (userID,userName,password,role) values (#{userID},#{userName},#{password},#{role})")
    int insert(UserLogin record);

    //删
    @Delete("delete from userlogin where userName = #{userID}")
    int deleteByID(String userID);


    //改
    int updateByID(UserLogin record);

    @Update("update userlogin set password = #{password} where userName = #{userName}")
    int updateByName(UserLogin record);

    //查询一个
    UserLogin selectByID(Integer userID);
    //查询全部
    List<UserLogin> selectAll();

    //@Select注解 相当于在xml文件下sql语句
    @Select("select userID, userName, password, role from userlogin where userName = #{userName}")
    UserLogin selectByName(@Param("userName") String userName);
}
