package HTTP;

import java.io.IOException;

/**
 * @author LX
 * @date 2019/1/5 - 11:05
 */
public class HelloServlet  extends  HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        super.doPost(request, response);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("hello world ");
        response.getWriter().write("hello world ");

    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void destory() {
        super.destory();
    }
}
