package com.allere.hibernate;

import com.allere.hibernate.entity.denpends.EnumSex;
import com.allere.hibernate.entity.Teacher;
import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.*;

import java.sql.Date;

/**
 * Created by G_dragon on 2015/7/15.
 */
public class TestBase {

    private static SessionFactory sf = null;

    public static Session GetSession(){
        return sf.openSession();
    }

    @BeforeClass//��ʾJunit���౻���ص��ڴ��о�ִ���������
    public static void beforClass(){
        sf = new AnnotationConfiguration().configure().buildSessionFactory();
    }

    @AfterClass//Junit������ʱ���Զ��ر�
    public static void afterClass(){
        sf.close();
    }
}

