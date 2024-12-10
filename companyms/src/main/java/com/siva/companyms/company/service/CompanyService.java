package com.siva.companyms.company.service;


import com.siva.companyms.company.model.Company;

import java.util.List;
import java.util.Optional;


public interface CompanyService {
    List<Company> findAll();
    void createCompany(Company company);
    Optional<Company> getCompanyById(Long id);
    boolean deleteById(Long id);
    Optional<Company> updateById(Company company, Long id);
}
