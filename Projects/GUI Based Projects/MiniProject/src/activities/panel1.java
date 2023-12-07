package activities;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class panel1 {

	
	public JPanel panel() throws Exception {
		JPanel p6=new JPanel();
        p6.setLayout(new BorderLayout());
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
        Statement st=con.createStatement();
        String column[]={"ID","NAME","COURSE","PHONE","FEES","EMAIL"};
        ResultSet rs23=st.executeQuery("select count(*) from students");
        rs23.next();

        int n = rs23.getInt("count(*)") ;
        if(n==0)
        {
        	Statement st1=con.createStatement();
        	st1.execute("alter table students auto_increment = 0");
        }
        
        
        String[][] row=new String[rs23.getInt("count(*)")][6];
        ResultSet rs=st.executeQuery("select * from students");
        
        int i=0;
        while(rs.next()) {
        	String temp[]= {rs.getInt(1)+"",rs.getString(2),rs.getString(3),rs.getString(4)+"",rs.getInt(5)+"",rs.getString(6)};
        	row[i]=temp;
        	i++;
        }
        JTable jt=new JTable(row,column);   
        
        jt.setFont(new Font("Ubuntu", Font.PLAIN, 13));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)jt.getDefaultRenderer(Object.class);
        renderer.setHorizontalAlignment( SwingConstants.CENTER );
        
        
        jt.setBackground(new Color(5, 250, 243));
        JScrollPane sp=new JScrollPane(jt);    
        p6.setBackground(new Color(5, 250, 243));
        p6.add(sp);
        con.close();
        return p6;
	}
}
