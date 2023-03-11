package 建造者模式;

import java.awt.*;

public abstract class PersonBuilder {
    protected Graphics g;
    public PersonBuilder(Graphics g){
        this.g=g;
    }
//    造小人
    public abstract void builderhead();
    public abstract void builderbody();
    public abstract void builderlhand();
    public abstract void builderrhand();
    public abstract void builderlleg();
    public abstract void builderrleg();

}
