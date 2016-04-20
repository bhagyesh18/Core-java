import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame3 extends JFrame {

    public MyFrame3() {
        setTitle("Ex1");
        setBounds(200, 200, 400, 400);
        Container contentPane = getContentPane();
        MyPanel3 mp = new MyPanel3();
        contentPane.add(mp);
    }
}

class MyPanel3 extends JPanel implements ActionListener {

    JCheckBox jc;
    JButton jb;

    public MyPanel3() {
        jc = new JCheckBox("Enable/Disable");
        jc.addActionListener(this);
        jb = new JButton("Sample Button");
        add(jc);
        add(jb);
    }

    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if (s == jc) {
            if (jc.isSelected()) {
                jb.setEnabled(true);
            }
            if (!jc.isSelected()) {
                jb.setEnabled(false);
            }
        }
    }
}

public class Ex3 {

    public static void main(String args[]) {
        MyFrame3 mf = new MyFrame3();
        mf.show();
    }
}