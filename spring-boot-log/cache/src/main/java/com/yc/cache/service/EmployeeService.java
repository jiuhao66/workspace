package com.yc.cache.service;

import com.yc.cache.bean.Employee;

/**
 * @author LX
 * @date 2019/6/11 - 12:22
 */
public interface EmployeeService {

    Employee getEmployById(Integer id);

    Employee updEmploy(Employee employee);
}
