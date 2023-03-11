package 原型模式.one;

public class SunWuKong implements Cloneable{
    private String name;

    public SunWuKong(String name){
        this.name=name;
    }

    public void display(){
        System.out.println(name);
    }
    public SunWuKong clone(){
        try {
            return (SunWuKong) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
