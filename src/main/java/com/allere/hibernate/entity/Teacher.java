package com.allere.hibernate.entity;

import com.allere.hibernate.entity.denpends.EnumSex;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by G_dragon on 2015/7/15.
 */
@Entity
@Table(name="teacher")  //�����������Ͳ�һ����ʱ�����ʹ��@Tableע���������
public class Teacher {
    private int id;
    private String name;
    private String title;

    private Date updatetime;

    private EnumSex sex;

    private Contact contact;

    /**
     * ע���ʾǶ������ӳ�䣬�����xml�����<Anwser></Anwser>��Ӧ
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
     * ����������������Ҫ���ݿ�������������ID��������insert������ʱ��Ϳ���ʡ�Զ�ID�ֶε�����
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
     * �������ƺ����Ա�������Ʋ�һ�µ�ʱ�����ʹ��@Column����ע������
     * @return
     */
    @Column(name="name", updatable=true)  //updatableȷ���Ƿ������£�Ĭ�϶�Ϊtrue�����ַ��������ã�������ʹ��dynamic-update��ֻҪ���и��ĵ��ֶζ�����,�������ֻ��xml��������
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ��ĳ�Ա����û�б�Ҫ�������ݿ��ʱ�򣬿���ʹ��@Transient����ע��
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
     * ���ڸ�ʽ��
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
     * ע��ö�����ʹ������ݿ�
     * EnumType.ORDINAL ��ʾֱ�ӽ�ö�ٶ�Ӧ����ֵ�������ݿ�
     * EnumType.STRING  ��ʾֱ�ӽ�ö�����ƴ������ݿ�
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

