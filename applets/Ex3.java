import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
//<applet code="Ex3" width=260 height=260></applet>
public class Ex3 extends JApplet {

    public void init() {
        Container contentPane = getContentPane();
        contentPane.add(new MyPanel3());
    }
}

class MyPanel3 extends JPanel {

    Color colors[] = {Color.black, Color.blue, Color.cyan, Color.darkGray, Color.gray, Color.green, Color.lightGray, Color.magenta, Color.orange, Color.pink, Color.red, Color.white, Color.yellow};

    public MyPanel3() {
    }

    public void paintComponent(Graphics g) {
        int deltax = 260 / colors.length;
        for (int i = 0; i < colors.length; i++) {
            g.setColor(colors[i]);
            g.fillRect(i * deltax, 0, (i + 1) * deltax, 260);
        }
    }
}
