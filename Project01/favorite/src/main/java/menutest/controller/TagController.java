package menutest.controller;

import menutest.pojo.Favorite;
import menutest.service.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LX
 * @date 2019/3/11 - 19:59
 */
@Controller
public class TagController {

    @Resource
    private TagService tagServiceImpl;

    @RequestMapping("show")
    @ResponseBody
    public List<Favorite> show(String name, Model model){

        return null ;
    }


}
