package com.example.hy.system.controller;

import com.example.hy.system.entity.HyUser;
import com.example.hy.system.service.IHyRoleService;
import com.example.hy.system.service.IHyUserService;
import com.example.hy.util.cache.MapCacheEntity;
import com.example.hy.util.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author hanlulu
 * 登录方法
 */
@Controller
@RequestMapping("/login")
public class LoginContoller {

    @Autowired
    private IHyUserService hyUserService;
    @Autowired
    private IHyRoleService hyRoleService;
    @Autowired
    private RedisUtil redisUtil;


    @RequestMapping("")
    public String index() {
        return "login";
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping("/submit")
    public ModelAndView submit(@RequestParam Map<String, String> user, ModelAndView model, HttpServletRequest request) {
        String username = user.get("username");
        String password = user.get("password");
        System.out.println(username + "--" + password);
        HyUser hyUser = this.hyUserService.login(username, password);
        if (null != hyUser)
        {
            model = new ModelAndView("redirect:main");//重定向主页面
            //缓存
            Integer roleid = this.hyRoleService.queryRoleidByUserid(hyUser.getId());
            MapCacheEntity.getInstance().setCache(hyUser.getId().toString(), roleid);
            //使用session传递用户数据
            HttpSession session = request.getSession();
            session.setAttribute("user",hyUser);
            //使用redis
//            redisUtil.set("foo", "123456");
//            String value = redisUtil.get("foo");
//            System.out.println(value);
        }else {
            model.setViewName("redirect:error");
        }
        return model;
    }

    @ResponseBody
    @RequestMapping("/defaultconfig")
    public Map<String, Object> getDefaultSystem(){
        return MapCacheEntity.getInstance().getConfigMap();
    }

    /**
     * @Author hanlulu
     * @Description 重定向主页面
     * @Date  2020-9-24
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    /**
     * 注册
     * @return
     */
//    @RequestMapping("/regist")
//    @ResponseBody
//    public ResultEntity<UserInfo> regist(@RequestParam Map<String, String> user) {
//        ResultEntity<UserInfo> results = ResultEntity.SUCCESS_RESULT;
//        String username = user.get("username");
//        String password = user.get("password");
//        String email = user.get("email");
//
//        System.out.println(this.configProperties.getClassName());
//
//        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || StringUtils.isEmpty(email))
//        {
//            results = ResultEntity.ERROR_RESULT;
//        }else{
//            BootUser bootUser = new BootUser();
//            bootUser.setUsername(username);
//            bootUser.setPasswords(password);
//            bootUser.setEmail(email);
//            this.bootUserService.insert(bootUser);
//        }
//        return results;
//    }
}

