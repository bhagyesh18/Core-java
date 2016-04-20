import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
//<applet code="Ex11" width=260 height=260></applet>
public class Ex11 extends JApplet {

    public void init() {
        Container contentPane = getContentPane();
        contentPane.add(new MyPanel11());
    }
}

class MyPanel11 extends JPanel implements ActionListener {

    JLabel la;
    JTextField tf;
    JButton bu;
    JTextArea ta;

    public MyPanel11() {
        add(la = new JLabel("Enter number"));
        add(tf = new JTextField(2));
        add(ta = new JTextArea(12, 15));
        add(bu = new JButton("Show table"));
        bu.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        ta.setText("");
        int t = Integer.parseInt(tf.getText());
        int temp = 0;
        for (int i = 1; i < 11; i++) {
            temp = i * t;
            ta.append(i + " * " + t + " = " + temp + "\n");
        }
    }
}
