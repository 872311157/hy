package com.example.hy.util.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 系统缓存
 */
public class MapCacheEntity {
    private Map<String, Object> cacheMap;
    private Map<String, Object> configMap;

    private MapCacheEntity() {}
    private static MapCacheEntity instance=null;
    //静态工厂方法
    public static MapCacheEntity getInstance() {
        if (instance == null) {
            instance = new MapCacheEntity();
        }
        return instance;
    }

    public Object get(String key){
        if(null != this.cacheMap){
            return this.cacheMap.get(key);
        }else{
            return null;
        }
    }

    public void set(String key, Object value){
        if (null == this.cacheMap){
            this.cacheMap = new ConcurrentHashMap<String, Object>();
        }
        this.cacheMap.put(key, value);
    }

    public Object getConfig(String key){
        if(null != this.configMap){
            return this.configMap.get(key);
        }else{
            return null;
        }
    }

    public void setConfig(String key, Object value){
        if (null == this.configMap){
            this.configMap = new ConcurrentHashMap<String, Object>();
        }
        this.configMap.put(key, value);
    }

    public Map<String, Object> getConfigMap() {
        return configMap;
    }

    public void setConfigMap(Map<String, Object> configMap) {
        this.configMap = configMap;
    }
}
