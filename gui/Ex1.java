import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame1 extends JFrame {

    public MyFrame1() {
        setTitle("Book Maintenance");
        setBounds(200, 200, 375, 225);
        Container contentPane = getContentPane();
        MyPanel1 mp = new MyPanel1();
        contentPane.add(mp);
    }
}

class MyPanel1 extends JPanel //implements ActionListener, DocumentListener, KeyListener
{

    JButton addButton, updateButton, deleteButton, exitButton, firstButton, prevButton, nextButton, lastButton;
    JLabel codeLabel, titleLabel, priceLabel;
    JTextField codeField, titleField, priceField;
    boolean addFlag = false;
    NumberFormat currency = NumberFormat.getCurrencyInstance();
    //Book currentBook = null;

    public MyPanel1() {
        codeLabel = new JLabel("Code: ");
        codeField = new JTextField("", 7);
        titleLabel = new JLabel("Title: ");
        titleField = new JTextField("", 26);
        priceLabel = new JLabel("Price: ");
        priceField = new JTextField("", 7);

        JPanel updatePanel = new JPanel();
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        exitButton = new JButton("Exit");
        updatePanel.add(addButton);
        updatePanel.add(updateButton);
        updatePanel.add(deleteButton);
        updatePanel.add(exitButton);

        JPanel navigationPanel = new JPanel();
        firstButton = new JButton("First");
        prevButton = new JButton("Prev");
        nextButton = new JButton("Next");
        lastButton = new JButton("Last");
        navigationPanel.add(firstButton);
        navigationPanel.add(prevButton);
        navigationPanel.add(nextButton);
        navigationPanel.add(lastButton);

//        addButton.addActionListener(this);
//        updateButton.addActionListener(this);
//        deleteButton.addActionListener(this);
//        exitButton.addActionListener(this);
//        firstButton.addActionListener(this);
//        prevButton.addActionListener(this);
//        nextButton.addActionListener(this);
//        lastButton.addActionListener(this);
//        codeField.addKeyListener(this);
//        titleField.addKeyListener(this);
//        priceField.addKeyListener(this);
//        titleField.getDocument().addDocumentListener(this);
//        priceField.getDocument().addDocumentListener(this);

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 100;
        c.weighty = 100;
        c.ipadx = 5;

        c.anchor = GridBagConstraints.EAST;
        c = getConstraints(c, 1, 1, 1, 1);
        add(codeLabel, c);
        c = getConstraints(c, 1, 2, 1, 1);
        add(titleLabel, c);
        c = getConstraints(c, 1, 3, 1, 1);
        add(priceLabel, c);

        c.anchor = GridBagConstraints.WEST;
        c = getConstraints(c, 2, 1, 3, 1);
        add(codeField, c);
        c = getConstraints(c, 2, 2, 3, 1);
        add(titleField, c);
        c = getConstraints(c, 2, 3, 3, 1);
        add(priceField, c);

        c.anchor = GridBagConstraints.CENTER;
        c = getConstraints(c, 1, 4, 4, 1);
        add(updatePanel, c);
        c = getConstraints(c, 1, 5, 4, 1);
        add(navigationPanel, c);

//        try {
//            BookIO.open();
//            currentBook = BookIO.moveFirst();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Either file not fount or IO Exception");
//        }
//        performBookDisplay();
//        enableButtons(true);

    }

    private GridBagConstraints getConstraints(GridBagConstraints c, int x, int y, int width, int height) {
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        c.gridheight = height;
        return c;
    }
}

public class Ex1 {

    public static void main(String args[]) {
        MyFrame1 mf = new MyFrame1();
        mf.show();
    }
}
