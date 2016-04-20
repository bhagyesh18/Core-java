import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
//<applet code="Ex7" width=260 height=260></applet>
public class Ex7 extends JApplet {

    public void init() {
        Container contentPane = getContentPane();
        contentPane.add(new MyPanel7());
    }
}

class MyPanel7 extends JPanel implements ListSelectionListener {

    JTextArea ta;
    JList list;

    public MyPanel7() {
        String[] str = {"Hydrogen", "Helium", "Carbon", "Oxyzon", "Potassium"};
        list = new JList(str);
        list.addListSelectionListener(this);
        add(list);
        ta = new JTextArea(10, 20);
        add(ta);
    }

    public void valueChanged(ListSelectionEvent e) {
        ta.append(list.getSelectedValue().toString() + "\n");
    }
}
