package com.oocl.springBootApiPractice2.service;

import com.oocl.springBootApiPractice2.entity.Company;
import com.oocl.springBootApiPractice2.model.CompanyModel;

import java.util.List;

/**
 * @author Dylan Wei
 * @date 2018-07-24 20:13
 */
public interface CompanyService {

    List<CompanyModel> getAllCompanies();

}