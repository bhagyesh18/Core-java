import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Vector;

class MyFrame3 extends JFrame {

    public MyFrame3() {
        setTitle("Ex3");
        setBounds(100, 100, 600, 500);
        Container cn = getContentPane();
        cn.add(new MyPanel3());
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class MyPanel3 extends JPanel {

    public MyPanel3() {
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        String s = "Hello, How are you? I am fine, thank you.";
        Font f1 = new Font("SansSerif", Font.BOLD + Font.ITALIC, 16);
        g.setFont(f1);
        FontMetrics fm = g.getFontMetrics();
        int widthOfString = fm.stringWidth(s);
        int heightOfString = fm.getHeight();
        int widthOfPanel = this.getWidth();
        int heightOfPanel = this.getHeight();
        g.drawString(s, (widthOfPanel - widthOfString) / 2, (heightOfPanel - heightOfString) / 2);
//        int widthOfLine = widthOfPanel - 40;
//        Vector v = new Vector();
//        String temp = "";
//        int maxLineWidth = 0;
//        for (int i = 0; i < s.length(); i++) {
//            temp = temp + s.charAt(i);
//            maxLineWidth = maxLineWidth + fm.charWidth(s.charAt(i));
//            if (maxLineWidth >= widthOfLine || (i == s.length() - 1)) {
//                v.add(temp);
//                maxLineWidth = 0;
//                temp = "";
//            }
//        }
//        int lines = v.size();
//        int y = (heightOfPanel - (heightOfString * lines)) / 2;
//        for (int i = 0; i < lines; i++) {
//            String st = (String) v.get(i);
//            g.drawString(st, 20, y + i * heightOfString);
//        }
    }
}

public class Ex3 {

    public static void main(String[] args) {
        MyFrame3 mf = new MyFrame3();
        mf.show();
    }
}
