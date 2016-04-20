import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame5 extends JFrame {

    public MyFrame5() {
        setTitle("Ex5");
        setBounds(100, 100, 600, 500);
        Container cn = getContentPane();
        cn.add(new MyPanel5());
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class MyPanel5 extends JPanel {

    public MyPanel5() {
    
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image i1 = tk.getImage("images/1.jpg");
        Image i2 = tk.getImage("images/2.jpg");
        Image i3 = tk.getImage("images/9.gif");
      
        g.drawImage(i1, 50, 50, this);
        g.drawImage(i1, 400, 50, 100, 100, this);
        //g.drawImage(i1, 0, 0, getWidth(), getHeight(), this);
        g.drawImage(i2, 50, 300, this);
        g.drawImage(i3, 200, 300, this);
    }
}

public class Ex5 {

    public static void main(String[] args) {
        MyFrame5 mf = new MyFrame5();
        mf.show();
    }
}
