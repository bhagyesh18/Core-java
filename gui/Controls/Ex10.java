import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

class MyFrame10 extends JFrame implements WindowListener {

    public MyFrame10() {
        setTitle("Ex10");
        setBounds(200, 200, 200, 200);
        addWindowListener(this);
    }

    public void windowOpened(WindowEvent e) {
    }

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }
}

public class Ex10 {

    public static void main(String args[]) {
        MyFrame10 mf = new MyFrame10();
        mf.show();
    }
}