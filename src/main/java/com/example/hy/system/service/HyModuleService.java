package com.example.hy.system.service;

import com.example.hy.system.entity.HyModule;
import com.example.hy.system.mapper.HyModuleMapper;
import com.example.hy.util.base.EntityBeanSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class HyModuleService implements IHyModuleService{
    @Autowired
    private HyModuleMapper hyModuleMapper;

    @Transactional
    @Override
    public Integer save(HyModule hyModule) {
        return this.hyModuleMapper.save(hyModule);
    }

    @Override
    public Integer modify(HyModule hyModule) {
        return this.hyModuleMapper.modify(hyModule);
    }

    @Override
    public Integer delete(Integer id) {
        return this.hyModuleMapper.delete(id);
    }

    @Override
    public HyModule query(Integer id) {
        return this.hyModuleMapper.query(id);
    }

    @Override
    public EntityBeanSet queryPageList(Map<String, Object> params) {
        Integer countNum = this.hyModuleMapper.queryPageCount(params);
        Integer pageNum = (Integer) (StringUtils.isEmpty(params.get("pageNum"))?1:params.get("pageNum"));
        Integer pageSize = (Integer) (StringUtils.isEmpty(params.get("pageSize"))?10:params.get("pageSize"));
        Integer startIndex = (pageNum - 1) * pageSize;
        params.put("startIndex", startIndex);
        params.put("pageSize", pageSize);
        List<HyModule> list = this.hyModuleMapper.queryPageList(params);
        EntityBeanSet beanSet = new EntityBeanSet(pageSize, pageNum, countNum, list);
        return beanSet;
    }

    @Override
    public List<HyModule> queryListByParam(Map<String, Object> params) {
        return this.hyModuleMapper.queryListByParam(params);
    }

    @Override
    public List<HyModule> queryModules(Integer roleId) {
        return this.hyModuleMapper.queryModules(roleId);
    }
}
