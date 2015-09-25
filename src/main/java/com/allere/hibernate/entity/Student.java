package com.allere.hibernate.entity;

/**
 * Created by G_dragon on 2015/7/15.
 */
public class Student {
    private int age;
    private int id;
    private String name;

    private Contact contact;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }


    public Contact getContact() {
        return contact;
    }
    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
