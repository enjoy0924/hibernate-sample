package com.allere.hibernate.entity;

import com.allere.hibernate.entity.denpends.EnumSex;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by G_dragon on 2015/7/15.
 */
@Entity
@Table(name="teacher")  //当表名和类型不一样的时候可以使用@Table注解进行适配
public class Teacher {
    private int id;
    private String name;
    private String title;

    private Date updatetime;

    private EnumSex sex;

    private Contact contact;

    /**
     * 注解表示嵌入对象的映射，这里和xml里面的<Anwser></Anwser>对应
     * @return
     */
    @Embedded
    public Contact getContact() {
        return contact;
    }
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    /**
     * 这里设置主键，需要数据库里面设置自增ID，这里在insert操作的时候就可以省略对ID字段的设置
     * @return
     */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 当列名称和类成员变量名称不一致的时候可以使用@Column进行注解适配
     * @return
     */
    @Column(name="name", updatable=true)  //updatable确定是否参与更新，默认都为true，这种方法很少用，不灵活，多使用dynamic-update，只要是有更改的字段都更新,这个配置只在xml里面配置
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 类的成员变量没有必要存入数据库的时候，可以使用@Transient进行注解
     * @return
     */
    @Transient
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 日期格式化
     * TemporalType.DATE       yyyy-MM-dd
     * TemporalType.TIME       HH:mm:ss
     * TemporalType.TIMESTAMP  yyyy-MM-dd HH:mm:ss
     * @return
     */
    @Temporal(value=TemporalType.TIMESTAMP)
    public Date getUpdatetime() {
        return updatetime;
    }
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 注解枚举类型存入数据库
     * EnumType.ORDINAL 表示直接将枚举对应的数值存入数据库
     * EnumType.STRING  表示直接将枚举名称存入数据库
     * @return
     */
    @Enumerated(value=EnumType.STRING)
    public EnumSex getSex() {
        return sex;
    }
    public void setSex(EnumSex sex) {
        this.sex = sex;
    }
}

