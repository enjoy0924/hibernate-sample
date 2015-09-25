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
     * ����card����
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
     * ���ϵ�ӳ���ϵʵ���������ݿ��֮������������ϵ��ֻ���ڱ��ϵ�����޷����ֳ������Ķ�Ӧ��ϵ
     *
     * ��ϵ֮����Ե����ϵ������˫���ϵ
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
