package com.lin.service.impl;

import com.lin.dao.UserLoginMapper;
import com.lin.pojo.UserLogin;
import com.lin.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLoginMapper userLoginMapper;

    public int insert(UserLogin record) {
        return userLoginMapper.insert(record);
    }

    public int deleteByID(String userID) {
        return userLoginMapper.deleteByID(userID);
    }

    public int updateByID(UserLogin record) {
        return userLoginMapper.updateByID(record);
    }

    @Override
    public int updateByName(UserLogin record) {
        return userLoginMapper.updateByName(record);
    }


    public UserLogin selectByID(Integer userID) {
        return userLoginMapper.selectByID(userID);
    }

    public List<UserLogin> selectAll() {
        return userLoginMapper.selectAll();
    }

    public UserLogin selectByName(String userName) {
        return userLoginMapper.selectByName(userName);
    }
}
