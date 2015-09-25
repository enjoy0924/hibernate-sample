package com.allere.hibernate;

import com.allere.hibernate.entity.Teacher;
import com.allere.hibernate.entity.denpends.EnumSex;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.Test;

import java.sql.Date;
import java.util.UUID;

/**
 * Created by G_dragon on 2015/7/15.
 */
public class TeacherTest extends TestBase {

    @Test//表示下面的方法是测试用的。
    public void testTeacherSave(){

        int loopTime = 1000;
        while(loopTime-- != 0) {
            long loopTimes = 10000;
            Session session = GetSession();
            session.beginTransaction();
            while (loopTimes--!= 0) {
                Teacher t = new Teacher();
                t.setName(UUID.randomUUID().toString());
                t.setTitle(UUID.randomUUID().toString());
                t.setSex(EnumSex.FEMALE);
                t.setUpdatetime(new Date(0));
                /**
                 * save(Object)保存对象到数据库，这个方法产生对象的三种状态
                 */
                session.save(t);

                if (loopTimes % 100 == 0) {
                    System.out.println(loopTimes);
                    session.flush();
                }

            }

            session.getTransaction().commit();

            session.close();
        }
    }

    @Test
    public void testTeacherDel(){
        Teacher t = new Teacher();
        t.setId(3);  //针对主键设置删除的记录

        //t.setName("Abby");  //无效设置

        Session session = GetSession();

        session.beginTransaction();

        /**
         * delete(Object)，这个方法会根据对象的ID值进行数据的删除
         * 对象删除以后，对象的状态会是Transistent状态
         */
        session.delete(t);
        session.getTransaction().commit();

        session.close();

    }

    @Test
    public void testTeacherLoad(){
        Session session = GetSession();

        session.beginTransaction();

        /**
         * load(Class arg0 , java.io.Serializable arg1)
         * arg0:需要加载对象的类，例如：User.class
         * arg1:查询条件(实现了序列化接口的对象)：这个值指的是根据主键进行数据加载，一次只能加载一条记录
         * 例"4028818a245fdd0301245fdd06380001"字符串已经实现了序列化接口。如果是数值类类型，则hibernate会自动使用包装类，例如 1
         *
         * 此方法返回类型为Object，但返回的是代理对象。
         * 执行此方法时不会立即发出查询SQL语句。只有在使用对象时，它才发出查询SQL语句，加载对象。
         * 因为load方法实现了lazy(称为延迟加载、赖加载)
         * 延迟加载：只有真正使用这个对象的时候，才加载(才发出SQL语句)
         * hibernate延迟加载实现原理是代理方式。
         * 采用load()方法加载数据，如果数据库中没有相应的记录，则会抛出异常对象不找到(org.hibernate.ObjectNotFoundException)
         */
        int idPrimaryKey = 2;
        try {
            Teacher teacher = (Teacher) session.load(Teacher.class, idPrimaryKey);

            System.out.println("==============Not Execute SQL Before================");
            session.getTransaction().commit();

            /**
             * 虽然使用代理进行延迟加载但是必须要确保使用的session为打开状态,在使用这个对象的时候才开始执行SQL语句对数据库进行查询
             */
            System.out.println(teacher.getId() + " : " + teacher.getName());
        }catch(HibernateException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            if (session != null && session.isOpen())
                session.close();
        }
    }


    @Test
    public void testTeacherGet(){

        Session session = GetSession();

        session.beginTransaction();

        /**
         * Get(Class arg0, java.io.Serializable arg1)，这个方法会根据对象的ID值进行数据的删除
         * 与load的区别在于执行SQL的时机以及找不到指定对象时的返回方式，
         *
         * load会直接抛出找不到记录的异常
         * get会直接返回一个null
         *
         * load和get都只能根据主键查询，如果需要根据其他字段进行查询，需要使用HQL查询语句
         */
        int idPrimaryKey = 2;
        Teacher teacher =  (Teacher)session.get(Teacher.class, idPrimaryKey);

        System.out.println("=========Execute SQL After===============");

        if (null != teacher)
            System.out.println(teacher.getId()+" : "+teacher.getName());
        else
            System.out.println("================GET NULL=====================");

        session.getTransaction().commit();

        session.close();

    }

    @Test
    public void testSessionClear(){
        /**
         * 无论是load还是get，都会首先查找缓存(一级缓存，也叫session级缓存)，如果没有，才会去数据库查找，调用clear()方法可以强制清除session缓存
         */

        /**
         * Session Flush模式的开启必须在事务开启之前
         *  <a>、清理缓存；并不是清除缓存对象
         *  <b>、执行sql(确定是执行SQL语句(确定生成update、insert、delete语句等),然后执行SQL语句。)
         */
        Session session= GetSession();
        /**
         * ->FlushMode.ALWAYS：任务一条SQL语句，都会flush一次
         * ->FlushMode.AUTO  ：自动flush(默认)
         * ->FlushMode.COMMIT: 只有在commit时才flush
         * ->FlushMode.MANUAL：手动flush。
         * ->FlushMode.NEVER ：永远不flush  此选项在性能优化时可能用，比如session取数据为只读时用，这样就
         */
        session.setFlushMode(FlushMode.MANUAL);

        session.beginTransaction();
        Teacher t =(Teacher)session.load(Teacher.class, 1);
        System.out.println(t.getName());

        /**
         * 注意：这样就会发出两条SELECT语句，如果把session.clear()去除，则只会发出一条SELECT语句，
         * 因为第二次load时，是使用session缓存中ID为1的对象，而这个对象已经在第一次load到缓存中了
         */
        //session.clear();
        //session.flush();        //
        //session.evict(t);     //从缓存中剔除某个对象，不需要清除所有缓存对象

        t.setName("Andy");    //如果不使用session.clear清除缓存，那么本次修改将为持久化对象的修改，下一次获取的值将为Andy，与前一次的load结果不同

        Teacher t2 =(Teacher)session.load(Teacher.class, 1);
        System.out.println(t2.getName());
        session.getTransaction().commit();
    }

}
