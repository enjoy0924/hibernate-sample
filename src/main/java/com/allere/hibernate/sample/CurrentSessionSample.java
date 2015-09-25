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
        t.setTitle("中级");
        t.setSex(EnumSex.FEMALE);
        t.setUpdatetime(new Date(0));
        /**
         * 在使用getCurrentSession的时候需要配置hibernate.hbm.xml里面的
         * <property name="current_session_context_class"></property>
         * 属性
         *
         * 使用SessionFactory.getCurrentSession()方法来获得Session时，当事务结束
         * 的时候，不管是提交还是回滚事务，hibernate会自动关闭Session的，不需要手动关闭
         *
         * session.close()会抛出异常
         */
        Session session = sf.getCurrentSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();

        //session.close();

    }

}
