package com.lin.dao;

import com.lin.pojo.UserCount;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCountMapper {

    @Select("select count(*) from userlogin")
    int selectCount();

    @Update("update userlogin set Count = #{Count}")
    int updateCount(UserCount userCount);

}
