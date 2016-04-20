import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame4 extends JFrame {

    public MyFrame4() {
        setTitle("Ex4");
        setBounds(200, 200, 400, 400);
        Container contentPane = getContentPane();
        MyPanel4 mp = new MyPanel4();
        contentPane.add(mp);
    }
}

class MyPanel4 extends JPanel {

    JLabel l1, l2, l3;
    JTextField t1, t2, t3;
    JButton b1, b2;

    public MyPanel4() {
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
        add(l1);
        add(l2);
        add(l3);
        add(t1);
        add(t2);
        add(t3);
        add(b1);
        add(b2);
    }
}

public class Ex4 {

    public static void main(String args[]) {
        MyFrame4 mf = new MyFrame4();
        mf.show();
    }
}