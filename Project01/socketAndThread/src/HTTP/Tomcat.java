package HTTP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * @author LX
 * @date 2019/1/3 - 20:03
 */
public class Tomcat {

    private static HashMap<String ,HttpServlet> servletHashMap = new HashMap<String , HttpServlet>();

    public static void main(String[] args) throws IOException {

        ServerSocket server=new ServerSocket(8080);

        while(true) {

            System.out.println("等待客户端连接           ");

            init();

            Socket socket = server.accept();

            new Connector(socket).start();

        }
    }


    public  static  HttpServlet getHttpServlet(String path ){

        return servletHashMap.get(path);
    }

    public  static void init(){

        servletHashMap.put("/hello.s" ,new HelloServlet() );

        servletHashMap.put("/index.s" ,new IndexServlet());

    }
}
