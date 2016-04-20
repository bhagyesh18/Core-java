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
 setTitle("Ex4");
        setBounds(200, 200, 400, 400);
        Container contentPane = getContentPane();
        MyFrame71 mf = new MyFrame71();
        contentPane.add(mf);
       
       
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

class MyFrame71 extends JPanel {

    JLabel l1, l2, l3;
    JTextField t1, t2, t3;
  

    public MyFrame71() {
        
        l1 = new JLabel("Code");
        l2 = new JLabel("Title.");
        l3 = new JLabel("Price");
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        add(l1);
        add(l2);
        add(l3);
        add(t1);
        add(t2);
        add(t3);
      
    }
}

public class Ex7 {

    public static void main(String[] args) {
        MyFrame7 mf = new MyFrame7();
        mf.show();
    }
}
