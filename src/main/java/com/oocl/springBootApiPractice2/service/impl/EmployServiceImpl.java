package com.oocl.springBootApiPractice2.service.impl;

import com.oocl.springBootApiPractice2.entity.Employee;
import com.oocl.springBootApiPractice2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * @author Dylan Wei
 * @date 2018-07-24 17:50
 */
@Service
public class EmployServiceImpl implements EmployeeService {
    @Autowired
    private List<Employee> allEmployees;

    @Override
    public List<Employee> getAllEmployees() {
        return allEmployees;
    }
}
