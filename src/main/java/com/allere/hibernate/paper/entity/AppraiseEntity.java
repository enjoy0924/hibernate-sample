package com.allere.hibernate.paper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 评价打赏
 *
 * 这里需要解决的问题是：
 * 哪个人在哪一次作业里面哪一道题或者哪一次作业以何种方式被评价
 *
 * Created by G_dragon on 2015/8/4.
 */
@Entity
@Table(name="QBU_APPRAISE")
public class AppraiseEntity {

    private String id;            //数据库自增ID
    private String appraiserId; //评价人ID
    private String appraisedId; //被评价人ID

    private int type;           //评价方式
    private String content;     //评价内容，可以是评语或者金币个数或者声音文件路径

    private String paperInstanceId;  //评价相关作业试卷批次
    private String questionId;       //题目ID，如果为空则属于整个作业[试卷]的点评

    private Date createTime;    //创建时间
    private Date updateTime;    //更新时间

    @Id
    @Column(length = 64)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(length = 64)
    public String getAppraiserId() {
        return appraiserId;
    }

    public void setAppraiserId(String appraiserId) {
        this.appraiserId = appraiserId;
    }

    @Column(length = 64)
    public String getAppraisedId() {
        return appraisedId;
    }

    public void setAppraisedId(String appraisedId) {
        this.appraisedId = appraisedId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Column(length = 128)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

        AppraiseEntity that = (AppraiseEntity) o;

        if (type != that.type) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (appraiserId != null ? !appraiserId.equals(that.appraiserId) : that.appraiserId != null) return false;
        if (appraisedId != null ? !appraisedId.equals(that.appraisedId) : that.appraisedId != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (paperInstanceId != null ? !paperInstanceId.equals(that.paperInstanceId) : that.paperInstanceId != null)
            return false;
        if (questionId != null ? !questionId.equals(that.questionId) : that.questionId != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        return !(updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (appraiserId != null ? appraiserId.hashCode() : 0);
        result = 31 * result + (appraisedId != null ? appraisedId.hashCode() : 0);
        result = 31 * result + type;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (paperInstanceId != null ? paperInstanceId.hashCode() : 0);
        result = 31 * result + (questionId != null ? questionId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
