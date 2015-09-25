package com.allere.hibernate.paper.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * �����洢��ҵ�·����:
 *
 * ������Ҫ����������ǣ�
 * �ĸ�ѧ������һ����ҵ����������Щ�⣬��Щ�������������ô���ģ�
 *
 * Created by G_dragon on 2015/8/4.
 */
@Entity
@Table(name = "QBU_STUDENT_SCORE_POINT")
public class StudentScorePointEntity {

    private String id;              //UUID
    private String assignee;        //����ҵ���˵�ID
    private String paperInstanceId; //��ҵ���������Σ���ʶһ����ҵ
    private String paperId;         //������������ҵ[�Ծ�]ID
    private String questionId;      //����ID
    private String scorePointId;    //�÷ֵ�ID
    private String answer;          //ѧ���÷ֵ��
    private int correctness;        //��ȷ���
    private double score;           //���ķ���

    private Date createTime;
    private Date updateTime;

    @Id
    @Column(length = 64)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(length = 64)
    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    @Column(length = 64, nullable = false)
    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    @Column(length = 64)
    public String getPaperInstanceId() {
        return paperInstanceId;
    }

    public void setPaperInstanceId(String paperInstanceId) {
        this.paperInstanceId = paperInstanceId;
    }

    @Column(length = 64)
    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    @Column(length = 64)
    public String getScorePointId() {
        return scorePointId;
    }

    public void setScorePointId(String scorePointId) {
        this.scorePointId = scorePointId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getCorrectness() {
        return correctness;
    }

    public void setCorrectness(int correctness) {
        this.correctness = correctness;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentScorePointEntity that = (StudentScorePointEntity) o;

        if (correctness != that.correctness) return false;
        if (Double.compare(that.score, score) != 0) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (assignee != null ? !assignee.equals(that.assignee) : that.assignee != null) return false;
        if (paperInstanceId != null ? !paperInstanceId.equals(that.paperInstanceId) : that.paperInstanceId != null)
            return false;
        if (paperId != null ? !paperId.equals(that.paperId) : that.paperId != null) return false;
        if (questionId != null ? !questionId.equals(that.questionId) : that.questionId != null) return false;
        if (scorePointId != null ? !scorePointId.equals(that.scorePointId) : that.scorePointId != null) return false;
        if (answer != null ? !answer.equals(that.answer) : that.answer != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        return !(updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (assignee != null ? assignee.hashCode() : 0);
        result = 31 * result + (paperInstanceId != null ? paperInstanceId.hashCode() : 0);
        result = 31 * result + (paperId != null ? paperId.hashCode() : 0);
        result = 31 * result + (questionId != null ? questionId.hashCode() : 0);
        result = 31 * result + (scorePointId != null ? scorePointId.hashCode() : 0);
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        result = 31 * result + correctness;
        temp = Double.doubleToLongBits(score);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
