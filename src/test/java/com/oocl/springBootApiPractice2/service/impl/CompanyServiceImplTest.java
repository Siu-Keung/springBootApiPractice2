package com.oocl.springBootApiPractice2.service.impl;

import com.oocl.springBootApiPractice2.SpringBootApiPractice2Application;
import com.oocl.springBootApiPractice2.entity.Company;
import com.oocl.springBootApiPractice2.entity.Employee;
import com.oocl.springBootApiPractice2.model.CompanyModel;
import com.oocl.springBootApiPractice2.service.CompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Dylan Wei
 * @date 2018-07-24 20:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootApiPractice2Application.class)
public class CompanyServiceImplTest {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private List<Company> companies;
    @Autowired
    private List<Employee> employees;

    @Test
    public void should_get_all_companies() {
        List<CompanyModel> companyList = this.companyService.getAllCompanies();

        assertThat(companyList.size(), is(2));
        assertThat(companyList.get(0).getCompanyName(), equalTo("公司1"));
        assertThat(companyList.get(1).getCompanyName(), equalTo("公司2"));
    }
}