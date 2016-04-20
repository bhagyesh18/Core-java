import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame6 extends JFrame {

    public MyFrame6() {
        setTitle("Ex5");
        setBounds(300, 100, 300, 300);
        Container contentPane = getContentPane();
        MyPanel6 mp = new MyPanel6();
        contentPane.add(mp);
    }
}

class MyPanel6 extends JPanel {

    public MyPanel6() {
        String[] str = {"String1", "String2", "String3", "String4", "String5", "String6", "String7", "String8", "String9", "String10"};
        JList li = new JList(str);
        JLabel lb1 = new JLabel("How are you label1?");
        JLabel lb2 = new JLabel("How are you label2?");
        JTextField te1 = new JTextField("Text1", 10);
        JTextField te2 = new JTextField("Text2", 10);
        JButton bu1 = new JButton("Hello, my name is button1");
        JButton bu2 = new JButton("Hello, my name is button2");
        JPanel jp = new JPanel();
        jp.add(bu1);
        jp.add(bu2);


        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 2;
        c.gridheight = 3;
        add(li, c);

        c.gridx = 3;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        add(lb1, c);

        c.gridy = 2;
        add(lb2, c);

        c.gridx = 4;
        c.gridy = 1;
        c.gridwidth = 2;
        c.gridheight = 1;
        add(te1, c);

        c.gridy = 2;
        add(te2, c);

        c.gridx = 3;
        c.gridy = 4;
        c.gridwidth = 3;
        c.gridheight = 1;
        add(jp, c);

    }
}

public class Ex6 {

    public static void main(String args[]) {
        MyFrame6 mf = new MyFrame6();
        mf.show();
    }
}