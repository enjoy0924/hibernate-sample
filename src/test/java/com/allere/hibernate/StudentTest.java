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
     * 1.所有的update操作，不管是明着调用update()函数，还是hibernate在提交事物的时候自动update持久化对象的操作都是根据主键来更新一条记录的
     */

    @Test
    public void testStudentUpdate(){
        /**
         * ①、用来更新detached对象，更新完成后转为为persistent状态(默认更新全部字段)
         * ②、更新transient对象会报错(没有ID)
         * ③、更新自己设定ID的transient对象可以(默认更新全部字段)
         * ④、persistent状态的对象，只要设定字段不同的值，在session提交时，会自动更新(默认更新全部字段)
         * ⑤、更新部分更新的字段(更改了哪个字段就更新哪个字段的内容)
         */

        Session session = GetSession();
        session.beginTransaction();
        Student s =(Student)session.get(Student.class, 0);
        s.setName("zhangsan5");
        //提交时，会只更新name字段，因为此时的s为persistent状态
        session.getTransaction().commit();
        if (null != session && session.isOpen())
            session.close();

        System.out.println("========================");

        s.setName("z4");
        Session session2 = GetSession();
        session2.beginTransaction();
        //更新时，会更新所有的字段，因为此时的s不是persistent状态
        session2.update(s);
        session2.getTransaction().commit();

        if (null != session2 && session2.isOpen())
            session2.close();

    }

    @Test
    public void testStudentUpdate2(){
        /**
         * 这里虽然使用merge()实现了第二个不同字段的更新，但是需要付出一次select查询的代价比较哪些字段更改过
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
     * 使用面向对象的HQL语句进行数据库的更新
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
         * saveOrUpdate方法要求ID [primary key]为null时才执行SAVE， 在其它情况下执行UPDATE。
         * 执行update的时候是update所有字段，所以使用这个方法的时候最好清楚的知道哪些字段是不能被修
         * 改的，并且附上原有的值
         */
        session.saveOrUpdate(student);

        session.getTransaction().commit();

        if (session != null && session.isOpen())
            session.close();
    }
}
