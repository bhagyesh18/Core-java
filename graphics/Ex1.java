import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame extends JFrame {

    public MyFrame() {
        setTitle("Ex1");
        setBounds(100, 100, 500, 500);
        Container cn = getContentPane();
        cn.add(new MyPanel());
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class MyPanel extends JPanel {

    public MyPanel() {
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("GANPAT", 20, 20);
    }
}

public class Ex1 {

    public static void main(String[] args) {
        MyFrame mf = new MyFrame();
        mf.show();
    }
}
