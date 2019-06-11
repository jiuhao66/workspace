package md5;

import org.apache.commons.codec.digest.DigestUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author LX
 * @date 2019/3/16 - 14:24
 */
public class SecurityUtil {

    /**
     * 通过 异或 加密
     * @param input
     * @return
     */
    public static String xor(String input){

        char[] chars = input.toCharArray();

        for (int i = 0 ; i<chars.length; i++){

            chars[i] = (char)(chars[i]^30);
        }

        return new String (chars);
    }

    /**
     * md5  加密
     * @param bytes
     * @return
     */
    public static String md5( byte [] bytes){

        return DigestUtils.md5Hex(bytes);

    }

    /**
     * sha256 加密     比 md5 加密 更加 安全  但是速度比 md5 加密 速度慢
     * @param bytes
     * @return
     */
    public static String sha256Encode(byte [] bytes){

       return  DigestUtils.sha256Hex(bytes);
    }

    /**
     * base64 加密
     * @param bytes
     * @return
     */
    public static String base64Encode(byte []bytes){

        String result = null ;

        try {
            Class<?> cls = Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");

            Method decode = cls.getMethod("encode", byte[].class);

            result = (String) decode.invoke(null, bytes);

        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (NoSuchMethodException e) {

            e.printStackTrace();
        } catch (IllegalAccessException e) {

            e.printStackTrace();
        } catch (InvocationTargetException e) {

            e.printStackTrace();
        }

        return result;
    }

    /**
     * base64 解密
     * @param code
     * @return
     */
    public static byte[] base64Decode(String code){

        byte [] result = null;

        try {
            Class<?> cls = Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");

            Method decode = cls.getMethod("decode", String.class);

            result = (byte[]) decode.invoke(null, code);

        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (NoSuchMethodException e) {

            e.printStackTrace();
        } catch (IllegalAccessException e) {

            e.printStackTrace();
        } catch (InvocationTargetException e) {

            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) {

        String a = "hello";

        String s = base64Encode(a.getBytes());

        System.out.println(s);

        byte[] bytes = base64Decode(s);

        System.out.println(new String(bytes));
    }


}
