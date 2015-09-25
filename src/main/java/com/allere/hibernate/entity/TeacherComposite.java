package com.allere.hibernate.entity;

import com.allere.hibernate.entity.denpends.TeacherPK;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by G_dragon on 2015/7/16.
 */
@Entity
public class TeacherComposite {


    private TeacherPK pk;
    private String title;

    @Id
    //@EmbeddedId    //使用EmbeddedId注解的话，不需要配置TeacherPK里面的@Embeddable注解
    public TeacherPK getPk(){
        return pk;
    }
    public void setPk(TeacherPK pk) {
        this.pk = pk;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
