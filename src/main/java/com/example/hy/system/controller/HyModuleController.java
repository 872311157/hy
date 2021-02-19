package com.example.hy.system.controller;

import com.alibaba.fastjson.JSON;
import com.example.hy.base.controller.BaseController;
import com.example.hy.system.entity.HyModule;
import com.example.hy.system.entity.HyUser;
import com.example.hy.system.service.IHyModuleService;
import com.example.hy.util.base.EntityBeanSet;
import com.example.hy.util.base.EntityResult;
import com.example.hy.util.redis.HyRedisTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.parser.Entity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/hyModule")
public class HyModuleController extends BaseController{

    @Autowired
    private HyRedisTemplate hyRedisUtils;
    @Autowired
    private IHyModuleService hyModuleService;

    /**
     * 获取日志对象，构造函数传入当前类，查找日志方便定位
     */
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("")
    public String page(){
        return "system/hyModule/hyModule_list";
    }

    @RequestMapping("save")
    @ResponseBody
    public EntityResult save(HttpServletRequest request){
        try {
            String	mName = ServletRequestUtils.getStringParameter(request, "mName");//模块名称
            String	mAddress = ServletRequestUtils.getStringParameter(request, "mAddress");//模块地址
            Integer	parentId = ServletRequestUtils.getIntParameter(request, "parentId");//父模块id
            Integer	mType = ServletRequestUtils.getIntParameter(request, "mType");//模块类型0分类，1引用
            String	imgUrl = ServletRequestUtils.getStringParameter(request, "imgUrl");//图标地址
            HyModule hyModule = new HyModule();
            hyModule.setCreateTime(new Date());//创建时间
            hyModule.setmName(mName);
            hyModule.setmAddress(mAddress);
            hyModule.setmType(mType);
            hyModule.setImgUrl(imgUrl);
            Integer index = this.hyModuleService.save(hyModule);
            if(index > 0){
                return EntityResult.SUCCESS();
            }else{
                return EntityResult.ERROR();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return EntityResult.ERROR();
        }
    }

    @RequestMapping("modify")
    @ResponseBody
    public EntityResult modify(HttpServletRequest request){
        try {
            Integer id = ServletRequestUtils.getIntParameter(request, "id");//模块名称
            String	mName = ServletRequestUtils.getStringParameter(request, "mName");//模块名称
            String	mAddress = ServletRequestUtils.getStringParameter(request, "mAddress");//模块地址
            Integer	parentId = ServletRequestUtils.getIntParameter(request, "parentId", -1);//父模块id
            Integer	mType = ServletRequestUtils.getIntParameter(request, "mType");//模块类型0分类，1引用
            String	imgUrl = ServletRequestUtils.getStringParameter(request, "imgUrl");//图标地址
            HyModule hyModule = new HyModule();
            hyModule.setId(id);
            hyModule.setmName(mName);
            hyModule.setmAddress(mAddress);
            hyModule.setmType(mType);
            hyModule.setImgUrl(imgUrl);
            Integer index = this.hyModuleService.modify(hyModule);
            if(index > 0){
                return EntityResult.SUCCESS();
            }else{
                return EntityResult.ERROR();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return EntityResult.ERROR();
        }
    }

    @RequestMapping("delete")
    @ResponseBody
    public EntityResult delete(@RequestParam Integer id){
        try {
            Integer index = this.hyModuleService.delete(id);
            if(index > 0){
                return EntityResult.SUCCESS();
            }else{
                return EntityResult.ERROR();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return EntityResult.ERROR();
        }
    }

    @RequestMapping("query")
    @ResponseBody
    public HyModule query(@RequestParam Integer id){
        HyModule hyModule = new HyModule();
        try {
            hyModule = this.hyModuleService.query(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hyModule;
    }

    @RequestMapping("queryPageList")
    @ResponseBody
    public EntityBeanSet queryPageList(HttpServletRequest request){
        EntityBeanSet entityBeanSet = null;
        try {
            Integer pageNum = ServletRequestUtils.getIntParameter(request, "pageNum");
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize");
            String mName = ServletRequestUtils.getStringParameter(request, "mName");
            Integer mType = ServletRequestUtils.getIntParameter(request, "mType");
            Map<String, Object> par = new HashMap<String, Object>();
            par.put("pageNum", pageNum);
            par.put("pageSize", pageSize);
            par.put("mName", mName);
            par.put("mType", mType);
            entityBeanSet = this.hyModuleService.queryPageList(par);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entityBeanSet;
    }

    /**
     * 获取当前登录用户权限
     * @param params
     * @return
     */
    @RequestMapping("queryModules")
    @ResponseBody
    public List<HyModule> queryModules(@RequestParam Map<String, String> params){
        List<HyModule> modules = null;
        String userid = params.get("userid");

        HyUser hyUser = this.getCurrentUser();
        System.out.println(JSON.toJSONString(hyUser));

        if(!StringUtils.isEmpty(userid)){
            String roleId = this.hyRedisUtils.get(userid);
            if(!StringUtils.isEmpty(roleId)){
                modules = this.hyModuleService.queryModules(Integer.parseInt(roleId));
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
            if(module.getmType() == 0){
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("parentId", module.getId());
                List<HyModule> childMs = this.hyModuleService.queryListByParam(params);
                module.setChildMs(childMs);
                this.queryChildModule(childMs);
            }
        }
    }
}