package com.example.hy.system.service;

import com.example.hy.system.entity.HyRole;
import com.example.hy.system.mapper.HyRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HyRoleService implements IHyRoleService{

    @Autowired
    private HyRoleMapper hyRoleMapper;

    @Override
    public List<HyRole> queryByParams(Map<String, Object> params) {
        return this.hyRoleMapper.queryByParams(params);
    }

    @Override
    public Integer queryRoleidByUserid(Integer userid) {
        return this.hyRoleMapper.queryRoleidByUserid(userid);
    }
}
