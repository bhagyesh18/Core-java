import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame10 extends JFrame {

    public MyFrame10() {
        setTitle("Ex10");
        setBounds(100, 100, 600, 500);
        Container cn = getContentPane();
        cn.add(new MyPanel10());
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class MyPanel10 extends JPanel {

    public MyPanel10() {
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        Shape rectangle = new Rectangle2D.Double(120, 30, 70, 40);
        g2d.fill(rectangle);
        Shape roundRectangle = new RoundRectangle2D.Double(210, 30, 70, 40, 30, 30);
        g2d.fill(roundRectangle);
        Shape ellipse = new Ellipse2D.Double(300, 30, 70, 40);
        g2d.fill(ellipse);
        Shape arc = new Arc2D.Double(30, 90, 70, 40, 30, 120, Arc2D.PIE);
        g2d.fill(arc);

        int[] xPoints = {120, 155, 190};
        int[] yPoints = {130, 90, 130};
        Polygon triangle1 = new Polygon(xPoints, yPoints, 3);
        g2d.fillPolygon(triangle1);

        Polygon triagnle2 = new Polygon();
        triagnle2.addPoint(210, 110);
        triagnle2.addPoint(245, 90);
        triagnle2.addPoint(280, 110);
        g2d.fillPolygon(triagnle2);

        Polygon otherShape = new Polygon();
        otherShape.addPoint(300, 300);
        otherShape.addPoint(20, 350);
        otherShape.addPoint(400, 400);
        otherShape.addPoint(50, 200);
        g2d.fillPolygon(otherShape);
    }
}

public class Ex10 {

    public static void main(String[] args) {
        MyFrame10 mf = new MyFrame10();
        mf.show();
    }
}
