import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
//<applet code="Ex10" width=260 height=260></applet>
public class Ex10 extends JApplet {

    public void init() {
        Container contentPane = getContentPane();
        contentPane.add(new MyPanel10());
    }
}

class MyPanel10 extends JPanel implements Runnable {

    int x = 0;
    Thread t;

    public MyPanel10() {
        t = new Thread(this);
        t.start();

    }

    public void run() {
        try {
            while (true) {
                repaint();
                Thread.sleep(100);
            }
        } catch (Exception e) {
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension d = getSize();
        g.fillOval(x, d.height / 4, 50, 50);
        x += 5;
        if (x + 50 > d.width) {
            x = 0;
        }
    }
}