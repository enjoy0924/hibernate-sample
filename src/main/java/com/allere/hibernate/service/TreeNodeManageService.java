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

    //��ΪҪʹ�õ��������Խ��乹�췽��˽�л�
    private TreeNodeManageService(){

    }

    //�����ṩһ���ӿ�
    public static TreeNodeManageService getInstanse(){
        return nodeManage;
    }
    /**
     * ����һ����
     *@param
     */
    public void createTree(String dir) {
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();

            File root = new File(dir);
            //��Ϊ��һ���ڵ��޸��ڵ㣬��Ϊ��null
            this.saveNode(root, session, null,0 );

            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtils.closeSession(session);
        }}
    /**
     * ����ڵ���������ݿ�
     *@param file �ڵ�����Ӧ���ļ�
     *@param session session
     *@param parent ���ڵ�
     *@param level ����
     */
    public void saveNode(File file, Session session, TreeNode parent, int level) {
        if (file == null ||!file.exists()){
            return;
        }

        //������ļ��򷵻�true,���ʾ��Ҷ�ӽڵ㣬����ΪĿ¼����Ҷ�ӽڵ�
        boolean isLeaf = file.isFile();
        TreeNode node = new TreeNode();
        node.setName(file.getName());
        node.setLeaf(isLeaf);
        node.setLevel(level);
        node.setParent(parent);

        session.save(node);

        //����ѭ��������Ŀ¼
        File[] subFiles = file.listFiles();
        if (subFiles != null &&subFiles.length > 0){
            for (int i = 0; i <subFiles.length ; i++){
                this.saveNode(subFiles[i],session, node, level + 1);
            }
        }
    }
    /**
     * ������ṹ
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
