package menutest.service.impl;

import menutest.mapper.TagMapper;
import menutest.service.TagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author LX
 * @date 2019/3/11 - 21:04
 */
@Service
public class TagServiceImpl implements TagService {

    @Resource
    private TagMapper tagMapper;
}
