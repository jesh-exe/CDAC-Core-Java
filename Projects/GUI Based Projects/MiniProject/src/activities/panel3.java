package activities;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class panel3 {
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
		l2.setText("Enter the Name of Student you want to Search");
		l2.setHorizontalAlignment(JLabel.CENTER);
		l3=new JLabel();
		l3.setFont(new Font("Ubuntu", Font.PLAIN, 25));
		l3.setHorizontalAlignment(JLabel.CENTER);
        temail.setFont(new Font("Ubuntu", Font.PLAIN, 30));
        temail.setHorizontalAlignment(JLabel.CENTER);
        temail.setSize(50, 30);
        temail.setBackground(new Color(5, 250, 243));
        p.setBackground(new Color(5, 250, 243));
         submit = new JButton("SEARCH");
        submit.setFont(new Font("Ubuntu", Font.PLAIN, 25));
        submit.setSize(170, 35);
        submit.setBackground(new Color(66, 245, 161));
        submit.setFocusable(false);
        submit.setForeground(Color.BLACK);
        submit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 Connection con;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
					Statement st=con.createStatement();
					String p=temail.getText();
					PreparedStatement pst=con.prepareStatement("select * from students where name=?");
					pst.setString(1,p);
					ResultSet rs=pst.executeQuery();
					rs.next();
					
					l3.setText("ID= "+rs.getInt(1)+"      "+"Name= "+rs.getString(2)+"      "+"Course= "+rs.getString(3)+"      "+"Phone= "+rs.getString(4)+"      "+"Fees= "+rs.getInt(5)+"      "+"Email= "+rs.getString(6));
					con.close();
				} catch (SQLException e1) {
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
