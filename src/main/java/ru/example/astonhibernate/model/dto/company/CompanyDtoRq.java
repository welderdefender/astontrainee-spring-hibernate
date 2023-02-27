package ru.example.astonhibernate.model.dto.company;

public class CompanyDtoRq {
    private int companyId;
    private String name;

    public CompanyDtoRq() {
    }

    public CompanyDtoRq(int companyId, String name) {
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

    @Override
    public String toString() {
        return "CompanyDtoRq{" +
                "companyId=" + companyId +
                ", name='" + name + '\'' +
                '}';
    }
}