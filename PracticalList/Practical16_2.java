import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.sql.*;

class MyFrame16_2 extends JFrame {

    public MyFrame16_2() {
        setTitle("Book Maintenance");
        setBounds(200, 200, 500, 280);
        Container contentPane = getContentPane();
        MyPanel16_2 mp = new MyPanel16_2();
        contentPane.add(mp);
    }
}

class MyPanel16_2 extends JPanel implements ActionListener, ListSelectionListener {

    JScrollPane scroll;
    JList li;
    DefaultListModel model;
    JLabel lPrice, lQuantity, lTotal;
    JTextField tPrice, tQuantity, tTotal;
    JButton bCalculate, bSave, bClose;
    Connection cn;
    Statement st;
    ResultSet rs;
    String query;

    public MyPanel16_2() {
        model = new DefaultListModel();
        li = new JList(model);
        li.setVisibleRowCount(10);
        scroll = new JScrollPane(li);
        li.addListSelectionListener(this);
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
        bSave = new JButton("Save");
        bCalculate.addActionListener(this);
        bClose.addActionListener(this);
        bSave.addActionListener(this);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(bCalculate);
        buttonPanel.add(bSave);
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
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");//Load the JDBC-ODBC bridge driver
            cn = DriverManager.getConnection("jdbc:odbc:Practical15and16DSN");//Connection to database is done
            //st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            st = cn.createStatement();
            query = "SELECT * FROM books ORDER BY book_title";
            rs = st.executeQuery(query);
            while (rs.next()) {
                model.addElement(rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println("Exception from MyPanel1 constructor " + e);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bCalculate) {
            try {
                double price = Double.parseDouble(tPrice.getText());
                int quantity = Integer.parseInt(tQuantity.getText());
                double total = price * quantity;
                tTotal.setText(String.valueOf(total));
            } catch (Exception ex) {
                System.out.println("Exception while button pressed " + ex);
            }
        }
        if (e.getSource() == bSave) {
            try {
                String bookCode = "";
                int bookQuantity = Integer.parseInt(tQuantity.getText());
                String bookTitle = li.getSelectedValue().toString();
                query = "SELECT * FROM books WHERE book_title='" + bookTitle + "'";
                rs = st.executeQuery(query);
                if (rs.next()) {
                    bookCode = rs.getString(1);
                }
                query = "INSERT INTO book_orders(book_code, book_quantity) VALUES('" + bookCode + "', " + bookQuantity + ")";
                st.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Your order has been accepted.\nThanks for your cooperation");
            } catch (Exception ex) {
                System.out.println("Exception while button pressed " + ex);
            }
        }
        if (e.getSource() == bClose) {
            System.exit(0);
        }
    }

    public void valueChanged(ListSelectionEvent e) {
        try {
            String bookTitle = li.getSelectedValue().toString();
            query = "SELECT * FROM BOOKS WHERE book_title='" + bookTitle + "'";
            rs = st.executeQuery(query);
            if (rs.next()) {
                tPrice.setText(rs.getString(3));
                tQuantity.setText("");
                tQuantity.requestFocusInWindow();
            }
        } catch (Exception ex) {
            System.out.println("Exception while selecting title " + ex);
        }
    }
}

public class Practical16_2 {

    public static void main(String args[]) {
        MyFrame16_2 mf = new MyFrame16_2();
        mf.show();
    }
}
