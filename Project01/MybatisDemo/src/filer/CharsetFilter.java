package filer;

import org.apache.ibatis.session.SqlSession;
import util.MybatisUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LX
 * @date 2018/11/18 - 19:01
 */
@WebFilter(filterName = "CharsetFilter")
public class CharsetFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        SqlSession session= MybatisUtils.getSession();

        try{
            chain.doFilter(req, resp);
            session.commit();
        }catch (Exception e){
            session.rollback();;
        }finally {
            session.close();
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
