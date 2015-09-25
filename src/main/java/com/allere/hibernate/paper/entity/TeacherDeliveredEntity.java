package com.allere.hibernate.paper.entity;

import com.allere.hibernate.paper.CONST;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * ��ҵ��������,ÿһ����ҵ�·������������һ����¼��������ʶһ����ҵ
 *
 * ������Ҫ����������ǣ�
 * �ĸ���ʦ��ʲôʱ�����Щ���Ͽ��ڼ䷢������Щ������ҵ��
 *
 * Created by G_dragon on 2015/8/4.
 */
@Entity
@Table(name="QBU_TEACHER_DELIVERED")
public class TeacherDeliveredEntity {

    private String id;                          //UUID����������ʶĳһ����ҵ
    private String delivererId;                 //��ҵ[����]�·��ߵ�ID������ʦID
    private String paperId;                     //��ҵ[�Ծ�]��ID�����������
    private String groupId;                     //Ⱥ��ID

    private int type  = CONST.TEST_TYPE_SEATWORK;            //�������ͣ�����-1 ����ͥ-2��Ĭ��Ϊ������ҵ

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
    public String getDelivererId() {
        return delivererId;
    }

    public void setDelivererId(String delivererId) {
        this.delivererId = delivererId;
    }

    @Column(length = 64, nullable = false)
    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    @Column(nullable = false)
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Column(length = 64, nullable = false)
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
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

        TeacherDeliveredEntity that = (TeacherDeliveredEntity) o;

        if (type != that.type) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (delivererId != null ? !delivererId.equals(that.delivererId) : that.delivererId != null) return false;
        if (paperId != null ? !paperId.equals(that.paperId) : that.paperId != null) return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        return !(updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (delivererId != null ? delivererId.hashCode() : 0);
        result = 31 * result + (paperId != null ? paperId.hashCode() : 0);
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + type;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
