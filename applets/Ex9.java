import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
//<applet code="Ex9" width=260 height=260></applet>
public class Ex9 extends JApplet {

    public void init() {
        Container contentPane = getContentPane();
        contentPane.add(new MyPanel9());
    }
}

class MyPanel9 extends JPanel {

    Point p = null;

    public MyPanel9() {
        addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                p = e.getPoint();
                repaint();
            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (p != null) {
            
            Dimension d = getSize();
            g.drawLine(d.width / 2, d.height / 2, p.x, p.y);
        }
    }
}
