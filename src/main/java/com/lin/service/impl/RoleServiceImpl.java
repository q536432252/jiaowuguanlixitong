package com.lin.service.impl;

import com.lin.dao.RoleMapper;
import com.lin.pojo.Role;
import com.lin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role selectByID(Integer id) {
        return roleMapper.selectByID(id);
    }
}
