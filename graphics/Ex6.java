import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame6 extends JFrame {

    public MyFrame6() {
        setTitle("Ex6");
        setBounds(100, 100, 600, 500);
        Container cn = getContentPane();
        cn.add(new MyPanel6());
        ImageIcon i1Icon = new ImageIcon("images/6.gif");
        Image i1Image = i1Icon.getImage();
        setIconImage(i1Image);
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class MyPanel6 extends JPanel {
    JButton b;
    public MyPanel6() {
        b = new JButton("Go Ahead");
        ImageIcon i2Icon = new ImageIcon("images/9.gif");
        b.setIcon(i2Icon);
        add(b);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

    }
}

public class Ex6 {

    public static void main(String[] args) {
        MyFrame6 mf = new MyFrame6();
        mf.show();
    }
}
