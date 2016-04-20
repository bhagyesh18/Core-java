import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;

class MyFrame1 extends JFrame {

    public MyFrame1() {
        setTitle("Ex1");
        setBounds(300, 200, 300, 200);
        Container contentPane = getContentPane();
        MyPanel1 mp = new MyPanel1();
        contentPane.add(mp);
    }
}

class MyPanel1 extends JPanel implements ActionListener {

    JLabel lblRollNumber, lblName, lblPercent;
    JTextField tfRollNumber, tfName, tfPercent;
    JButton btnInsert, btnExit;
    Connection cn;
    Statement st;

    public MyPanel1() {
        setLayout(new GridLayout(4, 2));
        add(lblRollNumber = new JLabel("Roll Number"));
        add(tfRollNumber = new JTextField(10));
        add(lblName = new JLabel("Name"));
        add(tfName = new JTextField(10));
        add(lblPercent = new JLabel("Percentage"));
        add(tfPercent = new JTextField(10));
        add(btnExit = new JButton("Exit"));
        add(btnInsert = new JButton("Insert"));
        btnInsert.addActionListener(this);
        btnExit.addActionListener(this);
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");//Load the JDBC-ODBC bridge driver
            cn = DriverManager.getConnection("jdbc:odbc:studentDSN");//Connection to database is done
            st = cn.createStatement();
        } catch (Exception e) {
            System.out.println("Exception from MyPanel1 constructor "+e);
        }
    }

    public void actionPerformed(ActionEvent e) {
        Object ob = e.getSource();
        String rollNumber, name, query;
        double percent;
        if (ob == btnInsert) {
            try {
                rollNumber = tfRollNumber.getText();
                name = tfName.getText();
                percent = Double.parseDouble(tfPercent.getText());
                query = "INSERT INTO student VALUES('" + rollNumber + "','" + name + "'," + percent + ")";
                st.executeUpdate(query);
                tfRollNumber.setText("");
                tfName.setText("");
                tfPercent.setText("");
                JOptionPane.showMessageDialog(null, "Record saved successfully.");
            } catch (Exception ex) {
                System.out.println("Exception from btnInsert event handling "+ex);
            }
        }
        if (ob == btnExit) {
            System.exit(0);
        }
    }
}

public class Ex1 {

    public static void main(String[] args) {
        MyFrame1 mf = new MyFrame1();
        mf.show();
    }
}
