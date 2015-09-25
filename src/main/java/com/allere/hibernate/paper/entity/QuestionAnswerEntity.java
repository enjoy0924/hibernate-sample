package com.allere.hibernate.paper.entity;

import com.allere.hibernate.paper.CONST;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用来存储每一个试题对应的答案，来自作业[试题]库的一个拷贝,如果
 * 本地数据库没有的话，需要向作业[试题]库发起一个答案请求
 *
 * 需要解决的问题：
 * 问题与正确答案的对应关系
 *
 * Created by G_dragon on 2015/8/4.
 */
@Entity
@Table(name = "QBU_ANSWER_KEY")
public class QuestionAnswerEntity {

    private String id;               //
    private String questionId;       //题目ID，由试题库返回
    private String answerKey;        //题目对应的参考答案
    private int gradeType = CONST.QUESTION_AUTO_GRADING; //批改方式，默认为自动批改

    @Id
    @Column(length = 64)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(length = 64)
    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public int getGradeType() {
        return gradeType;
    }

    public void setGradeType(int gradeType) {
        this.gradeType = gradeType;
    }

    public String getAnswerKey() {
        return answerKey;
    }

    public void setAnswerKey(String answerKey) {
        this.answerKey = answerKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionAnswerEntity that = (QuestionAnswerEntity) o;

        if (gradeType != that.gradeType) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (questionId != null ? !questionId.equals(that.questionId) : that.questionId != null) return false;
        return !(answerKey != null ? !answerKey.equals(that.answerKey) : that.answerKey != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (questionId != null ? questionId.hashCode() : 0);
        result = 31 * result + (answerKey != null ? answerKey.hashCode() : 0);
        result = 31 * result + gradeType;
        return result;
    }
}
