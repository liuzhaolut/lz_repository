package 观察者模式.one;

public class SubMealBuilderB extends MealBuilder{
    @Override
    public void BuildFood() {
        meal.setFood("火锅");
    }

    @Override
    public void BuildDrinks() {
        meal.setDrinks("凉茶");
    }
}
