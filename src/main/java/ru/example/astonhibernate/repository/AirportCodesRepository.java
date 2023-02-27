package ru.example.astonhibernate.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.example.astonhibernate.config.HibernateConfig;
import ru.example.astonhibernate.model.AirportCodes;

import java.util.List;

@Repository
public class AirportCodesRepository {
    private final SessionFactory sessionFactory = HibernateConfig.createSessionFactory();

    public List<AirportCodes> getAllAirportCodes() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<AirportCodes> airportCodes = session.createQuery("from airport_codes ").getResultList();
        session.getTransaction().commit();
        return airportCodes;
    }

    public void saveOrUpdateAirportCodes(AirportCodes airportCodes) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(airportCodes);
        session.getTransaction().commit();
    }

    public AirportCodes findAirportCodesById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        AirportCodes airportCodes = session.get(AirportCodes.class, id);
        session.getTransaction().commit();
        return airportCodes;
    }

    public void deleteAirportCodesById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("delete from airport_codes where airport_code_id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }
}