package enrypt;

import md5.SecurityUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author LX
 * @date 2019/3/17 - 8:40
 */
public class DES {

    /**
     * des 加密
     * @param text
     * @param originKey
     * @return
     */
    public static String desEncript(String text , String originKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        //获得加密算法工具类对象
        Cipher cipher = Cipher.getInstance("DES");

        SecretKeySpec key = getKey(originKey);

        // 对加密工具类对象 进行初始化
        //mode: 加密/解密 模式
        // key  对原始密钥处理之后的密钥

        cipher.init(Cipher.ENCRYPT_MODE,key);

        byte[] bytes = cipher.doFinal(text.getBytes());

        String encode = SecurityUtil.base64Encode(bytes);

        return encode;
    }

    public static String desDecript(String text , String originKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        //获得加密算法工具类对象
        Cipher cipher = Cipher.getInstance("DES");

        SecretKeySpec key = getKey(originKey);

        // 对加密工具类对象 进行初始化
        //mode: 加密/解密 模式
        // key  对原始密钥处理之后的密钥

        cipher.init(Cipher.DECRYPT_MODE,key);

        byte[] encode = SecurityUtil.base64Decode(text);

        byte[] bytes = cipher.doFinal(encode);

        return new String(bytes);
    }

    public static SecretKeySpec getKey(String originKey) {

        byte [] bytes = new byte[8];

        byte[] bytes1 = originKey.getBytes();

        int length = bytes1.length;

        for (int i = 0;i<8 && i<length;i++){

            bytes[i] = bytes1[i];
        }
        //根据给定的 字节数组 构造一个密钥
        return new SecretKeySpec(bytes,"DES");
    }

    public static void main(String[] args) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {

        // 密钥
        String key ="123";

        //明文
        String text = "你好哈弗哈弗的萨达";

        String desEncript = desEncript(text, key);

        System.out.println(desEncript);

        String desDecript = desDecript(desEncript, key);

        System.out.println(desDecript);
    }
}
