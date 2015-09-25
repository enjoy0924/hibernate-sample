package com.allere.hibernate.entity;

import com.allere.hibernate.entity.denpends.FiscalYearPeriodPK;

import java.util.Date;

/**
 * Created by G_dragon on 2015/7/15.
 */

public class FiscalYearPeriod {

    //引用 复合主键类
    private FiscalYearPeriodPK fiscalYearPeriodPK;
    private Date beginDate;        //开始日期
    private Date endDate;          //结束日期
    private String periodSts;      //状态

    public FiscalYearPeriodPK getFiscalYearPeriodPK() {
        return fiscalYearPeriodPK;
    }
    public void setFiscalYearPeriodPK(FiscalYearPeriodPK fiscalYearPeriodPK) {
        this.fiscalYearPeriodPK = fiscalYearPeriodPK;
    }

    public Date getBeginDate() {
        return beginDate;
    }
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPeriodSts() {
        return periodSts;
    }
    public void setPeriodSts(String periodSts) {
        this.periodSts = periodSts;
    }
}