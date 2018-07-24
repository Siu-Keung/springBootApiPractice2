package com.oocl.springBootApiPractice2.service.impl;

import com.oocl.springBootApiPractice2.entity.Company;
import com.oocl.springBootApiPractice2.entity.Employee;
import com.oocl.springBootApiPractice2.model.CompanyModel;
import com.oocl.springBootApiPractice2.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Dylan Wei
 * @date 2018-07-24 20:13
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private List<Company> allCompanies;
    @Autowired
    private List<Employee> allEmployees;

    @Override
    public List<CompanyModel> getAllCompaniesModels() {
        List<CompanyModel> resultList = new ArrayList<>();
        for(Company company : this.allCompanies){
            List<Employee> employeeList;
            employeeList = this.allEmployees.stream().filter(
                    item -> item.getId().equals(company.getId()))
                    .collect(Collectors.toList());
            resultList.add(new CompanyModel(company, employeeList));
        }
        return resultList;
    }

    private List<Employee> findEmployeesByCompanyId(Integer companyId){
        return this.allEmployees.stream()
                .filter(item -> item.getCompanyId().equals(companyId))
                .collect(Collectors.toList());
    }

    @Override
    public CompanyModel getCompanyModelById(Integer id) {
        Optional<Company> optional = this.allCompanies.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
        if(!optional.isPresent())
            return null;
        CompanyModel companyModel = new CompanyModel(optional.get(), findEmployeesByCompanyId(id));
        return companyModel;
    }

    @Override
    public List<CompanyModel> getCompaniesModelsPaging(int pageNum, int size) {
        int startIndex = (pageNum - 1) * size;
        int endIndex = startIndex + size;
        return this.getAllCompaniesModels().subList(startIndex, endIndex);
    }

    @Override
    public Boolean addCompany(Company newCompany) {
        if(this.allCompanies.indexOf(newCompany) != -1)
            return false;
        this.allCompanies.add(newCompany);
        return true;
    }
}
