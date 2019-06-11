package com.yc.cache.controller;

import com.yc.cache.bean.Employee;
import com.yc.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LX
 * @date 2019/6/11 - 12:24
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService ;

    @GetMapping("/emp/{id}")
    public Employee getEmploy(@PathVariable("id") Integer id){

        Employee employById = employeeService.getEmployById(id);

        return employById;

    }
}
