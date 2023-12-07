package activities;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class form extends JFrame{
    JFrame f;    
    private Container c;
    /**
     * @throws Exception
     */
    form() throws Exception {
    	
        JLabel title = new JLabel("Registration Form");
        title.setFont(new Font("Ubuntu", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(200, 30);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Ubuntu", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);

        JTextField tname = new JTextField();
        tname.setFont(new Font("Ubuntu", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(200, 100);

        JLabel mno = new JLabel("Mobile");
        mno.setFont(new Font("Ubuntu", Font.PLAIN, 20));
        mno.setSize(100, 20);
        mno.setLocation(100, 150);

        JTextField tmno = new JTextField();
        tmno.setFont(new Font("Ubuntu", Font.PLAIN, 15));
        tmno.setSize(150, 20);
        tmno.setLocation(200, 150);

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Ubuntu", Font.PLAIN, 20));
        gender.setSize(100, 20);
        gender.setLocation(100, 200);

        JRadioButton male = new JRadioButton("Male");
        male.setFont(new Font("Ubuntu", Font.PLAIN, 15));
        male.setSelected(false);
        male.setSize(75, 20);
        male.setLocation(200, 200);
        male.setBackground(new Color(248,250,165));

        JRadioButton female = new JRadioButton("Female");
        female.setFont(new Font("Ubuntu", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(275, 200);
        female.setBackground(new Color(248,250,165));

        ButtonGroup gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);

        JLabel course = new JLabel("Courses");
        course.setFont(new Font("Ubuntu", Font.PLAIN, 20));
        course.setSize(100, 20);
        course.setLocation(100, 250);

        JRadioButton cc = new JRadioButton("C");
        cc.setFont(new Font("Ubuntu", Font.PLAIN, 15));
        cc.setSelected(false);
        cc.setActionCommand("C");
        cc.setSize(50, 20);
        cc.setLocation(200, 250);
        cc.setBackground(new Color(248,250,165));

        JRadioButton cpp = new JRadioButton("CPP");
        cpp.setFont(new Font("Ubuntu", Font.PLAIN, 15));
        cpp.setSelected(false);
        cpp.setActionCommand("CPP");
        cpp.setSize(75, 20);
        cpp.setLocation(250, 250);
        cpp.setBackground(new Color(248,250,165));

        JRadioButton java = new JRadioButton("Java");
        java.setFont(new Font("Ubuntu", Font.PLAIN, 15));
        java.setSelected(false);
        java.setActionCommand("JAVA");
        java.setSize(75, 20);
        java.setLocation(325, 250);
        java.setBackground(new Color(248,250,165));
        
        JRadioButton python = new JRadioButton("Python");
        python.setFont(new Font("Ubuntu", Font.PLAIN, 15));
        python.setSelected(false);
        python.setActionCommand("PYTHON");
        python.setSize(75, 20);
        python.setLocation(410, 250);
        python.setBackground(new Color(248,250,165));

        ButtonGroup cors = new ButtonGroup();
        cors.add(cc);
        cors.add(cpp);
        cors.add(java);
        cors.add(python);

         JLabel email = new JLabel("Email");
        email.setFont(new Font("Ubuntu", Font.PLAIN, 20));
        email.setSize(100, 20);
        email.setLocation(100, 300);
        
        JTextField temail = new JTextField();
        temail.setFont(new Font("Ubuntu", Font.PLAIN, 15));
        temail.setSize(190, 20);
        temail.setLocation(200, 300);
        
        JLabel pf = new JLabel("Paid Fees");
        pf.setFont(new Font("Ubuntu", Font.PLAIN, 20));
        pf.setSize(100, 20);
        pf.setLocation(100, 350);
        
        JTextField pft = new JTextField();
        pft.setFont(new Font("Ubuntu", Font.PLAIN, 15));
        pft.setSize(190, 20);
        pft.setLocation(200, 350);
        
//        JLabel bpf = new JLabel("Balance Fees");
//        bpf.setFont(new Font("Ubuntu", Font.PLAIN, 20));
//        bpf.setSize(100, 20);
//        bpf.setLocation(100,400);
//        
//        JTextField bpft = new JTextField();
//        bpft.setFont(new Font("Ubuntu", Font.PLAIN, 15));
//        bpft.setSize(190, 20);
//        bpft.setLocation(200, 400);
        
        JButton submit = new JButton("Submit");
        submit.setFont(new Font("Ubuntu", Font.PLAIN, 15));
        submit.setSize(170, 35);
        submit.setLocation(200, 400);
        submit.setBackground(Color.GREEN);
        submit.setFocusable(false);
        submit.setForeground(Color.WHITE); 
        submit.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");  
			    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
			    	Statement stm=con.createStatement();
        		PreparedStatement psm=con.prepareStatement("insert into students(name,cource,phone,fees,email) values(?,?,?,?,?)");
        		String name=tname.getText();
//        		psm.setInt(1,1);
        		psm.setString(1, name);
        		String n=tmno.getText();
        		psm.setString(3, n);
        
        		String cource=cors.getSelection().getActionCommand();
        		psm.setString(2, cource);
        		String mail=temail.getText();
        		psm.setString(5, mail);

        		int p=Integer.parseInt(pft.getText());
        		psm.setInt(4, p);
        		int i=psm.executeUpdate();
        		con.close();
        		JOptionPane.showMessageDialog(submit,i+" Data Added!");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
        	}
        });
        setVisible(true);
        setTitle("Registration Form");
        setBounds(300, 90, 100, 500);
        setBackground(Color.yellow);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        
        

        c = getContentPane();
        c.setLayout(null);
        c.add(title);
        c.add(name);
        c.add(tname);
        c.add(mno);
        c.add(tmno);
        c.add(gender);
        c.add(male);
        c.add(female);
        c.add(course);
        c.add(cc);
        c.add(cpp);
        c.add(java);
        c.add(python);
        c.add(email);
        c.add(temail);
        
        c.add(pf);
        c.add(pft);
        
//        c.add(bpf);
//        c.add(bpft);
        
        c.add(submit);
        c.setBackground(new Color(248,250,165));
        setBounds(500,160,600,500);    
        setVisible(true);  
        
    } 
}
