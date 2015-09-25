package com.allere.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Created by G_dragon on 2015/7/16.
 */
public class HibernateUtils {

    private static SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();

    public static Session getSession() {
        if (null != sf)
            return sf.openSession();
        return null;
    }

    public static void closeSession(Session session) {
        if (null != session && session.isOpen())
            session.close();
    }
}
