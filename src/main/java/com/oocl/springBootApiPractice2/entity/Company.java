package com.oocl.springBootApiPractice2.entity;

import java.util.List;

/**
 * @author Dylan Wei
 * @date 2018-07-24 20:10
 */
public class Company {
    private String companyName;

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                '}';
    }

    public Company() {
    }

    public Company(String companyName) {

        this.companyName = companyName;
    }

    public String getCompanyName() {

        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
