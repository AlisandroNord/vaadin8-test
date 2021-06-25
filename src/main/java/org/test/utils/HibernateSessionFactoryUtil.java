package org.test.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.test.entity.Client;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;
    private HibernateSessionFactoryUtil(){}
    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null) {
            try{
                Configuration configuration = new Configuration();
                configuration.addAnnotatedClass(Client.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
    public Session getSession(){
        Session currentSession = getSessionFactory().getCurrentSession();
        if(!currentSession.getTransaction().isActive()){
            currentSession.beginTransaction();
        }
        return currentSession;
    }
}
