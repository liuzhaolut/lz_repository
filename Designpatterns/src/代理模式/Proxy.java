package 代理模式;

public class Proxy implements GiveGift{
    Pursuit gg;

    public Proxy(SchoolGirl mm) {
        gg=new Pursuit(mm);
    }
    public void giveDolls()
    {
       gg.giveDolls();
    }

    public void giveFlowers()
    {
        gg.giveFlowers();
    }

}
