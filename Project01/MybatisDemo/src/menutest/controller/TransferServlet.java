package menutest.controller;

import menutest.pojo.Account;
import menutest.service.TransferService;
import menutest.service.serviceImpl.TransferServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LX
 * @date 2018/11/18 - 18:58
 */
@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {

    TransferService transferService=new TransferServiceImpl();

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        transfer(req,resp);
        return;
    }

    private void transfer(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

        String outId=req.getParameter("outId");
        String outPwd=req.getParameter("outPwd");
        String amount=req.getParameter("amount");
        Account out=new Account(Integer.parseInt(outId),outPwd,Double.parseDouble(amount));
        String inId=req.getParameter("inId");
        String inName=req.getParameter("inName");
        Account in=new Account(Integer.parseInt(inId),inName);
        int index=transferService.transfer(out,in);
        
        if(index==6){
            //转账成功
            resp.sendRedirect("success.jsp");
            return;
        }else{
            //转账失败
            req.getSession().setAttribute("err",index);
            resp.sendRedirect("err/error.jsp");
            return;
        }
    }
}
