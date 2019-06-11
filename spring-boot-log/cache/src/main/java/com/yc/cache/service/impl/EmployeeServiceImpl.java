package com.yc.cache.service.impl;

import com.yc.cache.bean.Employee;
import com.yc.cache.mapper.EmployeeMapper;
import com.yc.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author LX
 * @date 2019/6/11 - 12:23
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 将方法的运行结果进行缓存,以后再要相同的数据,直接才缓存中获取,不再调用方法
     *
     * CacheManager管理多个Cache组件,对缓存的真正的CRUD操作在Cache组件中,每个缓存组件有自己唯一的名字
     *
     * 几个属性:
     *     cacheNames /value :指定缓存组件的名字
     *     key: 缓存数据使用的key : 可以用它来指定.默认是 使用方法的参数
     *     编写SpEL ; #id >参数id的值   #a0   #root.args[0]
     *
     *     keyGenerator: key 的生成器 ,可以自己指定key的生成器的组件id
     *     key/keyGenerator: 二选一 使用
     *     cacheManager : 指定缓存管理器, 或者cacheResolver 指定
     *     condition : 指定符合条件的情况下 才缓存
     *     unless: 否定缓存 ; 当unless指定的条件为 true , 方法的返回值就不会缓存
     *
     *     #result  取出放回值
     *     sync 异步缓存
     *
     *     运行流程 :
     *     1: 方法运行之前  ,先去查询Cache(缓存组件) , 按照cacheNames指定的名字获取
     *     (CacheManeger先获取相应的缓存),第一次获取缓存 如果没有Cache组件会自动创建
     *     2: 去Cache中查找 缓存的内容 ,使用 一个key ,默认是方法的参数
     *     key是按照某种策略生成的,默认是使用keyGenerator生成的,默认使用SimpleKeyGenerator生成key
     *          SimpleKeyGenerator 生成key的默认策略
     *          如果没有参数 :  key = new SimpleKey();
     *          如果有一个参数 :   key = 参数值
     *          如果有多个参数:  key = SimpleKey(params);
     *          
     *     3: 没有查到缓存就调用 目标方法
     *     4: 将目标方法 返回的结果,放进缓存中
     *
     *     @ cacheAble 标注的方法 执行前先来检出缓存中 有没有这个数据,
     *     默认是 按照参数的值作为key去查询缓存
     *     如果没有就运行方法 ,并将 结果放入缓存中
     *
     * key = "#id"
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "emp",key = "#root.args[0]",condition = "#id>0",unless = "#result==null")
    @Override
    public Employee getEmployById(Integer id) {
        System.out.println("查询: "+id+" 员工");
        Employee empById = employeeMapper.getEmpById(id);
        return empById;
    }
}
