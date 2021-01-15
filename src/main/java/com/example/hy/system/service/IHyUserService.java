package com.example.hy.system.service;

import com.example.hy.system.entity.HyUser;

public interface IHyUserService {
    public HyUser login(String username, String passwords);
}
