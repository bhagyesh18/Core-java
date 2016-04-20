import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
//<applet code="Ex13" width=260 height=260></applet>
public class Ex13 extends JApplet {

    public void init() {
        Container contentPane = getContentPane();
        contentPane.add(new MyPanel13());
    }
}

class MyPanel13 extends JPanel implements MouseMotionListener {

    JLabel la;

    public MyPanel13() {
        add(la = new JLabel(""));
        addMouseMotionListener(this);
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
        la.setText("Mouse moved at " + e.getX() + " by " + e.getY());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
