import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame3 extends JFrame {

    JMenu file, records;
    JMenuItem exit;
    JMenuItem add, update, delete, move;

    public MyFrame3() {
        setTitle("Ex3");
        setBounds(300, 200, 300, 200);
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        file = new JMenu("File");
        exit = new JMenuItem("Exit");
        file.add(exit);

        records = new JMenu("Records");
        add = new JMenuItem("Add");
        update = new JMenuItem("Update");
        delete = new JMenuItem("Delete");
        move = new JMenuItem("Move");
        records.add(add);
        records.add(update);
        records.add(delete);
        records.addSeparator();
        records.add(move);

        update.setEnabled(false);
        JMenuBar mb = new JMenuBar();
        mb.add(file);
        mb.add(records);
        setJMenuBar(mb);
    }
}

public class Ex3 {

    public static void main(String[] args) {
        MyFrame3 mf = new MyFrame3();
        mf.show();
    }
}
