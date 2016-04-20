import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame7 extends JFrame {

    JMenu file, records, move;
    JMenuItem exit;
    JMenuItem add, update, delete;
    JMenuItem first, previous, next, last;

    public MyFrame7() {
        setTitle("Ex7");
        setBounds(300, 200, 300, 200);
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        file = new JMenu("File");
        file.setMnemonic('F');
        exit = new JMenuItem("Exit", 'x');
        file.add(exit);

        records = new JMenu("Records");
        records.setMnemonic('R');
        add = new JMenuItem("Add", 'A');
        update = new JMenuItem("Update", 'U');
        delete = new JMenuItem("Delete", 'D');

        move = new JMenu("Move");
        move.setMnemonic('M');
        first = new JMenuItem("First", 'F');
        previous = new JMenuItem("Previous", 'P');
        next = new JMenuItem("Next", 'N');
        last = new JMenuItem("Last", 'L');
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

public class Ex7 {

    public static void main(String[] args) {
        MyFrame7 mf = new MyFrame7();
        mf.show();
    }
}
