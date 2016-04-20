import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

class MyFrame3 extends JFrame {

    JMenu file, records, move;
    JMenuItem exit, end;
    JMenuItem add, update, delete;
    JMenuItem first, previous, next, last;
    JPopupMenu pm;
    JCheckBoxMenuItem resize;
    JLabel codeLabel, titleLabel, priceLabel;
    JTextField codeField, titleField, priceField;
    Container cp;

    public MyFrame3() {
        setTitle("Book Maintenance");
        setBounds(200, 200, 225, 150);
        cp = getContentPane();

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
        update.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, Event.CTRL_MASK + Event.ALT_MASK));
        delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, Event.CTRL_MASK + Event.ALT_MASK));

        first.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, Event.CTRL_MASK + Event.ALT_MASK));
        previous.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, Event.CTRL_MASK + Event.ALT_MASK));
        next.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK + Event.ALT_MASK));
        last.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, Event.CTRL_MASK + Event.ALT_MASK));

        JMenuBar mb = new JMenuBar();
        mb.add(file);
        mb.add(records);
        setJMenuBar(mb);

//        codeLabel = new JLabel("Code: ");
//        codeField = new JTextField("", 7);
//        titleLabel = new JLabel("Title: ");
//        titleField = new JTextField("", 12);
//        priceLabel = new JLabel("Price: ");
//        priceField = new JTextField("", 7);
//
//        setLayout(new GridBagLayout());
//        GridBagConstraints c = new GridBagConstraints();
//        c.weightx = 100;
//        c.weighty = 100;
//        c.ipadx = 5;
//
//        c.anchor = GridBagConstraints.EAST;
//        c = getConstraints(c, 1, 1, 1, 1);
//        add(codeLabel, c);
//        c = getConstraints(c, 1, 2, 1, 1);
//        add(titleLabel, c);
//        c = getConstraints(c, 1, 3, 1, 1);
//        add(priceLabel, c);
//
//        c.anchor = GridBagConstraints.WEST;
//        c = getConstraints(c, 2, 1, 3, 1);
//        add(codeField, c);
//        c = getConstraints(c, 2, 2, 3, 1);
//        add(titleField, c);
//        c = getConstraints(c, 2, 3, 3, 1);
//        add(priceField, c);
//
//        c.anchor = GridBagConstraints.CENTER;
//        c = getConstraints(c, 1, 4, 4, 1);
//
//        c = getConstraints(c, 1, 5, 4, 1);
//    }
//
//    private GridBagConstraints getConstraints(GridBagConstraints c, int x, int y, int width, int height) {
//        c.gridx = x;
//        c.gridy = y;
//        c.gridwidth = width;
//        c.gridheight = height;
//        return c;
    }
}

public class Ex3 {

    public static void main(String args[]) {
        MyFrame3 mf = new MyFrame3();
        mf.show();
    }
}
