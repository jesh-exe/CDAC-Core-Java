package activities;

import java.awt.*;
import java.io.*;
import java.sql.*;

import javax.swing.*;

import com.mysql.cj.protocol.Resultset;

import java.awt.event.*;

public class homeFrame extends JFrame implements ActionListener {
	JMenuItem m1, m2, m3, m4;
	JPanel p1, p2, p3, p4, p5, p6, p7, p8;
	JPanel pa1;
	JButton b1, b2, b3, b4, b5;
	JTextArea jta1, jta2;
	ImageIcon i1,i2;
	JLabel l1, l2, l3, l4, l5, l6, l7,l8;
	CardLayout c1 = new CardLayout();

	public homeFrame() throws Exception {
//		this.setAlwaysOnTop(true);
		Toolkit tk = Toolkit.getDefaultToolkit();
		int xsize = (int) tk.getScreenSize().getWidth();
		int ysize = (int) tk.getScreenSize().getHeight();
		Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		int taskBarSize = scnMax.bottom;
		this.setSize(xsize,ysize);
		
		this.setLayout(new BorderLayout());
//		this.setBounds(200, 200, 1800, 1000);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		i1 = new ImageIcon("AK3.png");
		this.setIconImage(i1.getImage());
		JMenuBar menu = new JMenuBar();
        
		m1 = new JMenuItem("                                             HOME");
		m2 = new JMenuItem("                                      COURSE");
		m3 = new JMenuItem("                               SERVICES");
		m4 = new JMenuItem("                                      TEST");
		m1.setBounds(20,20,10, 4); 
		menu.add(m1);
		menu.add(m2);
		menu.add(m3);
		menu.add(m4);
		
		
		  menu.setBackground(new Color(155, 242, 138)); m1.setBackground(new Color(155, 242, 138)); m2.setBackground(new Color(155, 242, 138)); m3.setBackground(new
		  Color(155, 242, 138)); m4.setBackground(new Color(155, 242, 138));
		 
		 
		menu.setFocusable(false);
		menu.setPreferredSize(new Dimension(100, 60));
		
		m1.setFont(new Font("Ubuntu", Font.BOLD, 18));
		m2.setFont(new Font("Ubuntu", Font.BOLD, 18));
		m3.setFont(new Font("Ubuntu", Font.BOLD, 18));
		m4.setFont(new Font("Ubuntu", Font.BOLD, 18));
		this.setJMenuBar(menu);
		p4 = new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel l1 = new JLabel("RGCER Developers");
		this.setFont(new Font("Ubuntu", Font.BOLD, 14));
		p4.add(l1);
		p4.setBackground(new Color(155, 242, 138));
		p4.setPreferredSize(new Dimension(100, 50));
		this.add(p4, BorderLayout.SOUTH);
		p1 = new JPanel();
		p1.setLayout(new GridLayout(5,1,80,5));
		p1.setBackground(new Color(50, 137, 168));
		b1=new JButton("Add Student");
		b2 = new JButton("Remove Student");
		b3 = new JButton("Show Student");
		b4 = new JButton("Show all Students");
		b5 = new JButton("Level Test");
		
		
		  b1.setBackground(new Color(199, 240, 122)); b2.setBackground(new Color(191, 168, 128)); b3.setBackground(new Color(199, 240, 122)); b4.setBackground(new
		  Color(191, 168, 128)); b5.setBackground(new Color(199, 240, 122));
		 
		b1.setFocusable(false);
		b2.setFocusable(false);
		b3.setFocusable(false);
		b4.setFocusable(false);
		b5.setFocusable(false);

		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);
		p1.setPreferredSize(new Dimension(130, 50));
		p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		jta1 = new JTextArea();

		FileReader fw = new FileReader("D:\\Files\\prodata.txt");
		BufferedReader br = new BufferedReader(fw);
		String line;
		int i=0;
		while (i==0) {
			line = br.readLine();
			if(line==null)
				break;
			jta1.setText(jta1.getText() + "\n" + line);
		}

		JScrollPane scrollableTextArea = new JScrollPane(jta1);
		scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
//	    p2.add(jta1);
//	    this.add(jta1);
		jta1.setBackground(new Color(186, 255, 253));
		jta1.setForeground(Color.black);

		p2.setBackground(new Color(186, 255, 253));
//	    jta1.setPreferredSize(new Dimension(100,100));
		p2.setPreferredSize(new Dimension(100, 100));
		p2.setAlignmentX(RIGHT_ALIGNMENT);
		p2.add(scrollableTextArea);
		this.setFont(new Font("Ubuntu Rounded MT Bold", Font.BOLD, 20));
		jta1.setFont(new Font("Ubuntu Rounded MT Bold", Font.BOLD, 20));
		p3 = new JPanel();
		p3.setLayout(new GridLayout(2, 2));
		p3.setFont(new Font("Ubuntu Rounded MT Bold", Font.BOLD, 20));
		p3.setPreferredSize(new Dimension(100, 100));
		p3.setBackground(new Color(186, 255, 253));

		l1 = new JLabel();
		ImageIcon image = new ImageIcon("java.png");
		Image image1 = image.getImage(); // transform it
		Image newimg = image1.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		image = new ImageIcon(newimg); // transform it back
		l1.setIcon(image);
		l1.setText("<html><body>JAVA<br>Price = 18000/-<br>Core + Advance<br>Duration=3 month<br>Teacher=DEEPAK SIR<body><html>");
		l1.setHorizontalTextPosition(JLabel.CENTER);
		l1.setVerticalTextPosition(JLabel.BOTTOM);
		l1.setHorizontalAlignment(JLabel.CENTER);
		p3.add(l1);
		l2 = new JLabel();
		ImageIcon image2 = new ImageIcon("python2.png");
		Image imagee = image2.getImage(); 
		Image newimge = imagee.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH); 
		image2 = new ImageIcon(newimge); 
		l2.setIcon(image2);
		l2.setText("<html><body>PYTHON<br>Price = 21000/-<br>Core+Advance<br>Duration=2.5 month<br>Teacher=ADITYA SIR<body><html>");
		l2.setHorizontalTextPosition(JLabel.CENTER);
		l2.setVerticalTextPosition(JLabel.BOTTOM);
		l2.setHorizontalAlignment(JLabel.CENTER);
		p3.add(l2);
		l3 = new JLabel();
		ImageIcon image3 = new ImageIcon("cpp.png");
		Image imageee = image3.getImage(); 
		Image newimgee = imageee.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		image3 = new ImageIcon(newimgee); // transform it back
		l3.setIcon(image3);
		l3.setText("<html><body>C++<br>Price = 5000/-<br>BASIC+STL<br>Duration=2 month<br>Teacher=MANGESH SIR<body><html>");
		l3.setHorizontalTextPosition(JLabel.CENTER);
		l3.setVerticalTextPosition(JLabel.BOTTOM);
		l3.setHorizontalAlignment(JLabel.CENTER);
		p3.add(l3);
		l4 = new JLabel();
		ImageIcon image4 = new ImageIcon("c.png");
		Image imageeee = image4.getImage(); // transform it
		Image newimgeee = imageeee.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		image4 = new ImageIcon(newimgeee); // transform it back
		l4.setIcon(image4);
		l4.setText("<html><body>C<br>Price = 3000/-<br>FULL COURCE<br>Duration=2 month<br>Teacher=OMKAR SIR<body><html>");
		l4.setHorizontalTextPosition(JLabel.CENTER);
		l4.setVerticalTextPosition(JLabel.BOTTOM);
		l4.setHorizontalAlignment(JLabel.CENTER);
		p3.add(l4);

		p5 = new JPanel();
		p5.setLayout(new BorderLayout());
		p5.setFont(new Font("Ubuntu Rounded MT Bold", Font.BOLD, 25));
		p5.setSize(1000, 1000);
		p5.setPreferredSize(new Dimension(100, 100));
		p5.setBackground(new Color(186, 255, 253));
		l5 = new JLabel();
		ImageIcon image5 = new ImageIcon("one_on_one.png");
		Image imageeeee = image5.getImage(); // transform it
		Image newimgeeee = imageeeee.getScaledInstance(220, 220, java.awt.Image.SCALE_SMOOTH); // scale it the smooth
																								// way
		image5 = new ImageIcon(newimgeeee); // transform it back
		l5.setIcon(image5);
		l5.setText(
				"<html><body>WE OFFER A FULL TIME ONE TO ONE SUPPORT<br> TO ALL OUR STUDENTS<br>YOU CAN RESOLVE ANY AND ALL TYPES OF DOUBTS<br>FROM YOUR TEACHER. <br>Teacher=ADITYA SIR HE IS VERY RENOUNED AND WELL KNOWN TEACHER<br>SO THERE IS NO NEED TO WORRY JUST RELEY ON HIM<body><html>");
		l5.setHorizontalTextPosition(JLabel.CENTER);
		l5.setVerticalTextPosition(JLabel.BOTTOM);
		l5.setHorizontalAlignment(JLabel.CENTER);

		l6 = new JLabel();
		ImageIcon image6 = new ImageIcon("online_teaching.png");
		Image imageeeeee = image6.getImage(); // transform it
		Image newimgeeeee = imageeeeee.getScaledInstance(220, 220, java.awt.Image.SCALE_SMOOTH); // scale it the smooth
																									// way
		image6 = new ImageIcon(newimgeeeee); // transform it back
		l6.setIcon(image6);
		l6.setText(
				"<html><body>WE OFFER A FULL TIME ONE TO ONE SUPPORT AT ONLINE TOO<br> TO ALL OUR STUDENTS<br>YOU CAN RESOLVE ANY AND ALL ONLINE TYPES OF DOUBTS<br>FROM YOUR TEACHER. <br>Teacher=ADITYA SIR HE IS VERY RENOUNED AND WELL KNOWN TEACHER<br>SO THERE IS NO NEED TO WORRY JUST RELEY ON HIM<body><html>");
		l6.setHorizontalTextPosition(JLabel.CENTER);
		l6.setVerticalTextPosition(JLabel.BOTTOM);
		l6.setHorizontalAlignment(JLabel.CENTER);

		l7 = new JLabel();
		ImageIcon image7 = new ImageIcon("any_Format_support.png");
		Image imageeeeeee = image7.getImage(); // transform it
		Image newimgeeeeee = imageeeeeee.getScaledInstance(220, 220, java.awt.Image.SCALE_SMOOTH); // scale it the
																									// smooth way
		image7 = new ImageIcon(newimgeeeeee); // transform it back
		l7.setIcon(image7);
		l7.setText(
				"<html><body>WE OFFER A FULL TIME ONE TO ONE SUPPORT AT ONLINE TOO<br> TO ALL OUR STUDENTS<br>YOU CAN RESOLVE ANY AND ALL ONLINE TYPES OF DOUBTS<br>FROM YOUR TEACHER. <br>Teacher=DEEPAK SIR HE IS VERY RENOUNED AND WELL KNOWN TEACHER<br>SO THERE IS NO NEED TO WORRY JUST RELEY ON HIM<body><html>");
		l7.setHorizontalTextPosition(JLabel.CENTER);
		l7.setVerticalTextPosition(JLabel.BOTTOM);
		l7.setHorizontalAlignment(JLabel.CENTER);
		jta2 = new JTextArea();
		// p2.add(jta1);this.add(jta1);

		FileReader fw1 = new FileReader("D:\\Files\\waste.txt");
		BufferedReader br1 = new BufferedReader(fw1);
		String line1 = br1.readLine();
		while (line1 != null) {
			line1 = br1.readLine();
			jta2.setText(jta2.getText() + "\n" + line1);
		}

		jta2.setBackground(new Color(186, 255, 253));
		jta2.setForeground(new Color(186, 255, 253));
		jta2.setLayout(new FlowLayout());
		jta2.add(l5);
		jta2.add(l6);
		jta2.add(l7);
		JScrollPane scrollableTextArea1 = new JScrollPane(jta2);
		scrollableTextArea1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollableTextArea1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		p5.add(scrollableTextArea1);
//
		pa1 = new JPanel();
		pa1.setLayout(c1);
		pa1.setPreferredSize(new Dimension(100, 100));
		pa1.add(p2, "first");
		pa1.add(p3, "second");
		pa1.add(p5, "third");
//	    pa1.add(p6, "forth");
		c1.show(pa1, "first");
//	    pa1.add(p3);
//	    pa1.add(p2);
		m2.addActionListener(this);
		m1.addActionListener(this);
		m3.addActionListener(this);
		b1.addActionListener(this);
		b4.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b5.addActionListener(this);

//	    con.close();
		this.add(pa1, BorderLayout.CENTER);
//	    this.add(p2,BorderLayout.CENTER);
//	    p2.setVisible(true);
		this.add(p1, BorderLayout.WEST);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == m2) {
			c1.show(pa1, "second");
		}

		if (e.getSource() == m1) {
			c1.show(pa1, "first");
		}

		if (e.getSource() == m3) {
			c1.show(pa1, "third");
		}
		if (e.getSource() == m4) {
			c1.show(pa1, "nine");
		}

		if (e.getSource() == b2) {
			try {
				p7 = new panel2().panel2();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			pa1.add(p7, "fifth");
			c1.show(pa1, "fifth");

		}
		if (e.getSource() == b4) {
			try {
				p6 = new panel1().panel();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			pa1.add(p6, "forth");
			c1.show(pa1, "forth");
		}
		if (e.getSource() == b3) {
			try {
				p8 = new panel3().panel2();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			pa1.add(p8, "sixth");
			c1.show(pa1, "sixth");
		}

		if (e.getSource() == b1) {
			c1.show(pa1, "first");
			try {
				form f = new form();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (e.getSource() == b5) {
			c1.show(pa1, "nine");
			try {
				tesst tt = new tesst();
			} catch (Exception e1) {

				e1.printStackTrace();
			}
		}
	}
}
