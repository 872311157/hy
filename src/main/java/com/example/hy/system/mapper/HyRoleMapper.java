package com.example.hy.system.mapper;

import com.example.hy.system.entity.HyRole;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface HyRoleMapper {
    public List<HyRole> queryByParams(Map<String, Object> params);
    public Integer queryRoleidByUserid(Integer userid);
}
