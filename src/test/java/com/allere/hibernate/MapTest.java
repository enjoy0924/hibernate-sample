package com.allere.hibernate;

import com.allere.hibernate.entity.IdCard;
import com.allere.hibernate.entity.Person;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by G_dragon on 2015/7/16.
 */
public class MapTest extends TestBase {

    @Test
    public void testMapPersonCard(){
        Session session = GetSession();
        IdCard idCard = new IdCard();
        idCard.setCardNo("510724198809244313");
        session.beginTransaction();
        // ����Ȳ�����idCard������׳�Transient�쳣����ΪidCard���ǳ־û�״̬��
        session.save(idCard);
        Person person = new Person();
        person.setName("Json");
        person.setIdCard(idCard);
        session.save(person);
        session.getTransaction().commit();

        if (null != session && session.isOpen())
            session.close();
    }

    @Test
    public void testMapCardLoad(){
        Session session = GetSession();
        session.beginTransaction();
        /**
         * ����˫��ӳ�����
         */
        IdCard idCard1 = (IdCard) session.load(IdCard.class, 1);

        System.out.println("============"+idCard1.getPerson().getName()+"=============");

        session.getTransaction().commit();
        if (null != session && session.isOpen())
            session.close();
    }

}
