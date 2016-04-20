import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame5 extends JFrame {

    public MyFrame5() {
        setTitle("Ex5");
        setBounds(200, 200, 400, 400);
        Container contentPane = getContentPane();
        MyPanel5 mp = new MyPanel5();
        contentPane.add(mp);
    }
}

class MyPanel5 extends JPanel {

    JLabel l1, l2, l3;
    JTextField t1, t2, t3;
    JButton b1, b2;

    public MyPanel5() {
        GridLayout gl = new GridLayout(3, 3);
        setLayout(gl);
        l1 = new JLabel("You are good.");
        l2 = new JLabel("You are not good.");
        l3 = new JLabel("What to say next? Keep silence.");
        t1 = new JTextField(20);
        t2 = new JTextField(30);
        t3 = new JTextField(40);
        b1 = new JButton("I am Button1");
        b2 = new JButton("I am Button2");
        JPanel jp = new JPanel();
        jp.add(b1);
        jp.add(b2);
        add(l1);
        add(l2);
        add(l3);
        add(t1);
        add(t2);
        add(t3);
        add(jp);
    }
}

public class Ex5 {

    public static void main(String args[]) {
        MyFrame5 mf = new MyFrame5();
        mf.show();
    }
}