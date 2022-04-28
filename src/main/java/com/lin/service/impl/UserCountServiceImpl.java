package com.lin.service.impl;

import com.lin.dao.UserCountMapper;
import com.lin.pojo.UserCount;
import com.lin.service.UserCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserCountServiceImpl implements UserCountService {

    @Autowired
    private UserCountMapper userCountMapper;


    @Override
    public int selectCount() {
        return userCountMapper.selectCount();
    }

    @Override
    public int visitsCountIncrease(UserCount userCount) {
        int curCount = userCountMapper.selectCount();
        curCount++;
        userCount.setCount(curCount);
        return userCountMapper.updateCount(userCount);
    }
}
