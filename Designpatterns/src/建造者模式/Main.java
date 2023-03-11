package 建造者模式;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends Frame {
    public void paint(Graphics g){
//        Color c=g.getColor();
//        g.setColor(Color.BLACK);
//        PersonThinBuilder sz=new PersonThinBuilder(g);
//        PersonDirector pd=new PersonDirector(sz);
//        pd.createPerson();
//        g.setColor(c);
//    }
//    public void paint2(Graphics g){
        Color c=g.getColor();
        g.setColor(Color.blue);
        PersonFatBuilder pz=new PersonFatBuilder(g);
        PersonDirector pd2=new PersonDirector(pz);
        pd2.createPerson();
        g.setColor(c);
    }
    public void lauchFrame()
    {
        this.setLocation(400, 300);
        this.setSize(800, 600);

        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

        this.setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        Main drawPerson = new Main();
        drawPerson.lauchFrame();
    }
}
