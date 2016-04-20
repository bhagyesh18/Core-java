import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;



class MyFrame2 extends JFrame {
    
    public MyFrame2() {
        setTitle("Book Maintenance");
        setBounds(200, 200, 450, 250);
        Container contentPane = getContentPane();
        MyPanel2 mp = new MyPanel2();
        contentPane.add(mp);
    }
}

class MyPanel2 extends JPanel {
    
    JScrollPane scroll;
    JList li;
    JLabel lPrice, lQuantity, lTotal;
    JTextField tPrice, tQuantity, tTotal;
    JButton bCalculate, bClose;
    
    public MyPanel2() {
        String[] stringArray = {"Data Structures","Structrued Computer Organization","Operating Systems by Galvin","Let us C","Programming in ANSI C","Communication & Networking","Teach Youself Java", "Complete Reference Java 2", "Murach's Beggining Java 2", "The Class of Java", "Java 6 Black Book", "Teach Youself Java", "Complete Reference Java 2", "Murach's Beggining Java 2", "The Class of Java", "Java 6 Black Book"};
        li = new JList(stringArray);
        li.setVisibleRowCount(8);
        scroll = new JScrollPane(li);
        Border etched = BorderFactory.createEtchedBorder();
        Border title = BorderFactory.createTitledBorder(etched, "Book Titles");
        scroll.setBorder(title);
        
        lPrice = new JLabel("Price");
        lQuantity = new JLabel("Quantity");
        lTotal = new JLabel("Total");
        tPrice = new JTextField(10);
        tPrice.setEnabled(false);
        tQuantity = new JTextField(10);
        tTotal = new JTextField(10);
        tTotal.setEnabled(false);
        bCalculate = new JButton("Calculate");
        bClose = new JButton("Close");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(bCalculate);
        buttonPanel.add(bClose);
        
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 100;
        c.weighty = 100;
        c.ipadx = 5;
        
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 2;
        c.gridheight = 3;
        c.anchor = GridBagConstraints.NORTHWEST;
        add(scroll, c);
        
        c.gridx = 3;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.EAST;
        add(lPrice, c);
        c.gridy = 2;
        add(lQuantity, c);
        c.gridy = 3;
        add(lTotal, c);
        
        c.gridx = 4;
        c.gridy = 1;
        c.gridwidth = 2;
        
        c.anchor = GridBagConstraints.WEST;
        add(tPrice, c);
        c.gridy = 2;
        add(tQuantity, c);
        c.gridy = 3;
        add(tTotal, c);
        
        c.gridx = 3;
        c.gridy = 4;
        c.gridwidth = 3;
        c.anchor = GridBagConstraints.EAST;
        add(buttonPanel, c);
        
        
        
        
    }
}

public class Ex2 {
    
    public static void main(String args[]) {
        MyFrame2 mf = new MyFrame2();
        mf.show();
    }
}
