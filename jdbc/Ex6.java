import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;

class MyFrame6 extends JFrame {

    public MyFrame6() {
        setTitle("Ex6");
        setBounds(300, 200, 550, 110);
        Container contentPane = getContentPane();
        MyPanel6 mp = new MyPanel6();
        contentPane.add(mp);
        setResizable(false);
    }
}

class MyPanel6 extends JPanel implements ActionListener {

    JLabel lblRollNumber, lblName, lblPercent;
    JTextField tfRollNumber, tfName, tfPercent;
    JButton btnFirst, btnPrevious, btnNext, btnLast, btnExit, btnClear;
    Connection cn;
    Statement st;
    ResultSet rs;

    public MyPanel6() {
        JPanel labelsAndTextFields = new JPanel();
        labelsAndTextFields.add(lblRollNumber = new JLabel("Roll Number"));
        labelsAndTextFields.add(tfRollNumber = new JTextField(10));
        labelsAndTextFields.add(lblName = new JLabel("Name"));
        labelsAndTextFields.add(tfName = new JTextField(10));
        labelsAndTextFields.add(lblPercent = new JLabel("Percentage"));
        labelsAndTextFields.add(tfPercent = new JTextField(10));

        JPanel buttons = new JPanel();
        buttons.add(btnFirst = new JButton("First"));
        buttons.add(btnPrevious = new JButton("Previous"));
        buttons.add(btnNext = new JButton("Next"));
        buttons.add(btnLast = new JButton("Last"));
        buttons.add(btnClear = new JButton("Clear"));
        buttons.add(btnExit = new JButton("Exit"));
        btnFirst.addActionListener(this);
        btnPrevious.addActionListener(this);
        btnNext.addActionListener(this);
        btnLast.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        setLayout(new BorderLayout());
        add(labelsAndTextFields, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");//Load the JDBC-ODBC bridge driver
            cn = DriverManager.getConnection("jdbc:odbc:studentDSN");//Connection to database is done
            st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String query = "SELECT * FROM student ORDER BY s_roll_number";
            rs = st.executeQuery(query);
            rs.next();
            tfRollNumber.setText(rs.getString(1));
            tfName.setText(rs.getString(2));
            tfPercent.setText(rs.getString(3));
        } catch (Exception e) {
            System.out.println("Exception from MyPanel1 constructor " + e);
        }
    }

    public void actionPerformed(ActionEvent e) {
        try {
            Object ob = e.getSource();
            if (ob == btnFirst) {
                rs.first();
                tfRollNumber.setText(rs.getString(1));
                tfName.setText(rs.getString(2));
                tfPercent.setText(rs.getString(3));
            } else if (ob == btnLast) {
                rs.last();
                tfRollNumber.setText(rs.getString(1));
                tfName.setText(rs.getString(2));
                tfPercent.setText(rs.getString(3));
            } else if (ob == btnPrevious) {
                if (rs.isFirst() == false) {
                    rs.previous();
                    tfRollNumber.setText(rs.getString(1));
                    tfName.setText(rs.getString(2));
                    tfPercent.setText(rs.getString(3));
                }
            } else if (ob == btnNext) {
                if (rs.isLast() == false) {
                    rs.next();
                    tfRollNumber.setText(rs.getString(1));
                    tfName.setText(rs.getString(2));
                    tfPercent.setText(rs.getString(3));
                }
            } else if (ob == btnClear) {
                tfRollNumber.setText("");
                tfName.setText("");
                tfPercent.setText("");
            } else if (ob == btnExit) {
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println("actionPerformed " + ex);
        }
    }
}

public class Ex6 {

    public static void main(String[] args) {
        MyFrame6 mf = new MyFrame6();
        mf.show();
    }
}
