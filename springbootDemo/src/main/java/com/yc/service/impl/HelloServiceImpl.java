package com.yc.service.impl;

import com.yc.service.HelloService;

/**
 * @author LX
 * @date 2019/6/2 - 15:32
 */
public class HelloServiceImpl implements HelloService{
    @Override
    public String hello() {
        System.out.println(666);
        return null;
    }
}
