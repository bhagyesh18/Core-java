import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class KA extends KeyAdapter {

    public void keyPressed(KeyEvent e) {
        int kc = e.getKeyCode();
        if (kc == KeyEvent.VK_S && e.isAltDown()) {
            int amount1 = Integer.parseInt(MyPanel9.t1.getText());
            int amount2 = Integer.parseInt(MyPanel9.t2.getText());
            int sum = amount1 + amount2;
            Integer s = new Integer(sum);
            MyPanel9.t3.setText(s.toString());
        }
    }
}

class MyFrame9 extends JFrame {

    public MyFrame9() {
        setTitle("Ex9");
        setBounds(300, 100, 300, 100);
        Container contentPane = getContentPane();
        MyPanel9 mp = new MyPanel9();
        contentPane.add(mp);
    }
}

class MyPanel9 extends JPanel {

    JLabel l1, l2;
    static JTextField t1, t2, t3;
    JButton b;

    public MyPanel9() {
        GridLayout gl = new GridLayout(3, 2);
        setLayout(gl);
        l1 = new JLabel("Enter amount1 ");
        l2 = new JLabel("Enter amount2 ");
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        t3.setEditable(false);
        t2.addKeyListener(new KA());
        b = new JButton("Addition");

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b);
        add(t3);
    }
}

public class Ex9 {

    public static void main(String args[]) {
        MyFrame9 mf = new MyFrame9();
        mf.show();
    }
}