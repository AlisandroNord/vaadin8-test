package org.test.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.test.entity.Client;
import org.test.utils.HibernateSessionFactoryUtil;

import java.util.List;
import java.util.Optional;

public class ClientDao implements Dao<Client, Integer>{
    private final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    @Override
    public Client findById(Integer integer) {
        return sessionFactory.openSession().get(Client.class, integer);
    }

    @Override
    public void save(Client client) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(client);
        transaction.commit();
        session.close();
    }
    @Override
    public void update(Client client) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(client);
        transaction.commit();
        session.close();
    }
    @Override
    public void delete(Client client) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(client);
        transaction.commit();
        session.close();
    }
    @Override
    public List<Client> findAll() {
        return (List<Client>) sessionFactory.openSession().createQuery("From Client").list();
    }
}
