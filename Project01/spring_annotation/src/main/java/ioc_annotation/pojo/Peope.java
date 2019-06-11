package ioc_annotation.pojo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author LX
 * @date 2019/3/17 - 20:27
 */
@Component
public class Peope implements InitializingBean ,DisposableBean {

    @Override
    public void destroy() throws Exception {

        System.out.println("peope destroy ...");

    }

    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println(" peope  init ....");
    }
}
