package com.lin.dao;

import com.lin.pojo.College;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface CollegeMapper {
    //增
    int insert(College record);
    //删
    int deleteByID(Integer userID);
    //改
    int updateByID(College record);
    //查询一个
    College selectByID(Integer userID);

    //查询全部
    @Select("select * from college")
    List<College> selectAll();
}
