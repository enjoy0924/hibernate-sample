package com.allere.hibernate;

import com.allere.hibernate.entity.Contact;
import com.allere.hibernate.entity.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by G_dragon on 2015/7/16.
 */
public class StudentTest extends TestBase {

    /**
     * 1.���е�update���������������ŵ���update()����������hibernate���ύ�����ʱ���Զ�update�־û�����Ĳ������Ǹ�������������һ����¼��
     */

    @Test
    public void testStudentUpdate(){
        /**
         * �١���������detached���󣬸�����ɺ�תΪΪpersistent״̬(Ĭ�ϸ���ȫ���ֶ�)
         * �ڡ�����transient����ᱨ��(û��ID)
         * �ۡ������Լ��趨ID��transient�������(Ĭ�ϸ���ȫ���ֶ�)
         * �ܡ�persistent״̬�Ķ���ֻҪ�趨�ֶβ�ͬ��ֵ����session�ύʱ�����Զ�����(Ĭ�ϸ���ȫ���ֶ�)
         * �ݡ����²��ָ��µ��ֶ�(�������ĸ��ֶξ͸����ĸ��ֶε�����)
         */

        Session session = GetSession();
        session.beginTransaction();
        Student s =(Student)session.get(Student.class, 0);
        s.setName("zhangsan5");
        //�ύʱ����ֻ����name�ֶΣ���Ϊ��ʱ��sΪpersistent״̬
        session.getTransaction().commit();
        if (null != session && session.isOpen())
            session.close();

        System.out.println("========================");

        s.setName("z4");
        Session session2 = GetSession();
        session2.beginTransaction();
        //����ʱ����������е��ֶΣ���Ϊ��ʱ��s����persistent״̬
        session2.update(s);
        session2.getTransaction().commit();

        if (null != session2 && session2.isOpen())
            session2.close();

    }

    @Test
    public void testStudentUpdate2(){
        /**
         * ������Ȼʹ��merge()ʵ���˵ڶ�����ͬ�ֶεĸ��£�������Ҫ����һ��select��ѯ�Ĵ��۱Ƚ���Щ�ֶθ��Ĺ�
         */
        Session session = GetSession();
        session.beginTransaction();
        Student s =(Student)session.get(Student.class, 3);
        s.setName("zhangsan6");
        session.getTransaction().commit();

        s.setName("Abby");
        Session session2 = GetSession();
        session2.beginTransaction();
        session2.merge(s);
        session2.getTransaction().commit();
    }

    /**
     * ʹ����������HQL���������ݿ�ĸ���
     */
    @Test
    public void testStudentUpdateHQL(){
        Session session = GetSession();
        session.beginTransaction();
        Query q =session.createQuery(
                "update Student s set s.name='Andy' where s.id = 2");
        q.executeUpdate();
        session.getTransaction().commit();
        if (session != null && session.isOpen())
            session.close();
    }

    @Test
    public void testStudentSaveOrUpdate(){
        Session session = GetSession();
        session.beginTransaction();

        Student student = new Student();
        student.setId(3);
        student.setName("Json");
        student.setAge(26);

        Contact contact = new Contact();
        contact.setEmail("enjoy0924@163.com");
        contact.setAddress("Chengdu City in China");
        contact.setZipCode("400050");
        contact.setTel("028-82204998");
        student.setContact(contact);

        /**
         * saveOrUpdate����Ҫ��ID [primary key]Ϊnullʱ��ִ��SAVE�� �����������ִ��UPDATE��
         * ִ��update��ʱ����update�����ֶΣ�����ʹ�����������ʱ����������֪����Щ�ֶ��ǲ��ܱ���
         * �ĵģ����Ҹ���ԭ�е�ֵ
         */
        session.saveOrUpdate(student);

        session.getTransaction().commit();

        if (session != null && session.isOpen())
            session.close();
    }
}
