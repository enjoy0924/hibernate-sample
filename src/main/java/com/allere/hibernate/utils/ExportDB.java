package com.allere.hibernate.utils;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * 这个工具类可以根据配置的hibernate相关的ORM信息，逆向生成数据库的表结构
 * 这一点可以帮助我们在系统设计的时候，不用去考虑数据库的表结构，而只是去考虑
 * 表结构上层对象的关联关系
 *
 * Created by G_dragon on 2015/7/15.
 */
public class ExportDB {

    public static void main(String[] args){
        /**
         * org.hibernate.cfg.Configuration类的作用：
         * 读取hibernate配置文件(hibernate.cfg.xml或hiberante.properties)的.
         * new Configuration()默认是读取hibernate.properties
         * 所以使用newConfiguration().configure();来读取hibernate.cfg.xml配置文件
         */
        Configuration cfg = new AnnotationConfiguration().configure();

        /**
         * org.hibernate.tool.hbm2ddl.SchemaExport工具类：
         * 需要传入Configuration参数
         * 此工具类可以将类导出生成数据库表
         */
        SchemaExport export = new SchemaExport(cfg);

        /** 开始导出
         *第一个参数：script是否打印DDL信息
         *第二个参数：export是否导出到数据库中生成表
         */
        export.create(true, true);

    }
}
