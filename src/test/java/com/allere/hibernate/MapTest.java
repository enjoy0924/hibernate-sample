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
        // 如果先不保存idCard，则出抛出Transient异常，因为idCard不是持久化状态。
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
         * 加载双向映射对象
         */
        IdCard idCard1 = (IdCard) session.load(IdCard.class, 1);

        System.out.println("============"+idCard1.getPerson().getName()+"=============");

        session.getTransaction().commit();
        if (null != session && session.isOpen())
            session.close();
    }

}
