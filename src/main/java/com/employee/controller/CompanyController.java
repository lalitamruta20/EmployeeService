package com.employee.controller;

import com.employee.Model.CompanyModel;
import com.employee.Service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {


    private CompanyService companyService;

    public CompanyController (CompanyService companyService){
          this.companyService = companyService;
    }

    @PostMapping("/company")
    public void create(@Valid @RequestBody CompanyModel companyModel){
        companyService.create(companyModel);

    }
}
