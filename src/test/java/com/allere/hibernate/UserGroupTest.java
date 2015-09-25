package com.allere.hibernate;

import com.allere.hibernate.entity.Group;
import com.allere.hibernate.entity.User;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by G_dragon on 2015/7/16.
 */
public class UserGroupTest extends TestBase {

    @Test
    public void testUserGroupLoad(){
        Session session = GetSession();
        session.beginTransaction();

        User user = (User)session.load(User.class, 3);

        System.out.println("========"+user.getName()+"========="+user.getGroup().getName()+"=========");

        session.getTransaction().commit();
        if (null != session && session.isOpen())
            session.close();
    }

    @Test
    public void testUserGroup(){
        Session session = GetSession();
        session.beginTransaction();

        Group group = new Group();
        group.setName("GroupBig");
        session.save(group); //���û��ʹ��cascade���õĻ��������ȴ洢Group�������ʱ���group״̬Ϊpersistent���Ѿ�����IDֵ

        User user1 = new User();
        user1.setName("Andy");
        user1.setGroup(group);//�����û���������

        User user2 = new User();
        user2.setName("Abby");
        user2.setGroup(group);//�����û���������

        //��ʼ�洢
        session.save(user1);//�洢�û�
        session.save(user2);

        session.getTransaction().commit();
    }

    @Test
    public void testUserGroupCascade(){
        /**
         * ��Ϊ������cascade�����������ڴ洢��ʱ������Ƚ������ļ�¼�洢
         */
        Session session = GetSession();
        session.beginTransaction();

        Group group = new Group();
        group.setName("GroupBig2222");

        User user1 = new User();
        user1.setName("Andy222");
        user1.setGroup(group);//�����û���������

        User user2 = new User();
        user2.setName("Abby222");
        user2.setGroup(group);//�����û���������

        //��ʼ�洢
        session.save(user1);//�洢�û�
        session.save(user2);

        session.getTransaction().commit();
    }
}
