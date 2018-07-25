package com.oocl.springBootApiPractice2.service.impl;

import com.oocl.springBootApiPractice2.entity.Company;
import com.oocl.springBootApiPractice2.entity.Employee;
import com.oocl.springBootApiPractice2.model.CompanyModel;
import com.oocl.springBootApiPractice2.service.CompanyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Dylan Wei
 * @date 2018-07-24 20:15
 */
public class CompanyServiceImplTest {
    private CompanyService companyService;
    private List<Company> companyList;
    private List<Employee> employeesList;


    @BeforeEach
    void init(){
        employeesList = new ArrayList<>();
        employeesList.add(new Employee(1, "小红", 19, "女", 5000.0, 1));
        employeesList.add(new Employee(2, "小智", 15, "男", 5000.0, 1));
        employeesList.add(new Employee(3, "小刚", 16, "男", 5000.0, 2));
        companyList = new ArrayList<>();
        companyList.add(new Company(1, "公司1"));
        companyList.add(new Company(2, "公司2"));
        this.companyService = new CompanyServiceImpl(this.companyList, this.employeesList);
    }

    @Test
    public void should_get_all_companies() {
        List<CompanyModel> companyList = this.companyService.getAllCompaniesModels();

        assertThat(companyList.size(), is(2));
    }

    @Test
    public void should_get_specific_company_given_valid_id(){
        CompanyModel companyModel = this.companyService.getCompanyModelById(1);

        assertThat(companyModel.getId(), is(1));
        assertThat(companyModel.getEmployees().size(), is(2));
    }


    @Test
    public void should_get_companies_paging(){
        List<CompanyModel> resultList = this.companyService
                .getCompaniesModelsPaging(1, 1);

        assertThat(resultList.size(), is(1));
        assertThat(resultList.get(0), equalTo(this.companyList.get(0)));
    }

    @Test
    public void should_add_company_successfully_when_given_id_not_exists(){
        boolean result = this.companyService.addCompany(new Company(3, "公司3"));

        assertThat(this.companyList.size(), is(3));
        assertThat(result, is(true));
    }

    @Test
    public void should_add_company_failed_when_given_id_exists(){
        boolean result = this.companyService.addCompany(new Company(2, "公司2"));

        assertThat(this.companyList.size(), is(2));
        assertThat(result, is(false));
    }

    @Test
    public void should_update_successfully_when_id_valid(){
        Company company = new Company(1, "公司一");

        boolean succeeded = this.companyService.updateCompany(company);

        assertThat(this.companyList.get(0).getCompanyName(), is("公司一"));
        assertThat(succeeded, is(true));
    }

    @Test
    public void should_update_failed_when_id_invalid() {
        Company company = new Company(999, "公司一");

        boolean succeeded = this.companyService.updateCompany(company);

        assertThat(succeeded, is(false));
    }

    @Test
    public void should_remove_company_and_employees(){
        boolean succeeded = this.companyService.removeCompanyAndEmployees(1);

        assertThat(succeeded, is(true));
        assertThat(this.employeesList.size(), is(1));
        assertThat(this.companyList.size(), is(1));
    }


}