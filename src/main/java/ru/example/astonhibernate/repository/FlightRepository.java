package ru.example.astonhibernate.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.example.astonhibernate.config.HibernateConfig;
import ru.example.astonhibernate.model.Flight;
import ru.example.astonhibernate.model.dto.users_flights.UsersFlightsDtoRq;

import java.util.List;

@Repository
public class FlightRepository {
    private final SessionFactory sessionFactory = HibernateConfig.createSessionFactory();

    public List<Flight> getAllFlights() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Flight> flights = session.createQuery("from Flight ").getResultList();
        session.getTransaction().commit();
        return flights;
    }

    public void saveOrUpdateFlight(Flight flight) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(flight);
        session.getTransaction().commit();
    }

    public Flight getFlightById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Flight flight = session.get(Flight.class, id);
        session.getTransaction().commit();
        return flight;
    }

    public void deleteFlightById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("delete from Flight where flightId = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public List<Flight> getUsersFlights() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Flight> flights = session.createQuery("SELECT DISTINCT f FROM " +
                "Flight f JOIN FETCH f.users").getResultList();
        session.getTransaction().commit();
        return flights;
    }

    public void deleteUsersFlights(Integer user_id, Integer flight_id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createNativeQuery(
                    "DELETE FROM users_flights WHERE user_id = ? AND flight_id = ?");
            query.setParameter(1, user_id);
            query.setParameter(2, flight_id);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void saveUsersFlights(UsersFlightsDtoRq usersFlightsDtoRq) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session
                .createNativeQuery("INSERT INTO users_flights (user_id, flight_id) values (?,?)");
        query.setParameter(1, usersFlightsDtoRq.getUserId());
        query.setParameter(2, usersFlightsDtoRq.getFlightId());
        query.executeUpdate();
        session.getTransaction().commit();
    }
}