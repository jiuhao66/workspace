package jdk_dynamic_proxy;

import java.lang.reflect.Proxy;

/**
 * @author LX
 * @date 2019/2/26 - 19:12
 */
public class WoMen {

    public static void main(String[] args) {

        MiShu miShu = new MiShu();
        // 第一个参数: 反射时使用的类加载器
        //第二个参数:proxy 需要实现 什么接口
        //第三个参数: 通过接口对象调用方法时,需要调用哪类的invoke方法
        GongNeng gongNeng = (GongNeng) Proxy.newProxyInstance(WoMen.class.getClassLoader(),new Class[]{GongNeng.class},miShu);

        gongNeng.chifan();
    }
}
