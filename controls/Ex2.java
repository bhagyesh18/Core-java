import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame2 extends JFrame {

    public MyFrame2() {
        setTitle("Ex2");
        setBounds(200, 200, 400, 400);
        Container contentPane = getContentPane();
        MyPanel2 mp = new MyPanel2();
        contentPane.add(mp);
    }
}

class MyPanel2 extends JPanel implements ActionListener {

    JRadioButton jrb1, jrb2;

    public MyPanel2() {
        jrb1 = new JRadioButton("Go to Lab.");
        jrb2 = new JRadioButton("Go to Class.");
        jrb1.addActionListener(this);
        jrb2.addActionListener(this);
        ButtonGroup bg = new ButtonGroup();
        bg.add(jrb1);
        bg.add(jrb2);
        add(jrb1);
        add(jrb2);
    }

    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if (s == jrb1) {
            this.setBackground(Color.black);
        }
        if (s == jrb2) {
            this.setBackground(Color.green);
        }
    }
}

public class Ex2 {

    public static void main(String args[]) {
        MyFrame2 mf = new MyFrame2();
        mf.show();
    }
}