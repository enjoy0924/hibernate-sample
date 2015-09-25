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
        session.save(group); //如果没有使用cascade配置的话，必须先存储Group对象。这个时候的group状态为persistent，已经有了ID值

        User user1 = new User();
        user1.setName("Andy");
        user1.setGroup(group);//设置用户所属的组

        User user2 = new User();
        user2.setName("Abby");
        user2.setGroup(group);//设置用户所属的组

        //开始存储
        session.save(user1);//存储用户
        session.save(user2);

        session.getTransaction().commit();
    }

    @Test
    public void testUserGroupCascade(){
        /**
         * 因为配置了cascade，所以数据在存储的时候会首先将依赖的记录存储
         */
        Session session = GetSession();
        session.beginTransaction();

        Group group = new Group();
        group.setName("GroupBig2222");

        User user1 = new User();
        user1.setName("Andy222");
        user1.setGroup(group);//设置用户所属的组

        User user2 = new User();
        user2.setName("Abby222");
        user2.setGroup(group);//设置用户所属的组

        //开始存储
        session.save(user1);//存储用户
        session.save(user2);

        session.getTransaction().commit();
    }
}
