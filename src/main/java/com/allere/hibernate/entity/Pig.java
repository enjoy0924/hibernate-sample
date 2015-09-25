package com.allere.hibernate.entity;

import javax.persistence.Entity;

/**
 * Created by G_dragon on 2015/7/16.
 */
@Entity
public class Pig extends Animal {
    private int weight;

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
}
