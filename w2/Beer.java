package w2;

import java.time.LocalDate;//导入LocalDate类

public class Beer extends Drinks { //啤酒类Beer（继承自饮料类）

    private float alDeg; //酒精度数alcoholDegree（float）

//----------------------------------------------------------------------------------------------------------------------

    public float getAlDeg() {
        return alDeg;
    }

    public void setAlDeg(float alDeg) {
        this.alDeg = alDeg;
    }

//----------------------------------------------------------------------------------------------------------------------

    public Beer(String name, double cost, LocalDate proDate, int quaGrtPrd, float alDeg) {
        super(name, cost, proDate, quaGrtPrd);
        setAlDeg(alDeg);
    }//全参构造函数

    public Beer(String name) {
        super(name);
    }//无日期构造函数

//----------------------------------------------------------------------------------------------------------------------

    public String toString() {
        return name + ":" +
                "\n生产日期:" + proDate +
                "\n保质期:" + quaGrtPrd +
                "\n酒精度数:" + alDeg +
                "\n价格:" + cost + "\n";

    } //覆写toString方法
}
