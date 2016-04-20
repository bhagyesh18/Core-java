import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame9 extends JFrame {

    JMenu file, records, move;
    JMenuItem exit, end;
    JMenuItem add, update, delete;
    JMenuItem first, previous, next, last;
    JPopupMenu pm;
    JCheckBoxMenuItem resize;
Container cp;
    public MyFrame9() {
        setTitle("Ex9");
        setBounds(300, 200, 300, 200);
        cp = getContentPane();
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
        add.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK + Event.ALT_MASK));
        first.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, Event.CTRL_MASK + Event.ALT_MASK));

        pm = new JPopupMenu();
        resize = new JCheckBoxMenuItem("Resize", true);
        end = new JMenuItem("End");
        pm.add(resize);
        pm.addSeparator();
        pm.add(end);

        update.setEnabled(false);
        JMenuBar mb = new JMenuBar();
        mb.add(file);
        mb.add(records);
        setJMenuBar(mb);
        
        cp.addMouseListener(new MouseAdapter() {

            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    pm.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
    }
}

public class Ex9 {

    public static void main(String[] args) {
        MyFrame9 mf = new MyFrame9();
        mf.show();
    }
}
