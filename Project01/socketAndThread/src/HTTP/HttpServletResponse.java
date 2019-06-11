package HTTP;

import java.io.*;

/**
 * @author LX
 * @date 2019/1/3 - 20:05
 */
public class HttpServletResponse {

    private static final String WEB_CONIENT_PATH ="D:\\YC-培训文件接收柜\\HTTP\\photo\\photo";

    private int status ;

    private OutputStream out ;

    private HttpServletRequest request;

    private String message;


    public HttpServletResponse(OutputStream out , HttpServletRequest request) {

          this.request=request;

          this.out=out;


    }

    /**
     * 设置响应码
     * @param status
     * @param message
     */
    public void setStatus(int status , String message){

        this.status=status;

        this.message=message;

    }

    public  void flushBuffer() throws IOException {

        out.write(("HTTP/1.1 "+status+" "+message+"\r\n").getBytes());

        String path = request.getSerletPath();

        String contentType = getContentType(path);

        out.write(("Content-Type: "+contentType+";charset=utf-8\r\n").getBytes());

        out.write("\r\n".getBytes());


//      判断 用户在servlet 里面 是否 使用了   writer 功能
        String bufferedStr = this.getBufferedString();
        if(bufferedStr != null && bufferedStr.length() > 0 ){

            out.write(bufferedStr.getBytes());

        }else{

            FileInputStream fs = null ;

            path = WEB_CONIENT_PATH + path ;

            File file = new File(path);

            if( ! file.exists() ){
                path =  WEB_CONIENT_PATH + "/404.html" ;
            }

            fs=new FileInputStream(path);

            int len ;

            byte [ ] b = new byte[1024] ;

            while ( ( len = fs.read(b) ) > 0 ){

                out.write(b,0,len);
            }

            fs.close();

        }


    }

    /**
     * 重定向功能
     * @param path
     */
    public void sendRedirect(String path ) throws IOException {

        out.write("HTTP/1.1 302 redirect\r\n".getBytes());

        out.write( ("Location: "+path+"").getBytes());
      //  String contentType = getContentType( path );

       // out.write(("Content-Type: "+contentType+"\r\n").getBytes());
        out.write("\r\n".getBytes());

    }


    public  String getContentType(String path){

        if(path.indexOf(".js") > 0 ){

            return  "application/x-javascript" ;

        }else if(path.indexOf(".css")>0){

            return "text/css";

        }else{

            return "text/html;charset=utf-8";

        }

    }

    private StringWriter sw= new StringWriter() ;
    private PrintWriter pw = new PrintWriter(sw);

    public PrintWriter getWriter(){
        return pw;
    }

    public String getBufferedString(){
        return  sw.toString();
    }
}
