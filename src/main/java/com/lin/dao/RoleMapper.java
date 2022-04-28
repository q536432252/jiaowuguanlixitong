package com.lin.dao;

import com.lin.pojo.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {
    //增
    int insert(Role record);
    //删
    int deleteByID(Integer userID);
    //改
    int updateByID(Role record);

    //查询一个
    @Select("select roleID, roleName, permissions from role where roleID = #{userID}")
    Role selectByID(@Param("userID") Integer userID);

    //查询全部
    List<Role> selectAll();
}
