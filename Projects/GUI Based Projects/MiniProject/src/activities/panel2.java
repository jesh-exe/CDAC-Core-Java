package activities;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class panel2 {
	JPanel p;
	JLabel l2,l3;
	JTextField temail;
	JButton submit;
	public JPanel panel2() {
		 p=new JPanel();
		p.setLayout(new GridLayout(4,1));
		 l2=new JLabel();
		l2.setFont(new Font("Ubuntu", Font.PLAIN, 30));
		 temail = new JTextField();
		l2.setText("Enter The ID of Student you Want to Delete!");
		l2.setHorizontalAlignment(JLabel.CENTER);
		l3=new JLabel();
		l3.setFont(new Font("Ubuntu", Font.PLAIN, 30));
		l3.setHorizontalAlignment(JLabel.CENTER);
        temail.setFont(new Font("Ubuntu", Font.PLAIN, 30));
        temail.setHorizontalAlignment(JLabel.CENTER);
        temail.setSize(50, 30);
        temail.setBackground(new Color(5, 250, 243));
        p.setBackground(new Color(5, 250, 243));
         submit = new JButton("DELETE");
        submit.setFont(new Font("Ubuntu", Font.PLAIN, 25));
        submit.setSize(170, 35);
        submit.setBackground(new Color(255, 51, 0));
        submit.setFocusable(false);
        submit.setForeground(Color.WHITE);
        l3.setText("");
        submit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 Connection con;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
					Statement st=con.createStatement();
					String p=temail.getText();
					st.executeUpdate("delete from students where id="+p);
//					ResultSet rs=st.executeQuery("select name from students where id="+p);
//					rs.next();
					
					l3.setText("DELETED SUCCESFULLY");
					Statement st1=con.createStatement();
					st1.execute("ALTER TABLE students AUTO_INCREMENT=1");
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	       
					
        	}
        });
        p.add(l2);
        p.add(temail);
        p.add(submit);
        p.add(l3);
        
		return p;
	}
}
