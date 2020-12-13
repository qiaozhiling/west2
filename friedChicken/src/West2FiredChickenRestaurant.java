
import java.util.ArrayList;
import java.util.LinkedList;

public class West2FiredChickenRestaurant implements FriedChickenRestaurant {

// ----------------------------------------------------------------------------------------------------------------------

    private double rABalance;//restaurantAccountBalance餐厅账目余额
    private LinkedList<Drinks> beerList; //啤酒列表 增删多
    private LinkedList<Drinks> juiceList; //果汁列表 增删多
    private static final ArrayList<SetMeal> setMealList = new ArrayList<>(); //套餐列表 查找多

// ----------------------------------------------------------------------------------------------------------------------

    //getset
    public double getrABalance() {
        return rABalance;
    }

    public void setrABalance(double rABalance) {
        this.rABalance = rABalance;
    }

    public LinkedList<Drinks> getBeerList() {
        return beerList;
    }

    public void setBeerList(LinkedList<Drinks> beerList) {
        this.beerList = beerList;
    }

    public LinkedList<Drinks> getJuiceList() {
        return juiceList;
    }

    public void setJuiceList(LinkedList<Drinks> juiceList) {
        this.juiceList = juiceList;
    }

    public ArrayList<SetMeal> getSetMealList() {
        return setMealList;
    }

// ----------------------------------------------------------------------------------------------------------------------

    static {
        setMealList.add(new SetMeal("苹果果汁套餐", 17, "炸鸡名字"
                , new Juice("苹果果汁")));
        setMealList.add(new SetMeal("橘子果汁套餐", 18, "炸鸡名字"
                , new Juice("橘子果汁")));
        setMealList.add(new SetMeal("青岛啤酒套餐", 21, "炸鸡名字"
                , new Juice("青岛啤酒")));
        setMealList.add(new SetMeal("1664套餐", 23, "炸鸡名字"
                , new Juice("1664")));
    }//静态代码块对套餐列表进行初始化，套餐初始化后不可变
    //类似菜单 只有套餐含括内容 没有具体内容的具体参数

// ----------------------------------------------------------------------------------------------------------------------

    public West2FiredChickenRestaurant(double rABalance, LinkedList<Drinks> beerList, LinkedList<Drinks> juiceList) {
        this.rABalance = rABalance;
        this.beerList = beerList;
        this.juiceList = juiceList;
    }//余额，啤酒列表，果汁列表，构造方法

// ----------------------------------------------------------------------------------------------------------------------

    //重载use函数

    private void use(Beer beer) throws IngredientSortOutException {

        beerList.removeIf(Drinks::isOverDate);//移除已过期

        for (int i = 0; i < beerList.size(); i++) {

            if (beer.name.equals(beerList.get(i).name)) {

                beerList.remove(i);
                return;//查找到删除该啤酒并结束方法
            }//店内啤酒列表（仓库）是否存在与套餐内啤酒名字相同的啤酒
        }//循环查找店内啤酒列表

        throw new IngredientSortOutException(beer.name + "已经买完,无法出售对应套餐");//未找到（未执行return）抛出异常
    }//输入啤酒

    private void use(Juice juice) throws IngredientSortOutException {

        juiceList.removeIf(Drinks::isOverDate);//移除已过期

        for (int i = 0; i < juiceList.size(); i++) {

            if (juice.name.equals(juiceList.get(i).name)) {

                juiceList.remove(i);
                return;
            }
        }

        throw new IngredientSortOutException(juice.name + "已经买完,无法出售对应套餐");
    }//输入果汁

// ----------------------------------------------------------------------------------------------------------------------

    public void setSell(SetMeal setMeal) {

        try {
            if (setMeal.getDrinks() instanceof Beer) {//套餐的饮料是啤酒

                this.use((Beer) setMeal.getDrinks());//？use
            } else if (setMeal.getDrinks() instanceof Juice) {//套餐的饮料是果汁

                this.use((Juice) setMeal.getDrinks());//？use
            }

            rABalance += setMeal.getSetPrice();//收钱
            System.out.println("成功卖出套餐" + setMeal.getSetName());//输出成功卖出信息
        } catch (IngredientSortOutException e) {

            e.printStackTrace();
        }//捕获异常打印信息
    }//出售套餐

    public void purchaseIn(double prize, ArrayList<Drinks> drinksList) {

        try {

            if (rABalance < prize) {//判断余额是否不足

                throw new OverdraftBalanceException("餐厅账户余额不足，差" + (prize - rABalance) + "元");//余额不足抛出异常结束运行
            } else {//余额足

                rABalance -= prize;//出钱
                for (int i = 0; i < drinksList.size(); i++) {//循环给入的（进货）饮料列表

                    if (drinksList.get(i) instanceof Juice) { //是果汁

                        juiceList.add(drinksList.get(i));//加入到餐厅的果汁列表
                    } else if (drinksList.get(i) instanceof Beer) { //是啤酒

                        beerList.add(drinksList.get(i));//加入到餐厅的啤酒列表
                    }
                }

                System.out.println("成功买入，余额:" + rABalance);//提示余额信息
            }


        } catch (OverdraftBalanceException e) {

            e.printStackTrace();
        }//捕获余额不足异常
    } //批量进货

}