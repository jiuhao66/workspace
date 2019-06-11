package com.yc.datademo.service;

import com.yc.datademo.bean.Novel;

/**
 * @author LX
 * @date 2019/6/9 - 11:25
 */
public interface NovelService {

    Novel selNovelById(long nid);

    Novel selNovelByNovelName(String novelName);
}
