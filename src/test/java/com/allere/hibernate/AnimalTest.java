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
         * 如果在load过程中key对应的记录不是load的子类对象，load会抛出notFound异常
         */
        Pig pig =(Pig)session.load(Pig.class, 1);
        System.out.println("pig.name=" + pig.getName());
        System.out.println("pig.weight=" + pig.getWeight());

        Bird bird =(Bird)session.load(Bird.class, 2);
        System.out.println("bird.name=" + bird.getName());
        System.out.println("bird.height=" + bird.getHeight());


        /*******************************************************************
         * 多态查询，加载父类对象，判断子类类型, load lazy=false的情况下支持多态查询
         */
        Animal animal =(Animal)session.load(Animal.class, 1);

        //因为在上面返回的是一个代理类(父类的一个子类)，所以animal不是Pig
        //通过instanceof是反应不出正直的对象类型的，因此load在默认情况下是不支持多态查询的。
        if (animal instanceof Pig) {
            System.out.println("This animal is a pig");
        } else {
            System.out.println("This animal is not a pig");//这就是结果
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
            //能够正确鉴别出正直的类型，HQL是支持多态查询的。
            if (a instanceof Pig) {
                System.out.println("It's a Pig");
            } else if (a instanceof Bird) {
                System.out.println("It's a Bird");
            }
        }
    }

}
