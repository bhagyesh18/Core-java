import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame4 extends JFrame {

    public MyFrame4() {
        setTitle("Ex4");
        setBounds(100, 100, 600, 500);
        Container cn = getContentPane();
        cn.add(new MyPanel4());
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class MyPanel4 extends JPanel {

    JButton b;

    public MyPanel4() {
        b = new JButton("Button Text");
        add(b);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        g.drawString("Are you OK?", 20, 100);
        g.setColor(SystemColor.desktop);
        g.drawString("Are you OK?", 20, 140);
        b.setBackground(Color.green);
        b.setForeground(Color.blue);
    }
}

public class Ex4 {

    public static void main(String[] args) {
        MyFrame4 mf = new MyFrame4();
        mf.show();
    }
}
