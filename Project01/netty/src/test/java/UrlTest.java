import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author LX
 * @date 2019/5/13 - 19:42
 */
public class UrlTest {

    public static void main(String[] args) throws IOException {

        long start =System.currentTimeMillis();

        URL url = new URL("https://www.biqukan.cc/book/45223/");

        URLConnection urlConnection = url.openConnection();

        InputStream inputStream = urlConnection.getInputStream();
        System.out.println(System.currentTimeMillis()-start);

        int len;

        byte[] b =new byte[1024];

        while ((len = inputStream.read(b))!=-1){
            System.out.println(new String(b,0,len,"GBK"));
        }

        System.out.println(System.currentTimeMillis()-start);

    }
}
