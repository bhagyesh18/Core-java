import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame6 extends JFrame {

    JMenu file, records, move;
    JMenuItem exit;
    JMenuItem add, update, delete;
    JMenuItem first, previous, next, last;

    public MyFrame6() {
        setTitle("Ex6");
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

        move = new JMenu("Move");
        first = new JMenuItem("First");
        previous = new JMenuItem("Previous");
        next = new JMenuItem("Next");
        last = new JMenuItem("Last");
        move.add(first);
        move.add(previous);
        move.add(next);
        move.add(last);

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

public class Ex6 {

    public static void main(String[] args) {
        MyFrame6 mf = new MyFrame6();
        mf.show();
    }
}
