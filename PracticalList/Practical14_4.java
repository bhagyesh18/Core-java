import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame14_4 extends JFrame {

    public MyFrame14_4() {
        setTitle("GUI for file handling.");
        setBounds(50, 50, 500, 500);
        Container cp = getContentPane();
        cp.add(new MyPanel14_4());
    }
}

class MyPanel14_4 extends JPanel implements ActionListener, ListSelectionListener {

    JTextField tf;
    JList list;
    JButton showFiles;
    DefaultListModel model;
    int counter = 0;

    public MyPanel14_4() {
        model = new DefaultListModel();
        list = new JList(model);
        JScrollPane pane = new JScrollPane(list);
        tf = new JTextField(10);
        showFiles = new JButton("Show Files.");
        showFiles.addActionListener(this);
        list.addListSelectionListener(this);
        add(tf);
        add(pane);
        add(showFiles);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == showFiles) {
            model.clear();
            File f1 = new File(tf.getText());
            String[] str = f1.list();
            for (int i = 0; i < str.length; i++) {
                File fTemp = new File(tf.getText() + "/" + str[i]);
                if (fTemp.isFile()) {
                    model.addElement(str[i]);
                }
            }
        }
    }

    public void valueChanged(ListSelectionEvent e) {
        if (e.getSource() == list) {
            try {
                int c = 0, w = 0, l = 1;
                FileReader fr = new FileReader(tf.getText() + "/" + list.getSelectedValue());
                StreamTokenizer st = new StreamTokenizer(fr);
                st.resetSyntax();		// To Set Default Set of Delimiters
                st.wordChars(32, 255);		// Range of Caracter that can be used in words
                st.whitespaceChars(0, ' ');	// Specify Valid White Space Characters
                st.eolIsSignificant(true);	// new line caracter is consider as token in case of true
                while (st.nextToken() != StreamTokenizer.TT_EOF) {
                    switch (st.ttype) // ttype: type of token
                    {
                        case StreamTokenizer.TT_EOL:
                            l++;
                            break;
                        case StreamTokenizer.TT_WORD:
                            w++;
                            c += st.sval.length();
                            break;
                    }
                }
                String s = "Number of characters " + c + "\n" + "Number of words " + w + "\n" + "Number of lines " + l;
                JOptionPane.showMessageDialog(null, s);
            } catch (Exception ex) {
            }
        }
    }
}

public class Practical14_4 {

    public static void main(String[] args) {
        MyFrame14_4 mf = new MyFrame14_4();
        mf.show();
    }
}
