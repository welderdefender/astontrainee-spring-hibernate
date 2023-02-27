package ru.example.astonhibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.example.astonhibernate.model.dto.company.CompanyDtoRq;
import ru.example.astonhibernate.service.CompanyService;

@Controller
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public String getAllCompany(Model model) {
        model.addAttribute("companies", companyService.getAllCompany());
        return "get-all-companies";
    }

    @GetMapping("/{id}")
    public String findCompany(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("company", companyService.getCompanyById(id));
        return "find-company";
    }

    @GetMapping("/create")
    public String createCompany(Model model) {
        model.addAttribute(new CompanyDtoRq());
        return "create-company";
    }

    @PostMapping("/create")
    public String createCompany(CompanyDtoRq companyDtoRq) {
        companyService.saveOrUpdateCompany(companyDtoRq);
        return "redirect:/company";
    }

    @GetMapping("/update/{id}")
    public String updateCompany(@PathVariable Integer id, Model model) {
        model.addAttribute("company", companyService.getCompanyById(id));
        return "update-company";
    }

    @PostMapping("/update/{id}")
    public String updateCompany(CompanyDtoRq companyDtoRq) {
        companyService.saveOrUpdateCompany(companyDtoRq);
        return "redirect:/company";
    }

    @PostMapping("/delete/{id}")
    public String deleteCompany(@PathVariable Integer id) {
        companyService.deleteCompany(id);
        return "redirect:/company";
    }
}