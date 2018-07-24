package com.oocl.springBootApiPractice2.controller;

import com.oocl.springBootApiPractice2.model.CompanyModel;
import com.oocl.springBootApiPractice2.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Dylan Wei
 * @date 2018-07-24 22:44
 */
@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies")
    public List<CompanyModel> getCompanyModels(){
        return companyService.getAllCompaniesModels();
    }

    @GetMapping("/companies/{id}")
    public CompanyModel getCompanyModel(@PathVariable Integer id){
        return companyService.getCompanyModelById(id);
    }


}
