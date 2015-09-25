package com.allere.hibernate.entity;

import com.allere.hibernate.entity.denpends.TeacherPK;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Created by G_dragon on 2015/7/16.
 */
@Entity
@IdClass(value= TeacherPK.class)
public class TeacherComposite2 {

    private int id;
    private String name;

    @Id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Id
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


}
