package com.oocl.springBootApiPractice2.service.impl;

import com.oocl.springBootApiPractice2.entity.Employee;
import com.oocl.springBootApiPractice2.service.EmployeeService;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * @author Dylan Wei
 * @date 2018-07-24 17:50
 */
@Service
public class EmployServiceImpl implements EmployeeService {

    @Override
    public List<Employee> getAllEmployees() {
        throw new NotImplementedException();
    }
}
