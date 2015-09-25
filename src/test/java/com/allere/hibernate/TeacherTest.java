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

    @Test//��ʾ����ķ����ǲ����õġ�
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
                 * save(Object)����������ݿ⣬��������������������״̬
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
        t.setId(3);  //�����������ɾ���ļ�¼

        //t.setName("Abby");  //��Ч����

        Session session = GetSession();

        session.beginTransaction();

        /**
         * delete(Object)�������������ݶ����IDֵ�������ݵ�ɾ��
         * ����ɾ���Ժ󣬶����״̬����Transistent״̬
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
         * arg0:��Ҫ���ض�����࣬���磺User.class
         * arg1:��ѯ����(ʵ�������л��ӿڵĶ���)�����ֵָ���Ǹ��������������ݼ��أ�һ��ֻ�ܼ���һ����¼
         * ��"4028818a245fdd0301245fdd06380001"�ַ����Ѿ�ʵ�������л��ӿڡ��������ֵ�����ͣ���hibernate���Զ�ʹ�ð�װ�࣬���� 1
         *
         * �˷�����������ΪObject�������ص��Ǵ������
         * ִ�д˷���ʱ��������������ѯSQL��䡣ֻ����ʹ�ö���ʱ�����ŷ�����ѯSQL��䣬���ض���
         * ��Ϊload����ʵ����lazy(��Ϊ�ӳټ��ء�������)
         * �ӳټ��أ�ֻ������ʹ����������ʱ�򣬲ż���(�ŷ���SQL���)
         * hibernate�ӳټ���ʵ��ԭ���Ǵ���ʽ��
         * ����load()�����������ݣ�������ݿ���û����Ӧ�ļ�¼������׳��쳣�����ҵ�(org.hibernate.ObjectNotFoundException)
         */
        int idPrimaryKey = 2;
        try {
            Teacher teacher = (Teacher) session.load(Teacher.class, idPrimaryKey);

            System.out.println("==============Not Execute SQL Before================");
            session.getTransaction().commit();

            /**
             * ��Ȼʹ�ô�������ӳټ��ص��Ǳ���Ҫȷ��ʹ�õ�sessionΪ��״̬,��ʹ����������ʱ��ſ�ʼִ��SQL�������ݿ���в�ѯ
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
         * Get(Class arg0, java.io.Serializable arg1)�������������ݶ����IDֵ�������ݵ�ɾ��
         * ��load����������ִ��SQL��ʱ���Լ��Ҳ���ָ������ʱ�ķ��ط�ʽ��
         *
         * load��ֱ���׳��Ҳ�����¼���쳣
         * get��ֱ�ӷ���һ��null
         *
         * load��get��ֻ�ܸ���������ѯ�������Ҫ���������ֶν��в�ѯ����Ҫʹ��HQL��ѯ���
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
         * ������load����get���������Ȳ��һ���(һ�����棬Ҳ��session������)�����û�У��Ż�ȥ���ݿ���ң�����clear()��������ǿ�����session����
         */

        /**
         * Session Flushģʽ�Ŀ���������������֮ǰ
         *  <a>�������棻����������������
         *  <b>��ִ��sql(ȷ����ִ��SQL���(ȷ������update��insert��delete����),Ȼ��ִ��SQL��䡣)
         */
        Session session= GetSession();
        /**
         * ->FlushMode.ALWAYS������һ��SQL��䣬����flushһ��
         * ->FlushMode.AUTO  ���Զ�flush(Ĭ��)
         * ->FlushMode.COMMIT: ֻ����commitʱ��flush
         * ->FlushMode.MANUAL���ֶ�flush��
         * ->FlushMode.NEVER ����Զ��flush  ��ѡ���������Ż�ʱ�����ã�����sessionȡ����Ϊֻ��ʱ�ã�������
         */
        session.setFlushMode(FlushMode.MANUAL);

        session.beginTransaction();
        Teacher t =(Teacher)session.load(Teacher.class, 1);
        System.out.println(t.getName());

        /**
         * ע�⣺�����ͻᷢ������SELECT��䣬�����session.clear()ȥ������ֻ�ᷢ��һ��SELECT��䣬
         * ��Ϊ�ڶ���loadʱ����ʹ��session������IDΪ1�Ķ��󣬶���������Ѿ��ڵ�һ��load����������
         */
        //session.clear();
        //session.flush();        //
        //session.evict(t);     //�ӻ������޳�ĳ�����󣬲���Ҫ������л������

        t.setName("Andy");    //�����ʹ��session.clear������棬��ô�����޸Ľ�Ϊ�־û�������޸ģ���һ�λ�ȡ��ֵ��ΪAndy����ǰһ�ε�load�����ͬ

        Teacher t2 =(Teacher)session.load(Teacher.class, 1);
        System.out.println(t2.getName());
        session.getTransaction().commit();
    }

}
