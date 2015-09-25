package com.allere.hibernate.service;

import com.allere.hibernate.entity.TreeNode;
import com.allere.hibernate.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by G_dragon on 2015/7/16.
 */
public class TreeNodeManageService {

    private static TreeNodeManageService nodeManage= new TreeNodeManageService();

    //因为要使用单例，所以将其构造方法私有化
    private TreeNodeManageService(){

    }

    //向外提供一个接口
    public static TreeNodeManageService getInstanse(){
        return nodeManage;
    }
    /**
     * 创建一棵树
     *@param
     */
    public void createTree(String dir) {
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            File root = new File(dir);
            //因为第一个节点无父节点，因为是null
            this.saveNode(root, session, null,0 );

            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtils.closeSession(session);
        }}
    /**
     * 保存节点对象至数据库
     *@param file 节点所对应的文件
     *@param session session
     *@param parent 父节点
     *@param level 级别
     */
    public void saveNode(File file, Session session, TreeNode parent, int level) {
        if (file == null ||!file.exists()){
            return;
        }

        //如果是文件则返回true,则表示是叶子节点，否则为目录，非叶子节点
        boolean isLeaf = file.isFile();
        TreeNode node = new TreeNode();
        node.setName(file.getName());
        node.setLeaf(isLeaf);
        node.setLevel(level);
        node.setParent(parent);

        session.save(node);

        //进行循环迭代子目录
        File[] subFiles = file.listFiles();
        if (subFiles != null &&subFiles.length > 0){
            for (int i = 0; i <subFiles.length ; i++){
                this.saveNode(subFiles[i],session, node, level + 1);
            }
        }
    }
    /**
     * 输出树结构
     *@param id
     */
    public void printNodeById(int id) {

        Session session = null;

        try {
            session =HibernateUtils.getSession();
            session.beginTransaction();

            TreeNode node =(TreeNode)session.get(TreeNode.class, id);

            printNode(node);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtils.closeSession(session);
        }
    }

    private void printNode(TreeNode node) {
        if (node == null){
            return;
        }

        int level = node.getLevel();
        if (level > 0){
            for (int i = 0; i < level; i++){
                System.out.print("  |");
            }
            System.out.print("--");
        }
        System.out.println(node.getName() +(node.isLeaf() ? "" : "[" + node.getChildren().size() +"]"));
        Set children = node.getChildren();
        for (Iterator iter =children.iterator(); iter.hasNext(); ){
            TreeNode child = (TreeNode)iter.next();
            printNode(child);
        }
    }
}
