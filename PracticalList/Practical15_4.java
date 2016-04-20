import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;
import java.sql.*;

class MyFrame15_4 extends JFrame {

    public MyFrame15_4() {
        setTitle("Book Maintenance");
        setBounds(200, 200, 375, 225);
        Container contentPane = getContentPane();
        MyPanel15_4 mp = new MyPanel15_4();
        contentPane.add(mp);
    }
}

class MyPanel15_4 extends JPanel implements ActionListener {

    JButton addButton, updateButton, deleteButton, exitButton, firstButton, prevButton, nextButton, lastButton;
    JLabel codeLabel, titleLabel, priceLabel;
    JTextField codeField, titleField, priceField;
    boolean addFlag = false;
    NumberFormat currency = NumberFormat.getCurrencyInstance();
    Connection cn;
    Statement st;
    ResultSet rs;

    public MyPanel15_4() {
        codeLabel = new JLabel("Code: ");
        codeField = new JTextField("", 7);
        titleLabel = new JLabel("Title: ");
        titleField = new JTextField("", 26);
        priceLabel = new JLabel("Price: ");
        priceField = new JTextField("", 7);

        JPanel updatePanel = new JPanel();
        addButton = new JButton("Add");
        addButton.addActionListener(this);
        updateButton = new JButton("Update");
        updateButton.addActionListener(this);
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        updatePanel.add(addButton);
        updatePanel.add(updateButton);
        updatePanel.add(deleteButton);
        updatePanel.add(exitButton);

        JPanel navigationPanel = new JPanel();
        firstButton = new JButton("First");
        firstButton.addActionListener(this);
        prevButton = new JButton("Prev");
        prevButton.addActionListener(this);
        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        lastButton = new JButton("Last");
        lastButton.addActionListener(this);
        navigationPanel.add(firstButton);
        navigationPanel.add(prevButton);
        navigationPanel.add(nextButton);
        navigationPanel.add(lastButton);

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
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");//Load the JDBC-ODBC bridge driver
            cn = DriverManager.getConnection("jdbc:odbc:Practical15and16DSN");//Connection to database is done
            st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM books");
        } catch (Exception e) {
            System.out.println("Exception from MyPanel15_2 constructor " + e);
        }
    }

    private GridBagConstraints getConstraints(GridBagConstraints c, int x, int y, int width, int height) {
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        c.gridheight = height;
        return c;
    }

    public void actionPerformed(ActionEvent e) {
        Object ob = e.getSource();
        String bookCode, bookTitle, query;
        double bookPrice;
        if (ob == addButton) {
            try {
                bookCode = codeField.getText();
                bookTitle = titleField.getText();
                bookPrice = Double.parseDouble(priceField.getText());
                query = "INSERT INTO books VALUES('" + bookCode + "', '" + bookTitle + "', " + bookPrice + ")";
                st.executeUpdate(query);
                codeField.setText("");
                titleField.setText("");
                priceField.setText("");
                JOptionPane.showMessageDialog(null, "Record saved successfully.");
            } catch (Exception ex) {
                System.out.println("Exception from addButton event handling " + ex);
            }
        }
        if (ob == updateButton) {
            try {
                bookCode = codeField.getText();
                bookTitle = titleField.getText();
                bookPrice = Double.parseDouble(priceField.getText());
                query = "UPDATE books SET book_title='" + bookTitle + "', book_price=" + bookPrice + " WHERE book_code='" + bookCode + "'";
                st.executeUpdate(query);
                codeField.setText("");
                titleField.setText("");
                priceField.setText("");
                JOptionPane.showMessageDialog(null, "Record updated successfully.");
            } catch (Exception ex) {
                System.out.println("Exception from updateButton event handling " + ex);
            }
        }
        if (ob == deleteButton) {
            try {
                bookCode = codeField.getText();
                query = "DELETE FROM books WHERE book_code='" + bookCode + "'";
                st.executeUpdate(query);
                codeField.setText("");
                titleField.setText("");
                priceField.setText("");
                JOptionPane.showMessageDialog(null, "Record deleted successfully.");
            } catch (Exception ex) {
                System.out.println("Exception from deleteButton event handling " + ex);
            }
        }
        if (ob == exitButton) {
            System.exit(0);
        }
        try {
            if (ob == firstButton) {
                rs.first();
                codeField.setText(rs.getString(1));
                titleField.setText(rs.getString(2));
                priceField.setText(rs.getString(3));
            } else if (ob == lastButton) {
                rs.last();
                codeField.setText(rs.getString(1));
                titleField.setText(rs.getString(2));
                priceField.setText(rs.getString(3));
            } else if (ob == prevButton) {
                if (rs.isFirst() == false) {
                    rs.previous();
                    codeField.setText(rs.getString(1));
                    titleField.setText(rs.getString(2));
                    priceField.setText(rs.getString(3));
                }
            } else if (ob == nextButton) {
                if (rs.isLast() == false) {
                    rs.next();
                    codeField.setText(rs.getString(1));
                    titleField.setText(rs.getString(2));
                    priceField.setText(rs.getString(3));
                }
            }
        } catch (Exception ex) {
            System.out.println("Navigation problem " + ex);
        }
    }
}

public class Practical15_4 {

    public static void main(String args[]) {
        MyFrame15_4 mf = new MyFrame15_4();
        mf.show();
    }
}
