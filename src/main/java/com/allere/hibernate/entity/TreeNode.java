package com.allere.hibernate.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by G_dragon on 2015/7/16.
 */
@Entity
@Table(name="Tree")
public class TreeNode {
    private int id;       //��ʶ��
    private String name;  //�ڵ�����
    private int level;    //��Σ�Ϊ��������
    private boolean leaf; //�Ƿ�ΪҶ�ӽڵ㣬����Ϊ��Ч����ƣ����п���
    //���ڵ㣺��Ϊ����ڵ�����һ�����ڵ㣬�����hibernateӳ���ϵ˵�ǡ����һ��
    private TreeNode parent;
    //�ӽڵ㣺��Ϊһ���ڵ��ж���ӽڵ㣬�����hibernateӳ���ϵ˵�ǡ�һ�Զࡱ
    private Set<TreeNode> children;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name="level")
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    @Column(name="isLeaf")
    public boolean isLeaf() {
        return leaf;
    }
    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    @ManyToOne
    @JoinColumn(name="parentId")
    public TreeNode getParent() {
        return parent;
    }
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    @OneToMany(mappedBy="parent")
    public Set<TreeNode> getChildren() {
        return children;
    }
    public void setChildren(Set<TreeNode> children) {
        this.children = children;
    }
}
