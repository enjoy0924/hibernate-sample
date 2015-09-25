package com.allere.hibernate.entity.denpends;

/**
 * ��hibernate�У�������������ʵ��Serializable�ӿڣ�Ϊ�˱�֤Ψһ�ԣ�����ʵ��equals��hashCode����
 * Created by G_dragon on 2015/7/15.
 */
public class FiscalYearPeriodPK implements java.io.Serializable {
    private int fiscalYear;//������ 
    private int fiscalPeriod;//������

    public int getFiscalYear() {
        return fiscalYear;
    }
    public void setFiscalYear(int fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public int getFiscalPeriod(){
        return fiscalPeriod;
    }
    public void setFiscalPeriod(int fiscalPeriod) {
        this.fiscalPeriod =fiscalPeriod;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime* result + fiscalPeriod;
        result = prime* result + fiscalYear;
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() !=obj.getClass())
            return false;
        FiscalYearPeriodPK other = (FiscalYearPeriodPK) obj;
        if (fiscalPeriod != other.fiscalPeriod)
            return false;
        if (fiscalYear != other.fiscalYear)
            return false;
        return true;
    }
}