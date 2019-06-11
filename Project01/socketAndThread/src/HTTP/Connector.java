package HTTP;

import java.io.IOException;
import java.net.Socket;

/**
 * @author LX
 * @date 2019/1/3 - 20:04
 */
public class Connector extends Thread {

    private Socket client;

    private HttpServletRequest request;

    private HttpServletResponse response;


   public Connector(Socket client) throws IOException {

       this.client = client;

       request = new HttpServletRequest(client.getInputStream());

       response = new HttpServletResponse(client.getOutputStream() , request);

       //System.out.println(request.getParametersValues("name").length);

      /* if(request.getSerletPath().indexOf("new") > 0 ){

           response.sendRedirect("404.html");

       }*/
       process();
       client.close();

   }

   private void process() throws IOException {
       //判断 当前的 请求是 动态请求还是 静态请求

       if(isDynamicResource(request)){

           HttpServlet httpServlet = Tomcat.getHttpServlet( request.getSerletPath()) ;

           httpServlet.service(request,response);

           response.setStatus(200,"OK");

           response.flushBuffer();

       }else{
//        如果是静态请求 直接返回结果
           response.setStatus(200,"OK");

           // 推送数据给浏览器
           response.flushBuffer();

       }

   }

    private boolean isDynamicResource(HttpServletRequest request) {

        return Tomcat.getHttpServlet(request.getSerletPath()) != null  ;
    }
}
