package service;

import menutest.pojo.PageInfo;

import java.io.IOException;

/**
 * @author LX
 * @date 2018/11/17 - 20:02
 */
public interface PageService {

    public PageInfo showUser(int pageSize , int  pageNumber) throws IOException;
}
