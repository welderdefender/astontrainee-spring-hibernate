package ru.example.astonhibernate.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.example.astonhibernate.config.HibernateConfig;
import ru.example.astonhibernate.model.User;

import java.util.List;

@Repository
public class UserRepository {
    private final SessionFactory sessionFactory = HibernateConfig.createSessionFactory();

    public List<User> getAllUser() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<User> users = session.createQuery("from User ").getResultList();
        session.getTransaction().commit();
        return users;
    }

    public User getUserById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.getTransaction().commit();
        return user;
    }

    public void saveOrUpdateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
    }

    public void deleteUser(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("delete from users where user_id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }
}