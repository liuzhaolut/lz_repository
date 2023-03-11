package 装饰者模式;

public class ConcreateComponent implements Component{
    private String name;
    public ConcreateComponent(String name){
        this.name=name;
    }
    @Override
    public void opertion() {
        System.out.println("装饰的"+name);
    }
}
