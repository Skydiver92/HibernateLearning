package com.kuzmenko.hibernatelearning.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.Configuration;

public class HibernateUtil {
    public   SessionFactory sessionFactory = null;
    public Session session = null;

    public Session getSession() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        sessionFactory = meta.getSessionFactoryBuilder().build();
        session = sessionFactory.openSession();


        return session;
    }


    public void closeSession() {
        sessionFactory.close();
        session.close();
    }
}
