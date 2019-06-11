package bean_annotation_test;

import ext.ExtConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.EventListener;

/**
 * @author LX
 * @date 2019/5/7 - 19:23
 */
public class ExtTest {

    @Test
    public void extTest(){

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ExtConfig.class);

        ac.publishEvent(new EventListener() {

        });
        ac.close();


    }
}
