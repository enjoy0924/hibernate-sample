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
        t.setTitle("�м�");
        //ע�˴�������ʹ��org.hibernate.cfg.Configuration������Configuration
//��ʹ��org.hibernate.cfg.AnnotationConfiguration������Configuration�������Ϳ���ʹ��Annotation����
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
