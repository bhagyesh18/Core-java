import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrametemp extends JFrame implements ActionListener {

    Container cp;
    JMenu color;
    JMenuItem red, blue;
    JMenuBar menuBar;

    public MyFrametemp() {
        setTitle("temp");
        setBounds(300, 200, 300, 200);
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        cp = getContentPane();
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

    }

    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if (s == red) {
            JOptionPane.showMessageDialog(null, "Red");
            cp.setBackground(Color.red);
        }
        if (s == blue) {
            JOptionPane.showMessageDialog(null, "Blue");
            cp.setBackground(Color.blue);
        }

    }
}

public class Ex4 {

    public static void main(String[] args) {
        MyFrametemp mf = new MyFrametemp();
        mf.show();
    }
}