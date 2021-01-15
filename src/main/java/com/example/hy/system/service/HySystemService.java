package com.example.hy.system.service;

import com.example.hy.system.entity.HySystem;
import com.example.hy.system.mapper.HySystemMapper;
import com.example.hy.util.cache.MapCacheEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HySystemService implements IHySystemService{
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
        for (HySystem hySystem : list) {
            MapCacheEntity.getInstance().setConfig(hySystem.getSystype(), hySystem.getSysvalue());
        }
    }
}
