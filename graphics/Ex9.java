import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame9 extends JFrame {

    public MyFrame9() {
        setTitle("Ex9");
        setBounds(100, 100, 600, 500);
        Container cn = getContentPane();
        cn.add(new MyPanel9());
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class MyPanel9 extends JPanel {

    public MyPanel9() {
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        
        Shape line = new Line2D.Double(100, 30, 30, 70);
        g2d.draw(line);
        Shape rectangle = new Rectangle2D.Double(120, 30, 70, 40);
        g2d.draw(rectangle);
        Shape roundRectangle = new RoundRectangle2D.Double(210, 30, 70, 40, 30, 30);
        g2d.draw(roundRectangle);
        Shape ellipse = new Ellipse2D.Double(300, 30, 70, 40);
        g2d.draw(ellipse);
        Shape arc = new Arc2D.Double(30, 90, 70, 40, 30, 120, Arc2D.PIE);
        g2d.draw(arc);

        int[] xPoints = {120, 155, 190};
        int[] yPoints = {130, 90, 130};
        Polygon triangle1 = new Polygon(xPoints, yPoints, 3);
        g2d.drawPolygon(triangle1);

        Polygon triagnle2 = new Polygon();
        triagnle2.addPoint(210, 110);
        triagnle2.addPoint(245, 90);
        triagnle2.addPoint(280, 110);
        g2d.drawPolygon(triagnle2);

        Polygon otherShape = new Polygon();
        otherShape.addPoint(300, 300);
        otherShape.addPoint(20, 350);
        otherShape.addPoint(400, 400);
        otherShape.addPoint(50, 200);
        g2d.drawPolygon(otherShape);
    }
}

public class Ex9 {

    public static void main(String[] args) {
        MyFrame9 mf = new MyFrame9();
        mf.show();
    }
}
