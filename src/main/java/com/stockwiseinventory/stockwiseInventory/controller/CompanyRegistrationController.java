package com.stockwiseinventory.stockwiseInventory.controller;

import com.stockwiseinventory.stockwiseInventory.model.Company;
import com.stockwiseinventory.stockwiseInventory.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyRegistrationController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/register")
    public String registerCompany(@RequestBody Company company) {
        companyService.saveCompanyDetails(company);
        return "Company registered successfully.";
    }

}
