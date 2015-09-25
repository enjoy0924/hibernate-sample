package com.allere.hibernate;

import com.allere.hibernate.entity.TreeNode;
import com.allere.hibernate.service.TreeNodeManageService;
import com.allere.hibernate.utils.HibernateUtils;
import org.junit.Test;

/**
 * Created by G_dragon on 2015/7/16.
 */
public class TreeTest {
    @Test
    public void testCreateTree(){
        TreeNodeManageService.getInstanse().createTree("E:\\IdeaProjects\\HibernateSample");
    }

    @Test
    public void testPrintTree(){
        TreeNodeManageService.getInstanse().printNodeById(30);
    }
}
