package com.bug.java;

import java.sql.Date;

/**
 * @author LX
 * @date 2018/11/12 - 19:28
 */
public class Templates {

    public static void main(String[] args) {

        Date date=new Date(System.currentTimeMillis());
        date.getTime();
        System.out.println(date.getTime());
    }

}
