package com.siva.firstjobapp.company.service;

import com.siva.firstjobapp.company.model.Company;
import com.siva.firstjobapp.job.model.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface CompanyService {
    List<Company> findAll();
    void createCompany(Company company);
    Optional<Company> getCompanyById(Long id);
    boolean deleteById(Long id);
    Optional<Company> updateById(Company company, Long id);
}
