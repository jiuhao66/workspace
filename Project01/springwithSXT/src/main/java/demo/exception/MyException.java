package demo.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义 异常    注册 springmvc.xml  文件的  异常解析器  的  属性下面
 * @author LX
 * @date 2019/3/13 - 23:23
 */
@Component
public class MyException implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse, Object o, Exception e) {

        ModelAndView modelAndView = null;

        if(e instanceof IOException){

            modelAndView = new ModelAndView("exception.jsp");
        }else if(e instanceof NullPointerException){

            modelAndView = new ModelAndView("index.jsp");
        }
        return modelAndView;
    }
}
