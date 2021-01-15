package com.example.hy.system.service;

import com.example.hy.system.entity.HyUser;
import com.example.hy.system.mapper.HyUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HyUserService implements IHyUserService{

    @Autowired
    private HyUserMapper hyUserMapper;

    @Override
    public HyUser login(String username, String passwords) {
        return hyUserMapper.login(username, passwords);
    }
}
