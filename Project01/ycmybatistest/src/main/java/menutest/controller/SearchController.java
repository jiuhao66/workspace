package menutest.controller;

import menutest.pojo.FilmInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author LX
 * @date 2019/3/3 - 15:31
 */

@Controller
public class SearchController  {


   /* @RequestMapping("search")
    public String search(String filmName,String actor,String director,String typeName,int priceFrom,int priceTo){

        System.out.println(filmName+ " "+ actor+" "+director+ " "+ typeName+ "  "+ priceFrom+ "  "+priceTo);

        return "list.jsp";
    }*/

    @RequestMapping("search")
    public String search(FilmInfo filmInfo){
        String t="66";

        return "list.jsp";
    }

    /**
     *
     * value 是指明 网页参数和 menutest.controller 参数名 不一致
     * value 的赋值 必须要和 网页的 参数 名 一致
     *
     * required 为true的时候 必须有值  没值的话 报异常
     * defaultValue 的 是默认 给 相应的参数 赋值
     * @param name
     * @param age
     * @return
     */
    @RequestMapping("demo")
    public String demo(@RequestParam(value = "name1",defaultValue = "lixin",required = true) String name , int age){

        return "list.jsp";
    }

    /**
     * 当 传过来的参数   没有相应的时候    默认给它 赋值
     * @param pageSize
     * @param pageNumber
     * @return
     */
    @RequestMapping("page")
    public String demo1(@RequestParam(defaultValue = "2") int pageSize , @RequestParam(defaultValue = "1") int pageNumber){

        return "list.jsp";
    }

    @RequestMapping("demo2")
    public String demo2(@RequestParam(value = "name") String name , int age){

        return "list.jsp";
    }

    /**
     * 当传过来的时候  有多参数的时候  可以用 @RequestParam(value = "name")  来接受
     * @param list
     * @param age
     * @return
     */
    @RequestMapping("demo3")
    public String demo3(@RequestParam(value = "name")List<String>list, int age){

        return "list.jsp";
    }

    /**
     *  当传来的 参数  为   fileType.tyoeName  会自动去 接受参数 类 的  属性里面找    参数名要和 类里面的属性名 相同
     * @param filmInfo
     * @param age
     * @return
     */
    @RequestMapping("demo4")
    public String demo4(@RequestParam(value = "name")FilmInfo filmInfo, int age){

        return "list.jsp";
    }

    /**
     * restful传值    参前端  a标签 跳转时    demo5/lixin/123
     *
     * RequestMapping 里面的 参数要 和a 的格式对应   下面的方法参数要和 {} 里面的名字 相对应
     *
     * 当使用restful 前端参数 的时候   方法的注解要  用@PathVariable 来去 requestMapping里面寻找参数
     * @param name age
     * @param age
     * @return
     */
    @RequestMapping("demo5/{name}/{age}")
    public String demo5(@PathVariable("name") String name,@PathVariable("age") int age){

        return "list.jsp";
    }


}
