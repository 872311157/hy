package com.example.hy.util.listener;

import com.example.hy.system.service.HySystemService;
import com.example.hy.util.cache.MapCacheEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.util.Map;

/**
 * 使用 ApplicationListener 来初始化一些数据到 application 域中的监听器
 * @author shengni ni
 * @date 2018/07/05
 */
@Component
public class MyServletContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // 先获取到 application 上下文
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        // 获取对应的 service
        HySystemService service = applicationContext.getBean(HySystemService.class);
        service.setDefaultConfig();
        // 获取 application 域对象，将查到的信息放到 application 域中
//        ServletContext application = applicationContext.getBean(ServletContext.class);
//        application.setAttribute("config", config);

//        ServletContext application = request.getServletContext();
//        return (User) application.getAttribute("user");

    }
}

