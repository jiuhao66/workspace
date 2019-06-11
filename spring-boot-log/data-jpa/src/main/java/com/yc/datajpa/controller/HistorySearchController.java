package com.yc.datajpa.controller;

import com.yc.datajpa.entity.HistorySearch;
import com.yc.datajpa.repository.HistorySearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author LX
 * @date 2019/6/9 - 15:51
 */
@RestController
public class HistorySearchController {

    @Autowired
    private HistorySearchRepository historySearchRepository ;

    @RequestMapping("/historySearch/{hid}")
    public List<HistorySearch> getHistorySearch(@PathVariable("hid") Long hid){
        List<HistorySearch> searchList = historySearchRepository.findAll();
        return searchList;
    }
}
