package cglib_dynamic_proxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author LX
 * @date 2019/2/26 - 19:12
 */
public class WoMen {

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(LaoZong.class);

        enhancer.setCallback(new MiShu());

        LaoZong laoZong = (LaoZong) enhancer.create();

        laoZong.chifan();

    }
}
