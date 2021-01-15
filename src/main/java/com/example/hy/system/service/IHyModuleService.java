package com.example.hy.system.service;

import com.example.hy.system.entity.HyModule;

import java.util.List;
import java.util.Map;

public interface IHyModuleService {
    /**
     * 查询
     * @return
     */
    public List<HyModule> queryListByParam(Map<String, Object> params);

    /**
     * 根据角色id查询对应的模块
     * @param roleid
     * @return
     */
    public List<HyModule> queryModules(Integer roleid);
}
