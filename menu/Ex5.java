import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame5 extends JFrame implements ActionListener {

    Container cp;
    JMenu color;
    JMenuItem red, blue;
    JMenuBar menuBar;
    JLabel label1;

    public MyFrame5() {
        setTitle("Ex5");
        setBounds(300, 200, 300, 200);
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        cp = getContentPane();
        cp.setLayout(new GridLayout(1, 1));
        menuBar = new JMenuBar();
        color = new JMenu("Color");
        red = new JMenuItem("Red");
        blue = new JMenuItem("Blue");
        red.addActionListener(this);
        blue.addActionListener(this);
        color.add(red);
        color.add(blue);
        menuBar.add(color);
        setJMenuBar(menuBar);
        label1 = new JLabel("Change color");
        cp.add(label1);

    }

    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if (s == red) {
            JOptionPane.showMessageDialog(null, "Red");
            cp.setBackground(Color.red);
            label1.setText("Red Color");
        }
        if (s == blue) {
            JOptionPane.showMessageDialog(null, "Blue");
            cp.setBackground(Color.blue);
            label1.setText("Blue Color");
        }

    }
}

public class Ex5 {

    public static void main(String[] args) {
        MyFrame5 mf = new MyFrame5();
        mf.show();
    }
}
