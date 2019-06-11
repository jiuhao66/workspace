package ioc_annotation.service.impl;

import ioc_annotation.mapper.PersonMapper;
import ioc_annotation.service.PersonService;
import org.springframework.stereotype.Service;

/**
 * @author LX
 * @date 2019/3/17 - 10:18
 */
@Service
public class PersonServiceImpl implements PersonService {

    private PersonMapper personMapper ;

}
