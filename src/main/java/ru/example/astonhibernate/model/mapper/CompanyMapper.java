package ru.example.astonhibernate.model.mapper;

import org.springframework.stereotype.Component;
import ru.example.astonhibernate.model.Company;
import ru.example.astonhibernate.model.dto.company.CompanyDtoRq;
import ru.example.astonhibernate.model.dto.company.CompanyDtoRs;

@Component
public class CompanyMapper {
    public CompanyDtoRs toDto(Company company) {
        return new CompanyDtoRs(company.getCompanyId(), company.getName());
    }

    public Company fromDto(CompanyDtoRq companyDtoRq) {
        return new Company(companyDtoRq.getCompanyId(), companyDtoRq.getName());
    }
}