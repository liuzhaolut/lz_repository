package 观察者模式.one;

public class SubMealBuilderC extends MealBuilder{
    @Override
    public void BuildFood() {
        meal.setFood("干锅");
    }

    @Override
    public void BuildDrinks() {
        meal.setDrinks("果汁");
    }
}
