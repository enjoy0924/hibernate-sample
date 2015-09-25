package com.allere.hibernate;

import com.allere.hibernate.entity.Animal;
import com.allere.hibernate.entity.Bird;
import com.allere.hibernate.entity.Pig;
import org.hibernate.Session;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * Created by G_dragon on 2015/7/16.
 */
public class AnimalTest extends TestBase {

    @Test
    public void testAnimalDrviedSave(){
        Session session = GetSession();

        session.beginTransaction();

        Pig pig = new Pig();
        pig.setName("SweetyPig");
        pig.setSex(true);
        pig.setWeight(100);
        session.save(pig);

        Bird bird = new Bird();
        bird.setName("HoneyBird");
        bird.setSex(false);
        bird.setHeight(50);
        session.save(bird);

        session.getTransaction().commit();
    }

    @Test
    public void testAnimalDrviedLoad(){

        Session session = GetSession();

        session.beginTransaction();

        /******************************************************************
         * �����load������key��Ӧ�ļ�¼����load���������load���׳�notFound�쳣
         */
        Pig pig =(Pig)session.load(Pig.class, 1);
        System.out.println("pig.name=" + pig.getName());
        System.out.println("pig.weight=" + pig.getWeight());

        Bird bird =(Bird)session.load(Bird.class, 2);
        System.out.println("bird.name=" + bird.getName());
        System.out.println("bird.height=" + bird.getHeight());


        /*******************************************************************
         * ��̬��ѯ�����ظ�������ж���������, load lazy=false�������֧�ֶ�̬��ѯ
         */
        Animal animal =(Animal)session.load(Animal.class, 1);

        //��Ϊ�����淵�ص���һ��������(�����һ������)������animal����Pig
        //ͨ��instanceof�Ƿ�Ӧ������ֱ�Ķ������͵ģ����load��Ĭ��������ǲ�֧�ֶ�̬��ѯ�ġ�
        if (animal instanceof Pig) {
            System.out.println("This animal is a pig");
        } else {
            System.out.println("This animal is not a pig");//����ǽ��
        }
        System.out.println("animal.name=" + animal.getName());
        System.out.println("animal.sex=" + animal.isSex());


        session.getTransaction().commit();
    }

    @Test
    public void testGetAllAnimals(){
        Session session = GetSession();
        List animalList = session.createQuery("from Animal").list();
        for (Iterator iter = animalList.iterator(); iter.hasNext();) {
            Animal a = (Animal)iter.next();
            //�ܹ���ȷ�������ֱ�����ͣ�HQL��֧�ֶ�̬��ѯ�ġ�
            if (a instanceof Pig) {
                System.out.println("It's a Pig");
            } else if (a instanceof Bird) {
                System.out.println("It's a Bird");
            }
        }
    }

}
