import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;

class MyFrame4 extends JFrame {

    public MyFrame4() {
        setTitle("Ex4");
        setBounds(300, 200, 300, 200);
        Container contentPane = getContentPane();
        MyPanel4 mp = new MyPanel4();
        contentPane.add(mp);
    }
}

class MyPanel4 extends JPanel implements ActionListener {

    JLabel lblRollNumber, lblName, lblPercent;
    JTextField tfRollNumber, tfName, tfPercent;
    JButton btnShow, btnExit;
    Connection cn;
    Statement st;
    ResultSet rs;

    public MyPanel4() {
        setLayout(new GridLayout(4, 2));
        add(lblRollNumber = new JLabel("Roll Number"));
        add(tfRollNumber = new JTextField(10));
        add(lblName = new JLabel("Name"));
        add(tfName = new JTextField(10));
        add(lblPercent = new JLabel("Percentage"));
        add(tfPercent = new JTextField(10));
        add(btnExit = new JButton("Exit"));
        add(btnShow = new JButton("Show"));
        btnShow.addActionListener(this);
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
        if (ob == btnShow) {
            try {
                rollNumber = tfRollNumber.getText();
                query = "SELECT * FROM student WHERE s_roll_number = '" + rollNumber + "'";
                rs = st.executeQuery(query);
                if (rs.next()) {
                    tfName.setText(rs.getString(2));
                    tfPercent.setText(rs.getString(3));
                } else {
                    JOptionPane.showMessageDialog(null, "Record not found.");
                    tfRollNumber.setText("");
                    tfName.setText("");
                    tfPercent.setText("");
                }
            } catch (Exception ex) {
                System.out.println("Exception from btnDelete event handling " + ex);
            }
        }
        if (ob == btnExit) {
            System.exit(0);
        }
    }
}

public class Ex4 {

    public static void main(String[] args) {
        MyFrame4 mf = new MyFrame4();
        mf.show();
    }
}
