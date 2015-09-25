package com.allere.hibernate.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by G_dragon on 2015/7/17.
 */
@Entity
@Table(name="exam_question")
public class QuestionEntity extends EntityBase {

    //private Teacher creator;
    //private Teacher updater;
    private String context;
    private Integer imgStatus;

    private Set<TagEntity> tags;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ManyToMany
    @JoinTable(
            name="exam_question_tag_rel",                     //使用@JoinTable标签的name属性注解第三方表名称
            joinColumns={@JoinColumn(name="fk_question_id")}, //使用joinColumns属性来注解当前实体类在第三方表中的字段名称并指向该对象
            inverseJoinColumns={@JoinColumn(name="fk_question_tag_id")} //使用inverseJoinColumns属性来注解当前实体类持有引用对象在第三方表中的字段名称并指向被引用对象表
    )
    public Set<TagEntity> getTags() {
        return tags;
    }
    public void setTags(Set<TagEntity> tags) {
        this.tags = tags;
    }

    /*
    @JoinColumn(name="fk_creator_id")
    public Teacher getCreator() {
        return creator;
    }

    public void setCreator(Teacher creator) {
        this.creator = creator;
    }

    @JoinColumn(name="fk_updater_id")
    public Teacher getUpdater() {
        return updater;
    }

    public void setUpdater(Teacher updater) {
        this.updater = updater;
    }
*/
    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Column(name="img_status")
    public Integer getImgStatus() {
        return imgStatus;
    }

    public void setImgStatus(Integer imgStatus) {
        this.imgStatus = imgStatus;
    }
}
