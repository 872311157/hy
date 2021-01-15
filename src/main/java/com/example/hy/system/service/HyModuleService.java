package com.example.hy.system.service;

import com.example.hy.system.entity.HyModule;
import com.example.hy.system.mapper.HyModuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HyModuleService implements IHyModuleService{
    @Autowired
    private HyModuleMapper hyModuleMapper;

    @Override
    public List<HyModule> queryListByParam(Map<String, Object> params) {
        return this.hyModuleMapper.queryListByParam(params);
    }

    @Override
    public List<HyModule> queryModules(Integer roleid) {
        return this.hyModuleMapper.queryModules(roleid);
    }
}
