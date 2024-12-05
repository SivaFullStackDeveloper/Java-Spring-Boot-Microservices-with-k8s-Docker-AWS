package com.siva.firstjobapp.company.companyImpl;

import com.siva.firstjobapp.company.model.Company;
import com.siva.firstjobapp.company.repo.CompanyRepository;
import com.siva.firstjobapp.company.service.CompanyService;
import com.siva.firstjobapp.job.model.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Optional<Company> getCompanyById(Long id) {

        return companyRepository.findById(id);
    }

    @Override
    public boolean deleteById(Long id) {
        companyRepository.deleteById(id);

        return  true;
    }

    @Override
    public Optional<Company> updateById(Company company, Long id) {
        Optional<Company> company1 = companyRepository.findById(id);

        if (company1.get().getId()==id){
            company1.get().setName(company.getName());
            company1.get().setDescription(company.getDescription());
            companyRepository.save(company1.get());
        }

        return company1;
    }
}
