package ru.example.astonhibernate.service;

import ru.example.astonhibernate.model.dto.company.CompanyDtoRq;
import ru.example.astonhibernate.model.dto.company.CompanyDtoRs;

import java.util.List;

public interface CompanyService {
    List<CompanyDtoRs> getAllCompany();

    void saveOrUpdateCompany(CompanyDtoRq companyDtoRq);

    CompanyDtoRs getCompanyById(Integer id);

    void deleteCompany(Integer id);
}