package com.allere.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by G_dragon on 2015/7/16.
 */
@Entity
public class Animal {

    private int id;
    private String name;
    private boolean sex;

    @Id
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

    public boolean isSex() {
        return sex;
    }
    public void setSex(boolean sex) {
        this.sex = sex;
    }

}
