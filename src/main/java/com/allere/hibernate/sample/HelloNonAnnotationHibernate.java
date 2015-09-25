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
         * 生成一个类实例
         */
        Student s = new Student();
        //s.setId(2);
        s.setName("Json");
        s.setAge(21);

        /**
         * org.hibernate.cfg.Configuration类的作用：
         * 读取hibernate配置文件(hibernate.cfg.xml或hiberante.properties)的.
         * new Configuration()默认是读取hibernate.properties
         * 所以使用new Configuration().configure();来读取hibernate.cfg.xml配置文件
         */
        hibernateCfg = new Configuration().configure();

        /**
         * 创建SessionFactory
         * 一个数据库对应一个SessionFactory
         * SessionFactory是线线程安全的。
         */


        sessionFactory = hibernateCfg.buildSessionFactory();

        try {
            /**
             * 创建session
             * 此处的session并不是web中的session
             * session只有在用时，才建立concation,session还管理缓存。
             * session用完后，必须关闭。
             * session是非线程安全，一般是一个请求一个session.
             */

            session = sessionFactory.openSession();

            /**
             * 手动开启事务(可以在hibernate.cfg.xml配置文件中配置自动开启事务)
             * 1.在hibernate里面的操作都应该放到事物里面去进行
             * 2.手动和自动的区别不详... ... ...
             */
            session.beginTransaction();
			/**
			 * 保存数据，此处的数据是保存对象，这就是hibernate操作对象的好处，
			 * 我们不用写那么多的JDBC代码，只要利用session操作对象，至于hibernat如何存在对象，这不需要我们去关心它，
			 * 这些都有hibernate来完成。我们只要将对象创建完后，交给hibernate就可以了。
			 */
            session.save(s);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            //回滚事务
            session.getTransaction().rollback();
        } finally {
            //关闭session
            session.close();
            sessionFactory.close();
        }
    }


}
