package springTest2.service.impl;

import org.springframework.stereotype.Service;
import springTest2.mapper.FilesMapper;
import springTest2.pojo.Files;
import springTest2.service.FilesService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LX
 * @date 2019/3/14 - 18:13
 */
@Service
public class FilesServiceImpl implements FilesService {

    @Resource
    private  FilesMapper filesMapper;


    @Override
    public List<Files> selAll() {

        return filesMapper.selAll();
    }

    @Override
    public int updCount(Files files) {

        return filesMapper.updCount(files);
    }
}
