package com.example.hy.system.service;

import com.example.hy.system.entity.HySystem;
import com.example.hy.system.mapper.HySystemMapper;
import com.example.hy.util.cache.MapCacheEntity;
import com.example.hy.util.redis.HyRedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HySystemService implements IHySystemService{

    @Autowired
    private HyRedisTemplate hyRedisUtils;
    @Autowired
    private HySystemMapper hySystemMapper;

    @Override
    public Map<String, Object> queryAllConfig() {
        Map<String, Object> sysmap = new HashMap<String, Object>();
        List<HySystem> list = this.hySystemMapper.queryAllList();
        for (HySystem hySystem : list){
            sysmap.put(hySystem.getSystype(), hySystem.getSysvalue());
        }
        return sysmap;
    }

    @Override
    public void setDefaultConfig() {
        List<HySystem> list = this.hySystemMapper.queryAllList();
        Map<String, Object> defaultMap = new HashMap<String, Object>();
        for (HySystem hySystem : list) {
            String key = hySystem.getSystype();
            String value = hySystem.getSysvalue();
            defaultMap.put(key, value);
        }
        this.hyRedisUtils.hmset("systemConfig", defaultMap);
    }
}
