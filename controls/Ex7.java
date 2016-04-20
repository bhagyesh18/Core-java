import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame7 extends JFrame {

    public MyFrame7() {
        setTitle("Ex7");
        setBounds(300, 100, 300, 100);
        Container contentPane = getContentPane();
        MyPanel7 mp = new MyPanel7();
        contentPane.add(mp);
    }
}

class MyPanel7 extends JPanel implements FocusListener {

    JLabel l1, l2;
    JTextField t1, t2;

    public MyPanel7() {
        GridLayout gl = new GridLayout(2, 2);
        setLayout(gl);
        l1 = new JLabel("Enter amount ");
        l2 = new JLabel("Enter name ");
        t1 = new JTextField("200", 10);
        t2 = new JTextField("Rahul ", 10);
        t1.addFocusListener(this);
        add(l1);
        add(t1);
        add(l2);
        add(t2);
    }

    public void focusGained(FocusEvent e) {
    }

    public void focusLost(FocusEvent e) {
        if (e.getComponent() == t1) {
            try {
                int amount = Integer.parseInt(t1.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Amount cannot be string\n Please enter amount");
                t1.requestFocusInWindow();
            }
        }
    }
}

public class Ex7 {

    public static void main(String args[]) {
        MyFrame7 mf = new MyFrame7();
        mf.show();
    }
}