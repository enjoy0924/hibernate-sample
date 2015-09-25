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
     * 使用cascade值可以使我们在存储一个依赖记录的时候不用先save操作
     * 比如存储一个用户到一个不存在的组里面
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
