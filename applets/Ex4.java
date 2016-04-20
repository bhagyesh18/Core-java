import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
/*<applet code="Ex4" width=250 height=200></applet>*/

public class Ex4 extends JApplet {

    Container contentPane;

    public void init() {
        contentPane = getContentPane();
        contentPane.add(new MyPanel4());
    }
}

class MyPanel4 extends JPanel implements Runnable {

    int counter = 0;
    Thread t;

    public MyPanel4() {
        counter = 0;//Initialize counter
        t = new Thread(this);
        t.start();
    }

    public void run() {
        try {
            while (true) {
                repaint();
                Thread.sleep(1000);
                ++counter;
            }
        } catch (Exception e) {
            System.out.println("th" + e);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Serif", Font.BOLD, 36));
        g.drawString(String.valueOf(counter),20, 30);

    }
}
