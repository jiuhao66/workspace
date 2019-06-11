package menutest.controller;

import menutest.service.FavoriteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author LX
 * @date 2019/3/11 - 21:05
 */
@Controller
public class FavoriteController {

    @Resource
    private FavoriteService favoriteServiceImpl;

    @RequestMapping("index")
    public String demo(){
        return "index.jsp";
    }
}
