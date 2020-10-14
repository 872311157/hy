package com.example.hy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
        Map<String, Object> bootUser = new HashMap<String, Object>();//this.bootUserService.login(username, password);
        bootUser.put("username", username);
        bootUser.put("password", password);

        if (null != bootUser)
        {
            model = new ModelAndView("redirect:main");//重定向主页面
            //使用session传递用户数据
            HttpSession session = request.getSession();
            session.setAttribute("user",bootUser);
        }else {
            model.setViewName("redirect:error");
        }
        return model;
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

