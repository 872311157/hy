package com.example.hy.util.listener;

import com.example.hy.system.service.HySystemService;
import com.example.hy.util.cache.MapCacheEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * 使用 ApplicationListener 来初始化一些数据到 application 域中的监听器
 * @author
 * @date 2018/07/05
 */
@Component
public class MyServletContextListener implements ApplicationListener<ContextRefreshedEvent> {

    /**
     * 获取日志对象，构造函数传入当前类，查找日志方便定位
     */
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        checkLisence();

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

    /**
     * 检查Lisence
     */
    public void checkLisence(){
        try {
            Resource resource = new ClassPathResource("static/lic/License.lic");
            //Resource resource = new ClassPathResource("resource.properties");
            InputStream is = resource.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer dataSbr = new StringBuffer();
            String data = null;
            while((data = br.readLine()) != null) {
                dataSbr.append(data);
            }
            System.out.println(dataSbr.toString());
            MapCacheEntity.getInstance().setLisence("lisence", dataSbr);
            br.close();
            isr.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.error("几但是对方了解了");
        //退出系统
        //System.exit(0);
    }
}

