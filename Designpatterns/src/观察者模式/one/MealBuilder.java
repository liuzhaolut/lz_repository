package 观察者模式.one;

public abstract class MealBuilder {
    Meal meal=new Meal();
    public abstract void BuildFood();
    public abstract void BuildDrinks();
    public Meal getMeal(){
        return meal;
    }
}
