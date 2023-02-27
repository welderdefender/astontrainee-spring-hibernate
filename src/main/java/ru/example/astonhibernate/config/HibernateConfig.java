package ru.example.astonhibernate.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ru.example.astonhibernate.model.AirportCodes;
import ru.example.astonhibernate.model.Company;
import ru.example.astonhibernate.model.Flight;
import ru.example.astonhibernate.model.User;

public class HibernateConfig {
    public static SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Flight.class);
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(AirportCodes.class);
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}