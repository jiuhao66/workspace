package com.yc.datademo.service.impl;

import com.yc.datademo.bean.Novel;
import com.yc.datademo.mapper.NovelMapper;
import com.yc.datademo.service.NovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LX
 * @date 2019/6/9 - 11:26
 */
@Service
public class NovelServiceImpl implements NovelService {

    @Autowired
    private NovelMapper novelMapper;

    @Override
    public Novel selNovelByNovelName(String novelName) {
        Novel novel = novelMapper.getNovelByNovelName(novelName);
        return novel;
    }

    @Override
    public Novel selNovelById(long nid) {

        Novel novel = novelMapper.getNovelById(nid);

        return novel;
    }
}
