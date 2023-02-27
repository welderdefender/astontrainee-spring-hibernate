package ru.example.astonhibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.astonhibernate.model.dto.company.CompanyDtoRq;
import ru.example.astonhibernate.model.dto.company.CompanyDtoRs;
import ru.example.astonhibernate.model.mapper.CompanyMapper;
import ru.example.astonhibernate.repository.CompanyRepository;
import ru.example.astonhibernate.service.CompanyService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }

    @Override
    public List<CompanyDtoRs> getAllCompany() {
        return companyRepository.getAllCompany()
                .stream()
                .map(companyMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void saveOrUpdateCompany(CompanyDtoRq companyDtoRq) {
        companyRepository.saveOrUpdateCompany(companyMapper.fromDto(companyDtoRq));
    }

    @Override
    public CompanyDtoRs getCompanyById(Integer id) {
        return companyMapper.toDto(companyRepository.findCompanyById(id));
    }

    @Override
    public void deleteCompany(Integer id) {
        companyRepository.deleteCompanyById(id);
    }
}