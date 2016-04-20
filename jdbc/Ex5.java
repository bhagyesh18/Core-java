import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;

class MyFrame5 extends JFrame {

    public MyFrame5() {
        setTitle("Ex5");
        setBounds(300, 200, 300, 300);
        Container contentPane = getContentPane();
        MyPanel5 mp = new MyPanel5();
        contentPane.add(mp);
    }
}

class MyPanel5 extends JPanel implements ActionListener {

    JLabel lblRollNumber, lblName, lblPercent;
    JTextField tfRollNumber, tfName, tfPercent;
    JButton btnInsert, btnUpdate, btnDelete, btnShow, btnExit, btnClear;
    Connection cn;
    Statement st;
    ResultSet rs;

    public MyPanel5() {
        setLayout(new GridLayout(6, 2));
        add(lblRollNumber = new JLabel("       Roll Number"));
        add(tfRollNumber = new JTextField(10));
        add(lblName = new JLabel("       Name"));
        add(tfName = new JTextField(10));
        add(lblPercent = new JLabel("       Percentage"));
        add(tfPercent = new JTextField(10));
        add(btnUpdate = new JButton("Update"));
        add(btnInsert = new JButton("Insert"));
        add(btnDelete = new JButton("Delete"));
        add(btnShow = new JButton("Show"));
        add(btnClear = new JButton("Clear"));
        add(btnExit = new JButton("Exit"));
        btnInsert.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnShow.addActionListener(this);
        btnExit.addActionListener(this);
        btnClear.addActionListener(this);
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");//Load the JDBC-ODBC bridge driver
            cn = DriverManager.getConnection("jdbc:odbc:studentDSN");//Connection to database is done
            st = cn.createStatement();
        } catch (Exception e) {
            System.out.println("Exception from MyPanel1 constructor " + e);
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
                System.out.println("Exception from btnInsert event handling " + ex);
            }
        }
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
                System.out.println("Exception from btnUpdate event handling " + ex);
            }
        }
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
        if(ob == btnClear){
            tfRollNumber.setText("");
            tfName.setText("");
            tfPercent.setText("");
        }
        if (ob == btnExit) {
            System.exit(0);
        }
    }
}

public class Ex5 {

    public static void main(String[] args) {
        MyFrame5 mf = new MyFrame5();
        mf.show();
    }
}
