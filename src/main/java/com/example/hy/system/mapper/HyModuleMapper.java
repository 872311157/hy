package com.example.hy.system.mapper;

import com.example.hy.system.entity.HyModule;
import com.example.hy.util.base.EntityBeanSet;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface HyModuleMapper {

    /**
     * 保存
     * @param hyModule
     * @return
     */
    public Integer save(HyModule hyModule);

    /**
     * 修改
     * @param hyModule
     * @return
     */
    public Integer modify(HyModule hyModule);

    /**
     * 删除
     * @param id
     * @return
     */
    public Integer delete(Integer id);

    /**
     * 查询
     * @param id
     * @return
     */
    public HyModule query(Integer id);

    /**
     * 查询
     * @param params
     * @return
     */
    public List<HyModule> queryListByParam(Map<String, Object> params);

    /**
     * 查询角色权限模块
     * @param roleId
     * @return
     */
    public List<HyModule> queryModules(Integer roleId);

    /**
     * 分页查询
     * @param params
     * @return
     */
    public List<HyModule> queryPageList(Map<String, Object> params);

    /**
     * 查询总树
     * @param params
     * @return
     */
    public Integer queryPageCount(Map<String, Object> params);
}
