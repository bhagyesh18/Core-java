import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;

class MyFrame2 extends JFrame {

    public MyFrame2() {
        setTitle("Ex2");
        setBounds(300, 200, 300, 200);
        Container contentPane = getContentPane();
        MyPanel2 mp = new MyPanel2();
        contentPane.add(mp);
    }
}

class MyPanel2 extends JPanel implements ActionListener {

    JLabel lblRollNumber, lblName, lblPercent;
    JTextField tfRollNumber, tfName, tfPercent;
    JButton btnUpdate, btnExit;
    Connection cn;
    Statement st;

    public MyPanel2() {
        setLayout(new GridLayout(4, 2));
        add(lblRollNumber = new JLabel("Roll Number"));
        add(tfRollNumber = new JTextField(10));
        add(lblName = new JLabel("Name"));
        add(tfName = new JTextField(10));
        add(lblPercent = new JLabel("Percentage"));
        add(tfPercent = new JTextField(10));
        add(btnExit = new JButton("Exit"));
        add(btnUpdate = new JButton("Update"));
        btnUpdate.addActionListener(this);
        btnExit.addActionListener(this);
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");//Load the JDBC-ODBC bridge driver
            cn = DriverManager.getConnection("jdbc:odbc:studentDSN");//Connection to database is done
            st = cn.createStatement();
        } catch (Exception e) {
            System.out.println("Exception from MyPanel2 constructor "+e);
        }
    }

    public void actionPerformed(ActionEvent e) {
        Object ob = e.getSource();
        String rollNumber, name, query;
        double percent;
        if (ob == btnUpdate) {
            try {
                rollNumber = tfRollNumber.getText();
                name = tfName.getText();
                percent = Double.parseDouble(tfPercent.getText());
                query = "UPDATE student SET s_name = '" + name + "',s_percent = " + percent + " WHERE s_roll_number = '" + rollNumber + "'";
                st.executeUpdate(query);
                tfRollNumber.setText("");
                tfName.setText("");
                tfPercent.setText("");
                JOptionPane.showMessageDialog(null, "Record updated successfully.");
            } catch (Exception ex) {
                System.out.println("Exception from btnUpdate event handling "+ex);
            }
        }
        if (ob == btnExit) {
            System.exit(0);
        }
    }
}

public class Ex2 {

    public static void main(String[] args) {
        MyFrame2 mf = new MyFrame2();
        mf.show();
    }
}
