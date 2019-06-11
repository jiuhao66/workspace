package reflect.Test;

import java.lang.reflect.Field;

/**
 * @author LX
 * @date 2019/3/16 - 21:29
 */
public class Test2 {

    /**
     *    传过来一个类  直接通过  传过来的名称   来获得 相应的取值
     *
     *
     * @param o
     * @param name
     * @return
     */
    public static String getValue(Object o , String name) throws NoSuchFieldException {

        String[] split = name.split("\\.");

        for (String t: split) {

            Class<?> cls = o.getClass();

            Field field = cls.getDeclaredField(t);

        }


        return null;
    }

    public static void main(String[] args) {

    }

}
