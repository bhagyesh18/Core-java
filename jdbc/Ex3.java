import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;

class MyFrame3 extends JFrame {

    public MyFrame3() {
        setTitle("Ex3");
        setBounds(300, 200, 300, 200);
        Container contentPane = getContentPane();
        MyPanel3 mp = new MyPanel3();
        contentPane.add(mp);
    }
}

class MyPanel3 extends JPanel implements ActionListener {

    JLabel lblRollNumber, lblName, lblPercent;
    JTextField tfRollNumber, tfName, tfPercent;
    JButton btnDelete, btnExit;
    Connection cn;
    Statement st;

    public MyPanel3() {
        setLayout(new GridLayout(4, 2));
        add(lblRollNumber = new JLabel("Roll Number"));
        add(tfRollNumber = new JTextField(10));
        add(lblName = new JLabel("Name"));
        add(tfName = new JTextField(10));
        add(lblPercent = new JLabel("Percentage"));
        add(tfPercent = new JTextField(10));
        add(btnExit = new JButton("Exit"));
        add(btnDelete = new JButton("Delete"));
        btnDelete.addActionListener(this);
        btnExit.addActionListener(this);
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");//Load the JDBC-ODBC bridge driver
            cn = DriverManager.getConnection("jdbc:odbc:studentDSN");//Connection to database is done
            st = cn.createStatement();
        } catch (Exception e) {
            System.out.println("Exception from MyPanel3 constructor " + e);
        }
    }

    public void actionPerformed(ActionEvent e) {
        Object ob = e.getSource();
        String rollNumber, query;
        if (ob == btnDelete) {
            try {
                rollNumber = tfRollNumber.getText();
                query = "DELETE FROM student WHERE s_roll_number = '" + rollNumber + "'";
                st.executeUpdate(query);
                tfRollNumber.setText("");
                JOptionPane.showMessageDialog(null, "Record deleted successfully.");
            } catch (Exception ex) {
                System.out.println("Exception from btnDelete event handling " + ex);
            }
        }
        if (ob == btnExit) {
            System.exit(0);
        }
    }
}

public class Ex3 {

    public static void main(String[] args) {
        MyFrame3 mf = new MyFrame3();
        mf.show();
    }
}
