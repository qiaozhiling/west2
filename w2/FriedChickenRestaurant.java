package w2;

import java.util.ArrayList;
import java.util.LinkedList;

interface FriedChickenRestaurant {

    void setSell(SetMeal setMeal); //出售套餐

    void purchaseIn(double prize, ArrayList<Drinks> drinkslist); //批量进货

}
