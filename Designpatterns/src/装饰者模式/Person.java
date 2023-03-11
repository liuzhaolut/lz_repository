package 装饰者模式;

public class Person {
    private String name;

    public Person() {
        super();
    }
    public Person(String name){
        this.name=name;
    }

    public void show(){
        System.out.println("装扮的"+name);
    }
}
