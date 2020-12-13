
import java.time.LocalDate;
import java.util.*;

public class Z_test {

    public static void main(String[] args) {

        //实力日期对象
        LocalDate date1 = LocalDate.of(2020, 11, 14);
        LocalDate date2 = LocalDate.of(2020, 12, 12);

        //实力饮料对象
        Drinks drink1 = new Juice("苹果果汁", 3, date1, 2);//过期
        Drinks drink2 = new Juice("苹果果汁", 3, date1, 2);//过期
        Drinks drink3 = new Juice("橘子果汁", 4, date2, 2);//未过期
        Drinks drink4 = new Beer("青岛啤酒", 8, date1, 30, 10);
        Drinks drink5 = new Beer("1664", 13, date1, 30, 20);
        Drinks drink6 = new Beer("1664", 13, date2, 30, 20);

        //初始化饮料列表
        LinkedList<Drinks> juiceList = new LinkedList<>();//果汁列表
        juiceList.add(drink1);
        juiceList.add(drink2);
        juiceList.add(drink3);

        LinkedList<Drinks> beerList = new LinkedList<>();//啤酒列表
        beerList.add(drink4);
        beerList.add(drink5);
        beerList.add(drink6);


        //测试 输出饮料信息
        /**System.out.println("啤酒信息\n" + firedChickenRestaurant.getBeerList().get(1).toString());
         System.out.println("果汁信息\n"+drink2.toString());
         //测试 输出套餐信息
         System.out.println("套餐:\n"+firedChickenRestaurant.getSetMealList().get(0).toString());*/

        //测试
        /**System.out.println(drink2.isOverDate());
         System.out.println(juiceList);
         juiceList.removeIf(Drinks::isOverDate);//移除已过期
         System.out.println(juiceList);*/

        System.out.println("==================================分隔======================================");

        //实力炸鸡店
        West2FiredChickenRestaurant firedChickenRestaurant = new West2FiredChickenRestaurant(1000
                , beerList, juiceList);//实例化炸鸡店 1000余额 啤酒列表 果汁列表

        //初始化套餐（菜单）列表
        ArrayList<SetMeal> setMealList = new ArrayList<>();//套餐列表
        setMealList.add(new SetMeal("苹果果汁套餐", 17, "炸鸡名字"
                , new Juice("苹果果汁")));//第一种套餐
        setMealList.add(new SetMeal("橘子果汁套餐", 18, "炸鸡名字"
                , new Juice("橘子果汁")));//第二种套餐
        setMealList.add(new SetMeal("青岛啤酒套餐", 21, "炸鸡名字"
                , new Beer("青岛啤酒")));//第三种套餐
        setMealList.add(new SetMeal("1664套餐", 23, "炸鸡名字"
                , new Beer("1664")));//第四种套餐


        //测试卖出套餐
        firedChickenRestaurant.setSell(setMealList.get(0));//出售套餐列表第一种套餐 苹果果汁套餐
        firedChickenRestaurant.setSell(setMealList.get(1));//出售套餐列表第二种套餐 橘子果汁套餐
        firedChickenRestaurant.setSell(setMealList.get(2));//出售套餐列表第3种套餐 青岛啤酒套餐
        firedChickenRestaurant.setSell(setMealList.get(3));//出售套餐列表第4种套餐 1664套餐

        //System.out.println("==================================分隔======================================");

        //装填 买入列表
        ArrayList<Drinks> drinkList = new ArrayList<>();
        drinkList.addAll(juiceList);
        drinkList.addAll(beerList);

        //测试 买入
        firedChickenRestaurant.purchaseIn(1001, drinkList);
        firedChickenRestaurant.purchaseIn(500, drinkList);

        System.out.println("end");
    }
}
