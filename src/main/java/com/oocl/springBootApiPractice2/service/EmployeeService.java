package com.oocl.springBootApiPractice2.service;

import com.oocl.springBootApiPractice2.entity.Employee;

import java.util.List;

/**
 * @author Dylan Wei
 * @date 2018-07-24 17:46
 */
public interface EmployeeService {

    List<Employee> getAllEmployees();

}
