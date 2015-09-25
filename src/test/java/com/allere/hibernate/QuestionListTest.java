package com.allere.hibernate;

import com.allere.hibernate.entity.QuestionEntity;
import com.allere.hibernate.entity.TagEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

/**
 * Created by G_dragon on 2015/7/17.
 */
public class QuestionListTest extends TestBase {

    @Test
    public void testQueryQuestionById(){

        //String hql = "from QuestionEntity where ";

        Session session = GetSession();
        session.beginTransaction();

        /**
         * 从标签端查询这个标签下面的所有问题，父子标签
         */
        String tagId = "a0a198bf-dc48-4dad-b59e-8bc22dc9dc55";
        TagEntity tag = (TagEntity) session.get(TagEntity.class, tagId);

        /**
         * 从问题端查询这个问题所属的标签
         */
        String questionId = "2ef4beca-21b7-4d7d-bb86-e29a7dda0001";
        QuestionEntity question = (QuestionEntity) session.get(QuestionEntity.class, questionId);

        session.getTransaction().commit();
    }

    @Test
    public void testQueryQuestionByIds(){
        String hql = "from TagEntity where id in(:ids)";

        Session session = GetSession();
        session.beginTransaction();
        Query query = session.createQuery(hql);
        String[] tags = {"a0a198bf-dc48-4dad-b59e-8bc22dc9dc55", "d6851acf-711a-4ffe-b8ec-a90e10fd0ef6"};
        query.setParameterList("ids", tags);

        List<TagEntity> lsTag = query.list();

        session.getTransaction().commit();
    }

    /**
     * 并集分页排序查询测试
     */
    @Test
    public void testQueryQuestionByTagIds(){
        //String hql = "from QuestionEntity where tags.id in(:ids)";

        String hql = "select Q from QuestionEntity Q, TagEntity T where T.id =:ids and Q.id in elements(T.questionEntities) order by Q.id desc";

        String count = "select count(0) from QuestionEntity Q, TagEntity T where T.id in(:ids) and Q.id in elements(T.questionEntities)";

        String tagId = "a0a198bf-dc48-4dad-b59e-8bc22dc9dc55";

        Session session = GetSession();
        session.beginTransaction();

        Query queryCount = session.createQuery(count);
        queryCount.setParameter("ids", tagId);
        List c = queryCount.list();

        Long total = (Long) c.get(0);

        int pageSize = 50;

        int pages = (int)Math.ceil(total.doubleValue()/50);
        for(int curpage=0; curpage<pages; curpage++)
        {
            Query query = session.createQuery(hql);
            query.setFirstResult(curpage * pageSize);
            query.setMaxResults(pageSize);
            query.setParameter("ids", tagId);

            List<QuestionEntity> lsTag = query.list();

            System.out.println("["+lsTag.size()+"]"+lsTag.get(0).getId());
        }


        session.getTransaction().commit();
    }

    /**
     * 交集分页排序查询测试
     */
    @Test
    public void testQueryQuestionByTagIdsJoined(){

        //String hql = "select Q from QuestionEntity Q, TagEntity T where T.id in(:ids) and Q.id in elements(T.questionEntities) order by Q.id desc";

        String hql = "select Q from QuestionEntity Q, TagEntity T where T.id in(:ids) and T.id in elements(Q.tags) and Q.id in elements(T.questionEntities) order by Q.id desc";

        String count = "select count(0) from QuestionEntity Q, TagEntity T where T.id in(:ids) and T.id in elements(Q.tags) and Q.id in elements(T.questionEntities)";

        String[] tags = {"a0a198bf-dc48-4dad-b59e-8bc22dc9dc55", "d6851acf-711a-4ffe-b8ec-a90e10fd0ef6"};

        Session session = GetSession();
        session.beginTransaction();

        Query queryCount = session.createQuery(count);
        queryCount.setParameterList("ids", tags);
        List c = queryCount.list();

        Long total = (Long) c.get(0);

        int pageSize = 50;

        int pages = (int)Math.ceil(total.doubleValue()/50);
        for(int curpage=0; curpage<pages; curpage++)
        {
            Query query = session.createQuery(hql);
            query.setFirstResult(curpage * pageSize);
            query.setMaxResults(pageSize);
            query.setParameterList("ids", tags);

            List<QuestionEntity> lsTag = query.list();

            System.out.println("["+lsTag.size()+"]"+lsTag.get(0).getId());
        }


        session.getTransaction().commit();
    }
}
