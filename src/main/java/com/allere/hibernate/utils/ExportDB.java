package com.allere.hibernate.utils;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * �����������Ը������õ�hibernate��ص�ORM��Ϣ�������������ݿ�ı�ṹ
 * ��һ����԰���������ϵͳ��Ƶ�ʱ�򣬲���ȥ�������ݿ�ı�ṹ����ֻ��ȥ����
 * ��ṹ�ϲ����Ĺ�����ϵ
 *
 * Created by G_dragon on 2015/7/15.
 */
public class ExportDB {

    public static void main(String[] args){
        /**
         * org.hibernate.cfg.Configuration������ã�
         * ��ȡhibernate�����ļ�(hibernate.cfg.xml��hiberante.properties)��.
         * new Configuration()Ĭ���Ƕ�ȡhibernate.properties
         * ����ʹ��newConfiguration().configure();����ȡhibernate.cfg.xml�����ļ�
         */
        Configuration cfg = new AnnotationConfiguration().configure();

        /**
         * org.hibernate.tool.hbm2ddl.SchemaExport�����ࣺ
         * ��Ҫ����Configuration����
         * �˹�������Խ��ർ���������ݿ��
         */
        SchemaExport export = new SchemaExport(cfg);

        /** ��ʼ����
         *��һ��������script�Ƿ��ӡDDL��Ϣ
         *�ڶ���������export�Ƿ񵼳������ݿ������ɱ�
         */
        export.create(true, true);

    }
}
