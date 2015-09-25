package com.allere.hibernate.entity.denpends;

import javax.persistence.Embeddable;

/**
 * Created by G_dragon on 2015/7/16.
 */

/**
 * 使用@Embeddable注解声明一个复合主键，取代xml里面的composite-id配置
 */
@Embeddable
public class TeacherPK implements java.io.Serializable {

    private int id;
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherPK teacherPK = (TeacherPK) o;

        if (id != teacherPK.id) return false;
        return !(name != null ? !name.equals(teacherPK.name) : teacherPK.name != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
