package enrypt;

/**
 * @author LX
 * @date 2019/3/16 - 16:57
 */
public class CaesarDemo {

    public static void main(String[] args) {

        //明文: 原始信息

        String clearText = "heima";

        int key = 3;

        String encypt = encypt(clearText, key);

        System.out.println(encypt);

        encypt = encypt(encypt, key-6);

        System.out.println(encypt);


    }

    public static String encypt(String text ,int key){

        char[] chars = text.toCharArray();

        for(int i = 0; i<chars.length;i++){

            chars[i] = (char)(chars[i]+key);
        }
        
        return new String(chars);
    }

}
