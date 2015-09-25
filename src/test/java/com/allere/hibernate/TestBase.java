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

    @BeforeClass//表示Junit此类被加载到内存中就执行这个方法
    public static void beforClass(){
        sf = new AnnotationConfiguration().configure().buildSessionFactory();
    }

    @AfterClass//Junit在类结果时，自动关闭
    public static void afterClass(){
        sf.close();
    }
}

