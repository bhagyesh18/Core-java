import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame8 extends JFrame {

    public MyFrame8() {
        setTitle("Ex8");
        setBounds(300, 100, 300, 100);
        Container contentPane = getContentPane();
        MyPanel8 mp = new MyPanel8();
        contentPane.add(mp);
    }
}

class MyPanel8 extends JPanel implements KeyListener {

    JLabel l1, l2;
    JTextField t1, t2, t3;
    JButton b;

    public MyPanel8() {
        GridLayout gl = new GridLayout(3, 2);
        setLayout(gl);
        l1 = new JLabel("Enter amount1 ");
        l2 = new JLabel("Enter amount2 ");
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        t3.setEditable(false);
        t2.addKeyListener(this);
        b = new JButton("Addition");

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b);
        add(t3);
    }

    public void keyPressed(KeyEvent e) {
        int kc = e.getKeyCode();
        if (kc == KeyEvent.VK_S && e.isAltDown()) {
            int amount1 = Integer.parseInt(t1.getText());
            int amount2 = Integer.parseInt(t2.getText());
            int sum = amount1 + amount2;
            Integer s = new Integer(sum);
            t3.setText(s.toString());
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}

public class Ex8 {

    public static void main(String args[]) {
        MyFrame8 mf = new MyFrame8();
        mf.show();
    }
}