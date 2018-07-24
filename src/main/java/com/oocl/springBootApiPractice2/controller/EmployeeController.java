package com.oocl.springBootApiPractice2.controller;

import com.oocl.springBootApiPractice2.entity.Employee;
import com.oocl.springBootApiPractice2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Dylan Wei
 * @date 2018-07-24 22:13
 */

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        return this.employeeService.getEmployeeById(id);
    }

    @GetMapping("/employees/page/{pageNum}/pageSize/{pageSize}")
    public List<Employee> getEmployeesPaging(
            @PathVariable Integer pageNum, @PathVariable Integer pageSize
    ){
        return this.employeeService.getEmployeePaging(pageNum, pageSize);
    }
}
