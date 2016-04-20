import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MyFrame extends JFrame {
    
    public MyFrame() {
        setTitle("Ex1");
        setBounds(200, 200, 400, 400);
        Container contentPane = getContentPane();
        MyPanel mp = new MyPanel();
        contentPane.add(mp);
    }
}

class MyPanel extends JPanel implements DocumentListener {
    
    JTextField jt;
    JButton b1, b2;
    
    public MyPanel() {
        jt = new JTextField(10);
        b1 = new JButton("Button1");
        b2 = new JButton("Button2");
        jt.getDocument().addDocumentListener(this);
        add(jt);
        add(b1);
        add(b2);
    }
    
    public void insertUpdate(DocumentEvent e) {
        if (e.getDocument() == jt.getDocument()) {
            b1.setEnabled(false);
            b2.setText(jt.getText());
        }
    }
    
    public void removeUpdate(DocumentEvent e) {
    }
    
    public void changedUpdate(DocumentEvent e) {
    }
}

public class Ex1 {
    
    public static void main(String args[]) {
        MyFrame mf = new MyFrame();
        mf.show();
    }
}