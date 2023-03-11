package 工厂方法模式;

public class Volunteer implements LeiFeng{

    public void buildRoad(){
        System.out.println("修路");
    }
    public void buyrice(){
        System.out.println("买米");
    }
    public void getResult(){
        Volunteer v=new Volunteer();
        v.buildRoad();
        v.buyrice();
    }
}
