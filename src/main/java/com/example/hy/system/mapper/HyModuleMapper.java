package com.example.hy.system.mapper;

import com.example.hy.system.entity.HyModule;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface HyModuleMapper {
    /**
     * 查询
     * @param params
     * @return
     */
    public List<HyModule> queryListByParam(Map<String, Object> params);

    public List<HyModule> queryModules(Integer roleid);
}
