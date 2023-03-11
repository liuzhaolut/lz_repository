package 建造者模式;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DrawPerson extends Frame {
    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.BLACK);
//        头
        g.fillOval(50, 50, 30, 30);
//        身
        g.fillRect(60, 80, 10, 50);
//        左手
        g.drawLine(60, 80, 40, 130);
//        右手
        g.drawLine(70, 80, 90, 130);
//        左脚
        g.drawLine(60, 130, 45, 180);
//        右脚
        g.drawLine(70, 130, 85, 180);
        g.getColor();
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
}
