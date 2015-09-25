package com.allere.hibernate.sample;

import com.allere.hibernate.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by G_dragon on 2015/7/15.
 */
public class HelloNonAnnotationHibernate {

    public static void main(String[] args) {

        Configuration hibernateCfg = null;
        SessionFactory sessionFactory = null;
        Session session = null;

        /**
         * ����һ����ʵ��
         */
        Student s = new Student();
        //s.setId(2);
        s.setName("Json");
        s.setAge(21);

        /**
         * org.hibernate.cfg.Configuration������ã�
         * ��ȡhibernate�����ļ�(hibernate.cfg.xml��hiberante.properties)��.
         * new Configuration()Ĭ���Ƕ�ȡhibernate.properties
         * ����ʹ��new Configuration().configure();����ȡhibernate.cfg.xml�����ļ�
         */
        hibernateCfg = new Configuration().configure();

        /**
         * ����SessionFactory
         * һ�����ݿ��Ӧһ��SessionFactory
         * SessionFactory�����̰߳�ȫ�ġ�
         */


        sessionFactory = hibernateCfg.buildSessionFactory();

        try {
            /**
             * ����session
             * �˴���session������web�е�session
             * sessionֻ������ʱ���Ž���concation,session�������档
             * session����󣬱���رա�
             * session�Ƿ��̰߳�ȫ��һ����һ������һ��session.
             */

            session = sessionFactory.openSession();

            /**
             * �ֶ���������(������hibernate.cfg.xml�����ļ��������Զ���������)
             * 1.��hibernate����Ĳ�����Ӧ�÷ŵ���������ȥ����
             * 2.�ֶ����Զ���������... ... ...
             */
            session.beginTransaction();
			/**
			 * �������ݣ��˴��������Ǳ�����������hibernate��������ĺô���
			 * ���ǲ���д��ô���JDBC���룬ֻҪ����session������������hibernat��δ��ڶ����ⲻ��Ҫ����ȥ��������
			 * ��Щ����hibernate����ɡ�����ֻҪ�����󴴽���󣬽���hibernate�Ϳ����ˡ�
			 */
            session.save(s);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            //�ع�����
            session.getTransaction().rollback();
        } finally {
            //�ر�session
            session.close();
            sessionFactory.close();
        }
    }


}
