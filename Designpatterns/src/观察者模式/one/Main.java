package 观察者模式.one;

public class Main {
    public static void main(String[] args){
        //        准备食物
                SubMealBuilderA a=new SubMealBuilderA();
        //        服务员a
                KFCWaiter waiter=new KFCWaiter(a);
        //        获得套餐a
                Meal mealA=waiter.construct();
                System.out.println("A套餐有：");
                System.out.println("食物："+mealA.getFood()+"   饮料："+mealA.getDrinks());

        SubMealBuilderB b=new SubMealBuilderB();
        KFCWaiter waiter1=new KFCWaiter(b);
        Meal mealB=waiter1.construct();
        System.out.println("B套餐有：");
        System.out.println("食物："+mealB.getFood()+"   饮料："+mealB.getDrinks());

        SubMealBuilderC c=new SubMealBuilderC();
        KFCWaiter waiter2=new KFCWaiter(c);
        Meal mealC=waiter2.construct();
        System.out.println("C套餐有：");
        System.out.println("食物："+mealC.getFood()+"   饮料："+mealC.getDrinks());
    }
}
