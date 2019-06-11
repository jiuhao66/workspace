package menutest.controller;

import menutest.pojo.PageInfo;
import menutest.service.serviceImpl.PageServiceImpl;
import service.PageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LX
 * @date 2018/11/17 - 19:45
 */
@WebServlet("/page")
public class PageServlet extends HttpServlet {

    PageService pageService=new PageServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PageInfo pageInfo=null;
        //控制用户传参时候 没有带参数   默认是第一页 展示2行数据
        int pageSize =2;
        int pageNumber =1;
        String uPageSize=req.getParameter("pagesize");
        if(uPageSize!=null && !"".equals(uPageSize)){
            pageSize=Integer.parseInt(uPageSize);
        }
        String uPageNumber=req.getParameter("pagenumber");
        if(uPageNumber!=null && !"".equals(uPageNumber)){
            pageNumber=Integer.parseInt(uPageNumber);
        }

       // this.getServletContext().getRealPath("");

        PageInfo pageInfo1=null ;
        pageInfo=pageService.showUser(pageSize,pageNumber);
        req.setAttribute("pageInfo",pageInfo);
        req.getRequestDispatcher("showPage.jsp").forward(req,resp);

    }
}
