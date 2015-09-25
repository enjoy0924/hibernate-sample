package com.allere.hibernate.sample;

import com.allere.hibernate.entity.Teacher;
import com.allere.hibernate.entity.denpends.EnumSex;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import java.sql.Date;

/**
 * Created by G_dragon on 2015/7/16.
 */
public class CurrentSessionSample {

    public static void main(String args[]){

        Configuration cfg = new AnnotationConfiguration();

        SessionFactory sf = cfg.configure().buildSessionFactory();

        Teacher t = new Teacher();
        //t.setId(39);
        t.setName("Abby");
        t.setTitle("�м�");
        t.setSex(EnumSex.FEMALE);
        t.setUpdatetime(new Date(0));
        /**
         * ��ʹ��getCurrentSession��ʱ����Ҫ����hibernate.hbm.xml�����
         * <property name="current_session_context_class"></property>
         * ����
         *
         * ʹ��SessionFactory.getCurrentSession()���������Sessionʱ�����������
         * ��ʱ�򣬲������ύ���ǻع�����hibernate���Զ��ر�Session�ģ�����Ҫ�ֶ��ر�
         *
         * session.close()���׳��쳣
         */
        Session session = sf.getCurrentSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();

        //session.close();

    }

}
