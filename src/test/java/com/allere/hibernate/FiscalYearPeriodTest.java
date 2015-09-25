package com.allere.hibernate;

import com.allere.hibernate.entity.FiscalYearPeriod;
import com.allere.hibernate.entity.denpends.FiscalYearPeriodPK;
import org.hibernate.Session;
import org.junit.Test;

import java.util.Date;

/**
 * Created by G_dragon on 2015/7/15.
 */
public class FiscalYearPeriodTest extends TestBase {

    @Test
    public void FiscalTest(){

        FiscalYearPeriod fiscalYearPeriod = new FiscalYearPeriod();

        //构造复合主键
        FiscalYearPeriodPK pk = new FiscalYearPeriodPK();
        pk.setFiscalYear(2009);
        pk.setFiscalPeriod(11);

        fiscalYearPeriod.setFiscalYearPeriodPK(pk);//为对象设置复合主键
        fiscalYearPeriod.setEndDate(new Date());
        fiscalYearPeriod.setBeginDate(new Date());
        fiscalYearPeriod.setPeriodSts("Y");

        Session session = GetSession();
        session.beginTransaction();
        session.save(fiscalYearPeriod);
        session.getTransaction().commit();
    }
}
