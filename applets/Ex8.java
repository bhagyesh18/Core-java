import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
//<applet code="Ex8" width=260 height=260></applet>

public class Ex8 extends JApplet {

    public void init() {
        Container contentPane = getContentPane();
        contentPane.add(new MyPanel8());
    }
}

class MyPanel8 extends JPanel {

    String str = "";

    public MyPanel8() {
        setBackground(Color.green);
        addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                setBackground(Color.red);
            }

            public void mouseReleased(MouseEvent e) {
                setBackground(Color.green);
            }

            public void mouseEntered(MouseEvent e) {
                str = "Mouse Entered.";
                repaint();
            }

            public void mouseExited(MouseEvent e) {
                str = "Mouse Exited.";
                repaint();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {

            public void mouseDragged(MouseEvent e) {
                str = "Mouse dragged.";
                repaint();
            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(str, 50, 50);
    }
}
