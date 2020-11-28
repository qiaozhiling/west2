package w2;

public class SetMeal {

    private String setName; //套餐名
    private double setPrice; //套餐价格（double）
    private String fCkName; //炸鸡名字FriedChicken
    private Drinks drinks; //饮料类成员变量

//----------------------------------------------------------------------------------------------------------------------

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public double getSetPrice() {
        return setPrice;
    }

    public void setSetPrice(double setPrice) {
        this.setPrice = setPrice;
    }

    public String getfCkName() {
        return fCkName;
    }

    public void setfCkName(String fCkName) {
        this.fCkName = fCkName;
    }

    public Drinks getDrinks() {
        return drinks;
    }

    public void setDrinks(Drinks drinks) {
        this.drinks = drinks;
    }


//----------------------------------------------------------------------------------------------------------------------

    public SetMeal(String setName, double setPrice, String fCkName, Drinks drinks) {
        this.setName = setName;
        this.setPrice = setPrice;
        this.fCkName = fCkName;
        this.drinks = drinks;
    }

//----------------------------------------------------------------------------------------------------------------------

    public String toString() {
        return setName + "\n" +
                "Drink:" + drinks.name + "\n" +
                "Fried Chicken:" + fCkName + "\n" +
                "Set Price:" + setPrice + "\n";
    }

}
