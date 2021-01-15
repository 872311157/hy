package com.example.hy.system.service;

import com.example.hy.system.entity.HySystem;

import java.util.List;
import java.util.Map;

public interface IHySystemService {
    public Map<String, Object> queryAllConfig();
    public void setDefaultConfig();
}
