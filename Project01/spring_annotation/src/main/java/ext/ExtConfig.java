package ext;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *    3: ApplicationListener  : 监听容器中发布的事件 ,事件驱动模型开发
 *
 *    public interface ApplicationListener<E extends ApplicationEvent>
 *        监听ApplicationEvent 以及 下面的子事件
 *
 *        步骤:
 *        1) : 写一个监听器(ApplicationListener的实现类)来监听某个事件  (ApplicationEvent及其子类)
 *        2): 把监听器加入到容器
 *        3): 只要容器中有相关的事件发布,我们就能 监听到这个事件
 *             ContextRefreshedEvent:容器刷新完成(所有Bean都完全创建)会发布这个事件
 *             ContextClosedEvent: 关闭容器会发布这个事件
 *         4): 发布一个事件:
 *            applicationContext.publishEvent();
 *
 * @author LX
 * @date 2019/5/7 - 19:12
 */
@ComponentScan("ext")
@Configuration
public class ExtConfig  {
}
