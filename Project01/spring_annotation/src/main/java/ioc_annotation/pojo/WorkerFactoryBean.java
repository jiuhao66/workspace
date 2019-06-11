package ioc_annotation.pojo;

import org.springframework.beans.factory.FactoryBean;

/**
 * 创建一个 spring定义的 FactoryBean
 * @author LX
 * @date 2019/3/17 - 19:44
 */
public class WorkerFactoryBean implements FactoryBean {


    /**
     * 返回对象 ,把这个对象添加到 容器中
     *
     * @return
     * @throws Exception
     */
    @Override
    public Object getObject() throws Exception {

        return new Worker();
    }

    /**
     * 返回对象 ,把这个对象添加到 容器中
     * @return
     */
    @Override
    public Class<?> getObjectType() {

        return Worker.class;
    }

    // 是不是单例   返回 true 是 单实例
    @Override
    public boolean isSingleton() {

        return true;
    }
}
