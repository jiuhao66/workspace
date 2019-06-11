package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author LX
 * @date 2019/3/15 - 20:36
 */
public class FieldTest {

    /**
     * 将 object 的所有 属性值 保存到map中
     * @param object
     * @param map
     */
    public static void asMap(Object object , Map<String ,Object> map) throws IllegalAccessException {

        Field[] declaredFields = object.getClass().getDeclaredFields();

        for (int i = 0; i < declaredFields.length; i++) {

                declaredFields[i].setAccessible(true);

                map.put(declaredFields[i].getName(),declaredFields[i].get(object));
        }
    }

    /**
     * 将map 转化为 bean
     * @param map
     * @param object
     */
    public static void asBean(Map<String,Object>map,Object object){

        Class<?> cls = object.getClass();

        Set<Map.Entry<String, Object>> entries = map.entrySet();
        
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();

        while(iterator.hasNext()){

            Map.Entry<String, Object> next = iterator.next();

            Object value = next.getValue();
        }
    }

    /**
     * 返回指定 名称的属性
     * @param cls
     * @param fieldName
     * @return
     */
    public static Field getField(Class<?>cls,String fieldName){

            while (cls !=null){

                Field field = null;

                try {

                    field = cls.getDeclaredField(fieldName);

                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }

                if (field==null){

                    cls = cls.getSuperclass();
                }else{

                    return field;
                }
            }
        return null;
    }

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

       /* Object b = new B();

        Field age = getField(B.class, "age");

        Field email = getField(B.class, "email");

        *//**
         * 方式一 : 直接使用属性对象赋值
         *//*
        age.set(b,20);

        email.setAccessible(true);

        email.set(b,"123@qq.com");

        */
        /**
         * 方法二:   老老实实使用 设值方法设值
         */
        /*

        Method method = B.class.getMethod("email", String.class);

        method.invoke(b,"466@qq.com");

        System.out.println(b);*/

        Map<String,Object>map = new HashMap<>();

        B b = new B();

        b.age=10;

        b.name="li";

        asMap(b,map);

        System.out.println(map.toString());
    }
}
