package com.allere.hibernate.sample;

import com.allere.hibernate.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * Created by G_dragon on 2015/7/15.
 */
public class HelloAnnotationHibernate {

    public static void main(String[] args) {
        Teacher t = new Teacher();
        t.setId(1);
        t.setName("s1");
        t.setTitle("中级");
        //注此处并不是使用org.hibernate.cfg.Configuration来创建Configuration
//而使用org.hibernate.cfg.AnnotationConfiguration来创建Configuration，这样就可以使用Annotation功能
        Configuration cfg = new AnnotationConfiguration();

        SessionFactory sf = cfg.configure().buildSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();

        session.close();
        sf.close();
    }

}
