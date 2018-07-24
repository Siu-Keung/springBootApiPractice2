package com.oocl.springBootApiPractice2.service.impl;

import com.oocl.springBootApiPractice2.SpringBootApiPractice2Application;
import com.oocl.springBootApiPractice2.entity.Employee;
import com.oocl.springBootApiPractice2.service.EmployeeService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.regex.Matcher;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Dylan Wei
 * @date 2018-07-24 17:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootApiPractice2Application.class)
public class EmployServiceImplTest {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private List<Employee> employeeList;


    @Test
    public void getAllEmployees() {
        List<Employee> resultList = this.employeeService.getAllEmployees();
        assertThat(resultList, is(this.employeeList));
    }
}