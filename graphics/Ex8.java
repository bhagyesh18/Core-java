import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame8 extends JFrame {

    public MyFrame8() {
        setTitle("Ex8");
        setBounds(100, 100, 600, 500);
        Container cn = getContentPane();
        cn.add(new MyPanel8());
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class MyPanel8 extends JPanel {

    public MyPanel8() {
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.red);
        g.fillRect(120, 30, 70, 40);
        g.fillRoundRect(210, 30, 70, 40, 30, 30);
        g.setColor(Color.yellow);
        g.fillOval(300, 30, 70, 40);
        g.fillArc(30, 90, 70, 40, 30, 120);

        int[] xPoints = {120, 155, 190};
        int[] yPoints = {130, 90, 130};
        Polygon triangle1 = new Polygon(xPoints, yPoints, 3);
        g.setColor(Color.blue);
        g.fillPolygon(triangle1);

        Polygon triagnle2 = new Polygon();
        triagnle2.addPoint(210, 110);
        triagnle2.addPoint(245, 90);
        triagnle2.addPoint(280, 110);
        g.setColor(Color.green);
        g.fillPolygon(triagnle2);

        Polygon otherShape = new Polygon();
        otherShape.addPoint(300, 300);
        otherShape.addPoint(20, 350);
        otherShape.addPoint(400, 400);
        otherShape.addPoint(50, 200);
        g.setColor(Color.magenta);
        g.fillPolygon(otherShape);

    }
}

public class Ex8 {

    public static void main(String[] args) {
        MyFrame8 mf = new MyFrame8();
        mf.show();
    }
}
