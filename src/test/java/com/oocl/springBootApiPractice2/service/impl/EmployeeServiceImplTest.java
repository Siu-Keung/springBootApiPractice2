package com.oocl.springBootApiPractice2.service.impl;

import com.oocl.springBootApiPractice2.SpringBootApiPractice2Application;
import com.oocl.springBootApiPractice2.entity.Employee;
import com.oocl.springBootApiPractice2.service.EmployeeService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Dylan Wei
 * @date 2018-07-24 17:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootApiPractice2Application.class)
public class EmployeeServiceImplTest {
    @Mock
    private List<Employee> employeeList;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllEmployees() {
        List<Employee> resultList = this.employeeService.getAllEmployees();
        System.out.println(resultList);
        assertThat(resultList, is(this.employeeList));
    }

    @Test
    public void addEmployee(){
        when(this.employeeList.indexOf(any(Employee.class))).thenReturn(-1);
        this.employeeService.addEmployee(mock(Employee.class));

        verify(this.employeeList).add(any(Employee.class));
    }

    @Test
    public void updateEmployee(){
        Employee mockEmployee = mock(Employee.class);
        when(this.employeeList.indexOf(any())).thenReturn(0);
        when(this.employeeList.get(0)).thenReturn(mockEmployee);

        boolean succeeded = this.employeeService.updateEmployee(mock(Employee.class));

        assertThat(succeeded, is(true));
    }

    @Test
    public void removeEmployee(){
        this.employeeService.removeEmployee(123456789);

        verify(this.employeeList).remove(any());
    }
}