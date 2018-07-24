package com.oocl.springBootApiPractice2.model;

import com.oocl.springBootApiPractice2.entity.Company;
import com.oocl.springBootApiPractice2.entity.Employee;

import java.util.List;

/**
 * @author Dylan Wei
 * @date 2018-07-24 20:31
 */
public class CompanyModel extends Company {
    private List<Employee> employees;

    public CompanyModel(String companyName) {
        super(companyName);
    }

    public CompanyModel(String companyName, List<Employee> employees) {
        super(companyName);
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Integer getEmployeesNumber(){
        return this.employees.size();
    }
}
