package com.lin.service.impl;

import com.lin.dao.CollegeMapper;
import com.lin.pojo.College;
import com.lin.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeMapper collegeMapper;

    @Override
    public int insert(College record) {
        return collegeMapper.insert(record);
    }

    @Override
    public int deleteByID(Integer userID) {
        return collegeMapper.deleteByID(userID);
    }

    @Override
    public int updateByID(College record) {
        return collegeMapper.updateByID(record);
    }

    @Override
    public College selectByID(Integer userID) {
        return collegeMapper.selectByID(userID);
    }

    @Override
    public List<College> selectAll() {
        return collegeMapper.selectAll();
    }
}
