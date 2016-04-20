import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame2 extends JFrame {

    public MyFrame2() {
        setTitle("Ex2");
        setBounds(100, 100, 600, 500);
        Container cn = getContentPane();
        cn.add(new MyPanel2());
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class MyPanel2 extends JPanel {

    JButton b1, b2;
    JList li;
    JScrollPane sp;

    public MyPanel2() {
        b1 = new JButton("I am button1");
        b2 = new JButton("I am button2");
        Font f1 = new Font("SansSerif", Font.ITALIC, 22);
        b1.setFont(f1);
        Font f2 = new Font("DialogInput", Font.BOLD, 20);
        b2.setFont(f2);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fonts = ge.getAvailableFontFamilyNames();
        li = new JList(fonts);
        li.setVisibleRowCount(5);
        sp = new JScrollPane(li);
        add(b1);
        add(b2);
        add(sp);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        String s = "Hello, How are you?";
        Font f1 = new Font("Serif", Font.BOLD, 16);
        Font f2 = new Font("Helvetica", Font.PLAIN, 18);
        Font f3 = new Font("Dialog", Font.BOLD + Font.ITALIC, 20);
        g.setFont(f1);
        g.drawString(s, 20, 100);
        g.setFont(f2);
        g.drawString(s, 20, 140);
        g.setFont(f3);
        g.drawString(s, 20, 180);
    }
}

public class Ex2 {

    public static void main(String[] args) {
        MyFrame2 mf = new MyFrame2();
        mf.show();
    }
}
