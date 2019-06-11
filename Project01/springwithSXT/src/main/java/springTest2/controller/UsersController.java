package springTest2.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import springTest2.pojo.Users;
import springTest2.service.UsersService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author LX
 * @date 2019/3/13 - 20:19
 */
@Controller
public class UsersController {

    @Resource
    private UsersService usersServiceImpl;

    @InitBinder
    protected void initBinder(WebDataBinder binder){

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");

        dateFormat.setLenient(false);

        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false));
    }

    @RequestMapping("demo")
    public String demo1(String name ,int age ){

        System.out.println(name+ " "+ age);

        return "main.jsp";
    }


    /**
     * 登录功能
     * @param users
     * @param req
     * @return
     */
    @RequestMapping("login")
    public String login(Users users, HttpServletRequest req){

        System.out.println(666);
        Users users1 = usersServiceImpl.selByLogin(users);

        if(users1!=null){

            req.getSession().setAttribute("users",users1);

            return "redirect:show";
        }else{

            return "error.jsp";
        }
    }

    /**
     *
     * 注册
     * @param users
     * @param fileName
     * @param req
     * @return
     * @throws IOException
     */
    @RequestMapping("reg")
    public String reg(Users users, MultipartFile fileName, HttpServletRequest req) throws IOException {

        String filename = fileName.getOriginalFilename();


        String fileType = filename.substring( filename.lastIndexOf(".") );

        if(fileType.equalsIgnoreCase(".png") ||fileType.equalsIgnoreCase(".jpg") ){

            String uuid = UUID.randomUUID().toString();

            String realPath = req.getServletContext().getRealPath("images");

            InputStream inputStream = fileName.getInputStream();

            File file = new File(realPath,uuid+fileType);

            FileUtils.copyInputStreamToFile(inputStream,file);

            users.setPhoto("images"+"/"+uuid+fileType);

            int i = usersServiceImpl.insUser(users);

            if(i<=0){

                return "error.jsp";
            }else{

                req.setAttribute("users",users);
                return "main.jsp";
            }

        }else{

            return "error.jsp";
        }
    }


/*

    @RequestMapping("users?oper=login")
    public String demo2(){
        System.out.println("login");

        return "main.jsp";
    }

    @RequestMapping("users?oper=reg")
    public String demo3(){
        System.out.println("reg");

        return "main.jsp";
    }
*/



}
