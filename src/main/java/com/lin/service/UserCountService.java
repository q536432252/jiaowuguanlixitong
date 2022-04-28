package com.lin.service;

import com.lin.pojo.UserCount;

public interface UserCountService {
    //查找当前的count
    int selectCount();
    //访问次数+1 count
    int visitsCountIncrease(UserCount userCount);
}