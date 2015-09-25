package com.allere.hibernate.entity;

import javax.persistence.*;

/**
 * Created by G_dragon on 2015/7/16.
 */
@Entity
@Table(name="t_user")
public class User {
    private int id;
    private String name;
    private Group group;

    /**
     * ʹ��cascadeֵ����ʹ�����ڴ洢һ��������¼��ʱ������save����
     * ����洢һ���û���һ�������ڵ�������
     * @return
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="groupid")
    public Group getGroup() {
        return group;
    }
    public void setGroup(Group group) {
        this.group = group;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
