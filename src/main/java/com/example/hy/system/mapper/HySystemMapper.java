package com.example.hy.system.mapper;

import com.example.hy.system.entity.HySystem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HySystemMapper {
    public List<HySystem> queryAllList();
}
