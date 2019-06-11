package springTest2.service;

import springTest2.pojo.Files;

import java.util.List;

/**
 * @author LX
 * @date 2019/3/14 - 18:13
 */
public interface FilesService {

    List<Files>selAll();

    int updCount(Files files);
}
