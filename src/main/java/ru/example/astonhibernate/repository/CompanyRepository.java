package ru.example.astonhibernate.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.example.astonhibernate.config.HibernateConfig;
import ru.example.astonhibernate.model.Company;

import java.util.List;

@Repository
public class CompanyRepository {
    private final SessionFactory sessionFactory = HibernateConfig.createSessionFactory();

    public List<Company> getAllCompany() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Company> companies = session.createQuery("from company ").getResultList();
        session.getTransaction().commit();
        return companies;
    }

    public Company findCompanyById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Company company = session.get(Company.class, id);
        session.getTransaction().commit();
        return company;
    }

    public void saveOrUpdateCompany(Company company) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(company);
        session.getTransaction().commit();
    }

    public Company getCompanyById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Company company = session.get(Company.class, id);
        session.getTransaction().commit();
        return company;
    }

    public void deleteCompanyById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("delete from company where company_id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }
}