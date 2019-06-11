package ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author LX
 * @date 2019/5/7 - 19:21
 */
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {


    /**
     * 当容器中发布此事件以后  方法触发
     *
     *
     * @param event
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {

        System.out.println("收到事件: "+event);
    }
}
