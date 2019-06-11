package springTest2.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springTest2.pojo.Files;
import springTest2.service.FilesService;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author LX
 * @date 2019/3/14 - 18:11
 */
@Controller
public class FilesController {

    @Resource
    private FilesService filesServiceImpl;

    @RequestMapping("show")
    public String show(HttpServletRequest req){

        Map<String ,Object> map;

        List<Files> filesList = filesServiceImpl.selAll();

        req.setAttribute("list",filesList);

        return "show.jsp";
    }


    @RequestMapping("download")
    public void download(Files files, HttpServletRequest req, HttpServletResponse resp) throws IOException {

        System.out.println(files);

        String name = files.getName();

        /**
         * 文件 下载  必须 加 这个 头文件
         */
        resp.setHeader("Content-Disposition","attachment;filename="+name);

        String realPath = req.getServletContext().getRealPath("files");

        File file = new File(realPath, name);

        byte[] bytes = FileUtils.readFileToByteArray(file);

        ServletOutputStream respOutputStream = resp.getOutputStream();

        respOutputStream.write(bytes);

        respOutputStream.flush();

        respOutputStream.close();

        filesServiceImpl.updCount(files);
    }


}
