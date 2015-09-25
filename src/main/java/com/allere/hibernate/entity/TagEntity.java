package com.allere.hibernate.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by G_dragon on 2015/7/17.
 */
@Entity
@Table(name="exam_question_tag")
public class TagEntity extends EntityBase{

    private String name;
    //private Teacher creator;
    //private Teacher updater;
    private TagEntity parent;

    private Set<QuestionEntity> questionEntities;
    private Set<TagEntity> children;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ManyToMany(mappedBy = "tags")
    @OrderBy(value="desc")
    public Set<QuestionEntity> getQuestionEntities() {
        return questionEntities;
    }
    public void setQuestionEntities(Set<QuestionEntity> questionEntities) {
        this.questionEntities = questionEntities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @OneToMany(mappedBy = "parent")
    public Set<TagEntity> getChildren() {
        return children;
    }

    public void setChildren(Set<TagEntity> children) {
        this.children = children;
    }

    @ManyToOne
    @JoinColumn(name="pid")
    public TagEntity getParent() {
        return parent;
    }

    public void setParent(TagEntity parent) {
        this.parent = parent;
    }
}
