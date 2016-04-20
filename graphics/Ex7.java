import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame7 extends JFrame {

    public MyFrame7() {
        setTitle("Ex7");
        setBounds(100, 100, 600, 500);
        Container cn = getContentPane();
        cn.add(new MyPanel7());
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class MyPanel7 extends JPanel {

    public MyPanel7() {
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(100, 30, 30, 70);
        g.drawRect(120, 30, 70, 40);
        g.drawRoundRect(210, 30, 70, 40, 30, 30);
        g.drawOval(300, 30, 70, 40);
        g.drawArc(30, 90, 70, 40, 30, 120);

        int[] xPoints = {120, 155, 190};
        int[] yPoints = {130, 90, 130};
        Polygon triangle1 = new Polygon(xPoints, yPoints, 3);
        g.drawPolygon(triangle1);

        Polygon triagnle2 = new Polygon();
        triagnle2.addPoint(210, 110);
        triagnle2.addPoint(245, 90);
        triagnle2.addPoint(280, 110);
        g.drawPolygon(triagnle2);

        Polygon otherShape = new Polygon();
        otherShape.addPoint(300, 300);
        otherShape.addPoint(20, 350);
        otherShape.addPoint(400, 400);
        otherShape.addPoint(50, 200);
        g.drawPolygon(otherShape);

    }
}

public class Ex7 {

    public static void main(String[] args) {
        MyFrame7 mf = new MyFrame7();
        mf.show();
    }
}
