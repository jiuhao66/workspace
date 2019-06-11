package com.yc.datademo.controller;

import com.yc.datademo.bean.Novel;
import com.yc.datademo.service.NovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LX
 * @date 2019/6/9 - 11:09
 */
@Controller
public class NovelController {

    @Autowired
    private NovelService novelService ;

    @ResponseBody
    @RequestMapping("/novel.n/{nid}")
    public Novel getNovelById(@PathVariable("nid") long nid){

        return novelService.selNovelById(nid);
    }

    @ResponseBody
    @RequestMapping("/novelName/{novelName}")
    public Novel getNovelByNovelName(@PathVariable("novelName") String novelName){

        return novelService.selNovelByNovelName(novelName);
    }
}
