package 观察者模式.one;

public class SubMealBuilderA extends MealBuilder {
    @Override
    public void BuildFood() {
        meal.setFood("汉堡");
    }

    @Override
    public void BuildDrinks() {
        meal.setDrinks("可乐");
    }
}
