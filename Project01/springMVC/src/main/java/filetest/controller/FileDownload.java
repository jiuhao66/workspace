package filetest.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @author LX
 * @date 2019/3/12 - 20:15
 */
@Controller
public class FileDownload {

    @RequestMapping("files")
    public void download(String fileName , HttpServletRequest req , HttpServletResponse resp) throws IOException {

        resp.setHeader("Content-Disposition","attachment;filename=a.txt");

        ServletOutputStream respOutputStream = resp.getOutputStream();

        String realPath = req.getServletContext().getRealPath("files");

        File file = new File(realPath, fileName);

        byte[] bytes = FileUtils.readFileToByteArray(file);

        respOutputStream.write(bytes);

        respOutputStream.flush();

        respOutputStream.close();


    }
}
