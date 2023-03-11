package 代理模式;

public class Pursuit implements GiveGift{
    SchoolGirl mm;

    public Pursuit(SchoolGirl mm) {
        this.mm=mm;
    }
    public void giveDolls()
    {
        System.out.println(mm.name + " 送你洋娃娃");
    }

    public void giveFlowers()
    {
        System.out.println(mm.name + " 送你鲜花");
    }

}
