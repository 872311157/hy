package com.example.hy.system.service;

import com.example.hy.system.entity.HyRole;

import java.util.List;
import java.util.Map;

public interface IHyRoleService {
    public List<HyRole> queryByParams(Map<String, Object> params);
    public Integer queryRoleidByUserid(Integer userid);
}
