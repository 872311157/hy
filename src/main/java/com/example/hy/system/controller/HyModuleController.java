package com.example.hy.system.controller;

import com.example.hy.system.entity.HyModule;
import com.example.hy.system.service.IHyModuleService;
import com.example.hy.util.cache.MapCacheEntity;
import com.example.hy.util.redis.HyRedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/hymodule")
public class HyModuleController {

    @Autowired
    private HyRedisUtils hyRedisUtils;
    @Autowired
    private IHyModuleService hyModuleService;

    /**
     * 获取日志对象，构造函数传入当前类，查找日志方便定位
     */
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("")
    public String page(){
        return "system/hymodule/hymodule_list";
    }

    @RequestMapping("queryModules")
    @ResponseBody
    public List<HyModule> queryModules(@RequestParam Map<String, String> params){
        List<HyModule> modules = null;
        String userid = params.get("userid");
        if(!StringUtils.isEmpty(userid)){
            String roleid = this.hyRedisUtils.get(userid);
            if(!StringUtils.isEmpty(roleid)){
                modules = this.hyModuleService.queryModules(Integer.parseInt(roleid));
                if(null != modules && modules.size() > 0){
                    this.queryChildModule(modules);
                }
            }
        }
        return modules;
    }

    /**
     * 递归查询菜单下的所有子菜单
     * @param modules
     * @return
     */
    public void queryChildModule(List<HyModule> modules){
        for(HyModule module : modules){
            if(module.getMtype() == 0){
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("parentid", module.getId());
                List<HyModule> childs = this.hyModuleService.queryListByParam(params);
                module.setChilds(childs);
                this.queryChildModule(childs);
            }
        }
    }
}