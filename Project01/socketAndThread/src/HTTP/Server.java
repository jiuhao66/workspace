package HTTP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final String WEB_CONIENT_PATH ="D:\\YC-培训文件接收柜\\HTTP\\photo\\photo";
	public static void main(String[] args) throws IOException {
		
		ServerSocket server=new ServerSocket(8080);

		
		while(true){
			
			System.out.println("等待客户端连接           ");
			Socket socket = server.accept();
			
			Thread t=new Thread(){
				
				public void run(){
					InputStream loaclIn=null;
					try {
						
						int len ;
						byte []b=new byte[1024];
						
						InputStream is=socket.getInputStream();

						OutputStream out=socket.getOutputStream();

						StringBuffer requestContent=new StringBuffer();

						while((len=is.read(b))>0){

							System.out.println(new String (b,0,len));

							requestContent.append(new String(b,0,len));

							if(is.available()<=0){


								break;

							}
						}

						String path = getPath( requestContent.toString() );

						if(path.endsWith("new.html")==false){

							out.write("HTTP/1.1 302 redirect\r\n".getBytes());

						}else{

							out.write("HTTP/1.1 200 OK\r\n".getBytes());
						}

						String contentType = getContentType(path);

                        if(path.endsWith("new.html")==false){

                        	out.write( ("Location: new.html").getBytes());

							System.out.println(path);
						}

						path= WEB_CONIENT_PATH + path;
						try {
							loaclIn = new FileInputStream(path);

						} catch (FileNotFoundException e) {


							path=WEB_CONIENT_PATH + "/404.html";

							loaclIn=new FileInputStream(path);

							contentType = getContentType(path);

						}
						out.write(("Content-Type: "+contentType+";charset=utf-8\r\n").getBytes());

						out.write("\r\n".getBytes());

						while((len=loaclIn.read(b))!=-1){

							out.write(b, 0, len);

						}
						out.flush();
						
					} catch (IOException e) {
						
						e.printStackTrace();
					}finally{
						try {
							loaclIn.close();
						} catch (Exception e1) {
							
							e1.printStackTrace();
						}
						
						try {
							socket.close();
						} catch (IOException e) {
							
							e.printStackTrace();
						}
					}
					
				}
			};
			t.start();
			
		}
		
	}
	
	public static String getPath(String requestContent){

		int index =requestContent.indexOf("\r\n");

		String first=requestContent.substring(0, index);

		String iteams[]=first.split("\\s");    //  \\s  正则表达式的空格  \\s

		return iteams[1];

	}
	
	public static String getContentType(String path){

		if(path.indexOf(".js")>0){

			return "application/x-javascript";

		}else if(path.indexOf(".css")>0){

			return "text/css";

		}else{

			return "text/html;charset=utf-8";

		}
	}

}
