package w2;

import java.time.LocalDate;//导入LocalDate类

public abstract class Drinks {//饮料类Drinks （抽象类）

    protected String name; //名字
    protected double cost; //成本
    protected LocalDate proDate; //生产日期producedDate（LocalDate类）
    protected int quaGrtPrd; //保质期qualityGuaranteePeriod单位：(天）

//----------------------------------------------------------------------------------------------------------------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public LocalDate getProDate() {
        return proDate;
    }

    public void setProDate(LocalDate proDate) {
        this.proDate = proDate;
    }

    public int getQuaGrtPrd() {
        return quaGrtPrd;
    }

    public void setQuaGrtPrd(int quaGrtPrd) {
        this.quaGrtPrd = quaGrtPrd;
    }

//----------------------------------------------------------------------------------------------------------------------

    public Drinks(String name, double cost, LocalDate proDate, int quaGrtPrd) {
        setName(name);
        setCost(cost);
        setProDate(proDate);
        setQuaGrtPrd(quaGrtPrd);
    }//全参构造函数

    public Drinks(String name) {
        setName(name);
        setCost(0);
        setProDate(null);
        setQuaGrtPrd(0);
    }//无日期构造函数


//----------------------------------------------------------------------------------------------------------------------

    protected boolean isOverDate() {
        return proDate == null || this.proDate.plusDays(quaGrtPrd).isBefore(LocalDate.now());
    }//判断当前是否过期方法（使用LocalDate）

//----------------------------------------------------------------------------------------------------------------------

    public abstract String toString(); //抽象的toString方法
}
