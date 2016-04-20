import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame2 extends JFrame {

    JMenu file, records;

    public MyFrame2() {
        setTitle("Ex2");
        setBounds(300, 200, 300, 200);
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        file = new JMenu("File");
        records = new JMenu("Records");
        JMenuBar mb = new JMenuBar();
        mb.add(file);
        mb.add(records);
        //add(mb);
        setJMenuBar(mb);
    }
}

public class Ex2 {

    public static void main(String[] args) {
        MyFrame2 mf = new MyFrame2();
        mf.show();
    }
}
