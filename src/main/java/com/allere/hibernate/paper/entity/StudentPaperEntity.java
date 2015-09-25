package com.allere.hibernate.paper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 该表需要解决的问题：
 *
 * 查询单个学生某次作业里面某个问题的状态
 *
 * Created by G_dragon on 2015/8/7.
 */
@Entity
@Table(name="QBU_STUDENT_PAPER")
public class StudentPaperEntity {
    private String id;
    private String paperInstanceId;
    private String assignee;            //做作业的人的ID
    private double score;               //作业得分
    private int status;                 //作业状态
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

    @Column(length = 64, nullable = false)
    public String getPaperInstanceId() {
        return paperInstanceId;
    }

    public void setPaperInstanceId(String paperInstanceId) {
        this.paperInstanceId = paperInstanceId;
    }

    @Column(length = 64, nullable = false)
    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

        StudentPaperEntity that = (StudentPaperEntity) o;

        if (Double.compare(that.score, score) != 0) return false;
        if (status != that.status) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (paperInstanceId != null ? !paperInstanceId.equals(that.paperInstanceId) : that.paperInstanceId != null)
            return false;
        if (assignee != null ? !assignee.equals(that.assignee) : that.assignee != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        return !(updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (paperInstanceId != null ? paperInstanceId.hashCode() : 0);
        result = 31 * result + (assignee != null ? assignee.hashCode() : 0);
        temp = Double.doubleToLongBits(score);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + status;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
