package com.allere.hibernate.entity;

import javax.persistence.Entity;

/**
 * Created by G_dragon on 2015/7/16.
 */
@Entity
public class Bird extends Animal {
    private int height;

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
}
