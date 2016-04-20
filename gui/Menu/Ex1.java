import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame extends JFrame {

    public MyFrame() {
        setTitle("Ex1");
        setBounds(300, 200, 300, 200);
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

public class Ex1 {

    public static void main(String[] args) {
        MyFrame mf = new MyFrame();
        mf.show();
    }
}
