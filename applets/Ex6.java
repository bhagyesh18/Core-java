import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
//<applet code="Ex6" width=260 height=260></applet>
public class Ex6 extends JApplet {

    public void init() {
        Container contentPane = getContentPane();
        contentPane.add(new MyPanel6());
    }
}

class MyPanel6 extends JPanel implements Runnable {

    Thread t;

    public MyPanel6() {
        t = new Thread(this);
        t.start();
    }

    public void run() {
        try {
            while (true) {
                repaint();
                Thread.sleep(200);
            }
        } catch (Exception e) {
        }
    }

    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
        Dimension d = getSize();
        int x = (int) (Math.random() * d.width);
        int y = (int) (Math.random() * d.height);
        g.fillRect(x, y, 2, 2);


    }
}
