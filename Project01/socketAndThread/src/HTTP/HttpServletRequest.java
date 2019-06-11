package HTTP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author LX
 * @date 2019/1/3 - 20:05
 */
public class HttpServletRequest {

    private BufferedReader reader;
    private String method;
    private String serletPath;
    private String protocol;
    private HashMap<String , List<String >> parameterMap = new HashMap<String , List<String> >();
    private HashMap<String,String> headerMap = new HashMap<String,String>();
    private String bobyStr;


    public HttpServletRequest(InputStream in) throws IOException {

          bobyStr="";
          this.reader =new BufferedReader(new InputStreamReader(in,"utf-8"));

          String line ;

          int rowState =0 ;

          while (true){

              if(rowState == 2){

                  int len = Integer.parseInt(headerMap.get("Content-Length"));

                  char [] boby = new char[len];

                  reader.read(boby,0,len);

                  line = new String(boby, 0 , len );

                  bobyStr=line;

                  break;
              }else{
                  line = reader.readLine();
              }


              switch (rowState){

                  case 0:
                      /**
                       *   解析头行
                       */
                      rowState=1;
                      String items [] = line.split("\\s");
                      method = items[0];
                      serletPath = items[1];
                      protocol = items[2];
                      break;

                  case 1:
                      /**
                       *   解析头区
                       */

                      if( ! line.isEmpty() ){

                          items = line.split(": ");

                          headerMap.put(items[0],items[1]);

                          continue;
                      }
                      rowState = 2;

                      break;

                  case 2:
                      /**
                       *   boby 区
                       */

                  break;

              }
              if( reader.ready() == false){

                  break;
              }
          }
          initParameter();

    }

    /**
     * 请求方法
     * @return
     */
    public String getMethod() {
        return method;
    }

    /**
     *  请求路径
     * @return
     */
    public String getSerletPath(){
        return serletPath;
    }

    /**
     * 请求协议
     * @return
     */
    public String getProtocol(){
        return protocol;
    }

    /**
     * 请求头  信息
     * @param key
     * @return
     */
    public String getHeader(String key){

        return headerMap.get(key);
    }

    /**
     * 加载  参数
     */
    public void initParameter(){

        String path =this.serletPath;

        int index = path.indexOf("?");

        //&& (index + 1 ) < path.length()
        if(index > 0 ){
            //有参数
            String parameterLine =path.substring( index + 1 );

            jiexi(parameterLine);
        }

        if("POST".equalsIgnoreCase(this.method)){
            // post 方法
            jiexi(bobyStr);

        }
    }

    /**
     *  get请求参数
     * @param key
     * @return
     */
    public String getParameter(String key){

            if(parameterMap.get(key)!=null ){
                  return parameterMap.get(key).get(0);
            }
           // return parameterMap.get(key)==null?null :parameterMap.get(key).get(0);
        return null ;
    }

    public void jiexi(String parameterLine) {

            String[] parameter = parameterLine.split("&");

            for (int i = 0; i < parameter.length; i++) {

                String tParameter[] = parameter[i].split("=");

                ArrayList<String> arrayList = new ArrayList<String>();

                arrayList.add(tParameter[1]);

                parameterMap.put(tParameter[0], arrayList);

                parameterMap.get(tParameter[0]).add(tParameter[1]);
            }
    }

    public String[] getParametersValues(String key ){

        if(parameterMap.get(key)!=null ) {

            return  parameterMap.get(key).toArray(new String[parameterMap.get(key).size()]);

        }else{
            return null;
        }
    }

    //req.getRequestDispatcher("showPage.jsp").forward(req,resp);

    public RequestDispatcher getRequestDispatcher(String url ){
        return new RequestDispatcher(url);
    }
    class RequestDispatcher{

        String url;
        public RequestDispatcher(String url) {
            this.url=url;
        }

        public void forward(HttpServletRequest request ,HttpServletResponse response){
            request.serletPath = url ;
        }
    }


}
