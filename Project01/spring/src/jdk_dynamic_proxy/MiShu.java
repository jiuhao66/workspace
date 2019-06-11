package jdk_dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author LX
 * @date 2019/2/26 - 19:06
 */
public class MiShu implements InvocationHandler {

    private LaoZong laoZong = new LaoZong();
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("预约时间");

        Object invoke = method.invoke(laoZong, args);

        return invoke;
    }
}
