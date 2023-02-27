package ru.example.astonhibernate.model.dto.company;

public class CompanyDtoRs {
    private int companyId;
    private String name;

    public CompanyDtoRs(int companyId, String name) {
        this.companyId = companyId;
        this.name = name;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}