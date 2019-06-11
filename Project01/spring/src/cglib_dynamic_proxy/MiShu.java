package cglib_dynamic_proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author LX
 * @date 2019/2/26 - 19:06
 */
public class MiShu implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("预约时间");

        Object invokeSuper = methodProxy.invokeSuper(o, objects);

        return invokeSuper;
    }
}
