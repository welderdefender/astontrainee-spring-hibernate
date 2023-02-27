package ru.example.astonhibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.example.astonhibernate.dao.AirportCodeDao;
import ru.example.astonhibernate.model.AirportCodes;

import java.util.List;

@Repository
public class AirportCodeDaoImpl implements AirportCodeDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addAirportCode(AirportCodes airportCodes) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(airportCodes);
    }

    public void updateAirportCode(AirportCodes airportCodes) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(airportCodes);
    }

    public void removeAirportCode(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        AirportCodes airportCodes = (AirportCodes) session.load(AirportCodes.class, id);
        if (airportCodes != null) {
            session.delete(airportCodes);
        }
    }

    public AirportCodes getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        AirportCodes airportCodes = (AirportCodes) session.load(AirportCodes.class, id);
        return airportCodes;
    }

    public List<AirportCodes> listOfAirportCodes() {
        Session session = this.sessionFactory.getCurrentSession();
List<AirportCodes> airportCodesList = session.createQuery("from airport_codes").list();

        return null;
    }
}
