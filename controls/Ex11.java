import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

class CF extends WindowAdapter {

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}

class MyFrame11 extends JFrame {

    public MyFrame11() {
        setTitle("Ex11");
        setBounds(200, 200, 200, 200);
        CF cf = new CF();
        addWindowListener(cf);
    }
}

public class Ex11 {

    public static void main(String args[]) {
        MyFrame11 mf = new MyFrame11();
        mf.show();
    }
}