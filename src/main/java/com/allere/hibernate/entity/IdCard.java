package com.allere.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by G_dragon on 2015/7/16.
 */
@Entity
public class IdCard {

    private int id;
    private String cardNo;
    private Person person;

    /**
     * 凡是双向关系，必有mappedBy字段
     * @return
     */
    @OneToOne(mappedBy = "idCard")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

}
