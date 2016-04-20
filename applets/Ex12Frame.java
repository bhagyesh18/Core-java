import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


class MyFrame12 extends JFrame {

    public MyFrame12() {
        setTitle("Ex12 with Frame");
        setBounds(50, 50, 400, 400);
        Container contentPane = getContentPane();
        contentPane.add(new MyPanel12());
    }
}
class MyPanel12 extends JPanel implements ActionListener {

    JList li;
    JTextArea ta;
    JButton bu1, bu2;

    public MyPanel12() {
        String[] str = {"a.txt", "b.txt", "Ex12.txt"};
        add(li = new JList(str));
        add(ta = new JTextArea(5, 20));
        add(bu1 = new JButton("Show content"));
        add(bu2 = new JButton("Save content"));
        bu1.addActionListener(this);
        bu2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bu1) {
            ta.setText("");
            int i;
            try {
                FileReader fr = new FileReader(li.getSelectedValue().toString());
                while ((i = fr.read()) != -1) {
                    ta.append(String.valueOf((char) i));
                }
                fr.close();
            } catch (Exception ex) {
            }
        }
        if (e.getSource() == bu2) {
            try {
                    FileWriter fw = new FileWriter(li.getSelectedValue().toString());
                    fw.write(ta.getText());
                    fw.close();
            } catch (Exception ex) {
            }
        }
    }
}

class Ex12Frame{
    public static void main(String[] args){
        MyFrame12 mf = new MyFrame12();
        mf.show();
    }
}