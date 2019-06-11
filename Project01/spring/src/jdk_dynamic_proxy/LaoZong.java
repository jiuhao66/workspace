package jdk_dynamic_proxy;

/**
 * @author LX
 * @date 2019/2/25 - 21:14
 */
public class LaoZong implements GongNeng {

    @Override
    public void chifan() {

        System.out.println("吃饭");
    }

    @Override
    public void mubiao() {

        System.out.println("目标");

    }
}
