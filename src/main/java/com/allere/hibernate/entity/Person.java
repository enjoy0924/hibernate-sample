package com.allere.hibernate.entity;

import javax.persistence.*;

/**
 * Created by G_dragon on 2015/7/16.
 */
@Entity
public class Person {
    private int id;
    private String name;

    /**
     * 引入card对象
     */
    private IdCard idCard;

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

    /**
     * OneToOne
     * ManyToOne
     * OneToMany
     * ManyToMany
     * 以上的映射关系实际上是数据库表之间的外键关联关系，只是在表关系里面无法体现出数量的对应关系
     *
     * 关系之间可以单向关系或者是双向关系
     * @return
     */
    @OneToOne
    @JoinColumn(name="idCard")
    public IdCard getIdCard() {
        return idCard;
    }
    public void setIdCard(IdCard idCard) {
        this.idCard = idCard;
    }
}
