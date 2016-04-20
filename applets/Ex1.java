import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
/*<applet code="Ex1" width=300 height=300></applet>*/
public class Ex1 extends JApplet {

    public void init() {
        Container contentPane = getContentPane();
        contentPane.add(new MyPanel());
    }
}

class MyPanel extends JPanel implements ActionListener{

    JButton calculate;

    public MyPanel() {
        add(calculate = new JButton("Red"));
        calculate.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == calculate){
            setBackground(Color.red);
        }
    }
}