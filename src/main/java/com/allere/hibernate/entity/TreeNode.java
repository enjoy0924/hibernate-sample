package com.allere.hibernate.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by G_dragon on 2015/7/16.
 */
@Entity
@Table(name="Tree")
public class TreeNode {
    private int id;       //标识符
    private String name;  //节点名称
    private int level;    //层次，为了输出设计
    private boolean leaf; //是否为叶子节点，这是为了效率设计，可有可无
    //父节点：因为多个节点属于一个父节点，因此用hibernate映射关系说是“多对一”
    private TreeNode parent;
    //子节点：因为一个节点有多个子节点，因此用hibernate映射关系说是“一对多”
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
