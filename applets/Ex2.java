import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
/*<applet code="Ex2" width=300 height=300></applet>*/
public class Ex2 extends JApplet {

    public void init() {
        Container contentPane = getContentPane();
        contentPane.add(new MyPanel2());
    }
}

class MyPanel2 extends JPanel implements ActionListener{

    JButton append;
    JTextArea ta;

    public MyPanel2() {
        add(append = new JButton("append"));
        append.addActionListener(this);
        add(ta = new JTextArea(6, 11));
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == append){
            ta.append("Hello ");
        }
    }
}