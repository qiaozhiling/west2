package w2;

import java.time.LocalDate;//导入LocalDate类

public class Juice extends Drinks {


//----------------------------------------------------------------------------------------------------------------------

    public Juice(String name, double cost, LocalDate proDate, int quaGrtPrd) {
        super(name, cost, proDate, quaGrtPrd);
    }//全参构造函数

    public Juice(String name) {
        super(name);
    }//无日期构造函数

//----------------------------------------------------------------------------------------------------------------------

    public String toString() {
        return name + ":" +
                "\n生产日期:" + proDate +
                "\n保质期:" + quaGrtPrd +
                "\n价格:" + cost +
                "\n";

    } //覆写toString方法

}
