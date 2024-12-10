package com.siva.companyms.company.controller;

import com.siva.companyms.company.service.CompanyService;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.siva.companyms.company.model.Company;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {
    CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(Company company) {
        return new ResponseEntity<>(companyService.findAll(), HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Company company) {
        companyService.createCompany(company);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Company>> add(@PathVariable Long id) {
        Optional<Company> job = companyService.getCompanyById(id);
        if (job != null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        boolean deleted = companyService.deleteById(id);
        if (deleted == true) {
            return new ResponseEntity<>(deleted, HttpStatus.OK);
        }

        return new ResponseEntity<>(deleted, HttpStatus.NOT_FOUND);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Company>> updateById(@RequestBody Company job, @PathVariable Long id) {
        Optional<Company> update = companyService.updateById(job, id);
        if (update != null) {
            return new ResponseEntity<>(update, HttpStatus.OK);
        }

        return new ResponseEntity<>(update, HttpStatus.NOT_FOUND);

    }

}
