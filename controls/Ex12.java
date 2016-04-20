import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

class MyFrame12 extends JFrame {

    public MyFrame12() {
        setTitle("Ex12");
        setBounds(200, 200, 200, 200);
        CF cf = new CF();
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

public class Ex12 {

    public static void main(String args[]) {
        MyFrame12 mf = new MyFrame12();
        mf.show();
    }
}