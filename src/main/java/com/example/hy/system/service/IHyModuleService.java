package com.example.hy.system.service;

import com.example.hy.system.entity.HyModule;
import com.example.hy.util.base.EntityBeanSet;

import java.util.List;
import java.util.Map;

public interface IHyModuleService {

    /**
     * 分页查询
     * @param params
     * @return
     */
    public EntityBeanSet queryPageList(Map<String, Object> params);

    /**
     * 查询
     * @return
     */
    public List<HyModule> queryListByParam(Map<String, Object> params);

    /**
     * 根据角色id查询对应的模块
     * @param roleId
     * @return
     */
    public List<HyModule> queryModules(Integer roleId);
}
