package com.app.gui;

import static com.app.utils.AuthenticateLogin.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import static com.app.tester.Tester.*;
import javax.swing.border.SoftBevelBorder;

import com.app.customExceptions.LoginExceptions;

import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	public JPanel contentPane;
	private JTextField loginTextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 837, 718);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainFrameUpperPanel = new JPanel();
		mainFrameUpperPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		mainFrameUpperPanel.setBackground(new Color(188, 143, 143));
		mainFrameUpperPanel.setBounds(0, 12, 867, 132);
		contentPane.add(mainFrameUpperPanel);
		mainFrameUpperPanel.setLayout(null);
		
		JLabel mainTitle = new JLabel("Customer Management System");
		mainTitle.setFont(new Font("Ubuntu", Font.BOLD, 45));
		mainTitle.setBounds(87, 28, 671, 73);
		mainFrameUpperPanel.add(mainTitle);
		
		JPanel mainFrameLowerPanel = new JPanel();
		mainFrameLowerPanel.setBackground(new Color(220, 220, 220));
		mainFrameLowerPanel.setBounds(-19, 141, 842, 559);
		contentPane.add(mainFrameLowerPanel);
		mainFrameLowerPanel.setLayout(null);
		
		loginTextField = new JTextField();
		loginTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		loginTextField.setBounds(327, 156, 272, 43);
		mainFrameLowerPanel.add(loginTextField);
		loginTextField.setColumns(10);
		
		JLabel Login_Label = new JLabel("Login");
		Login_Label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Login_Label.setBounds(224, 154, 74, 43);
		mainFrameLowerPanel.add(Login_Label);
		
		JLabel Password_Label = new JLabel("Password");
		Password_Label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Password_Label.setBounds(209, 237, 117, 43);
		mainFrameLowerPanel.add(Password_Label);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(327, 239, 272, 43);
		mainFrameLowerPanel.add(passwordField);
		
		
		JButton btnNewButton = new JButton("Login");							//Login Button Action Listener
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = loginTextField.getText();
				String pass = String.copyValueOf(passwordField.getPassword());
				try {
					
					checkCreds(login, pass);
					matchCreds(login, pass);
				
					dispose();
					Dashboard db = new Dashboard();
					db.setVisible(true);
				}catch (LoginExceptions e1) {
					
					JOptionPane.showMessageDialog(null,e1.getMessage(),"",JOptionPane.ERROR_MESSAGE);
				}
				catch (Exception e2) {
				}
				
				}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(327, 328, 110, 37);
		mainFrameLowerPanel.add(btnNewButton);
		
		JButton signUpButton = new JButton("Sign Up");							//Sign Up Button Action Listener
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SignUp signUpWindow = new SignUp();
				signUpWindow.setVisible(true);

			}
		});
		signUpButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		signUpButton.setBounds(463, 328, 136, 37);
		mainFrameLowerPanel.add(signUpButton);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Dialog", Font.BOLD, 32));
		lblWelcome.setBounds(362, 45, 151, 69);
		mainFrameLowerPanel.add(lblWelcome);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\College\\Java\\WorkSpace\\Prototype\\loginImage (2).png"));
		lblNewLabel.setBounds(150, 156, 49, 43);
		mainFrameLowerPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\College\\Java\\WorkSpace\\Prototype\\loginImage (2).png"));
		lblNewLabel_1.setBounds(150, 237, 49, 43);
		mainFrameLowerPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Designed & Developed by Jayesh Murodiya");
		lblNewLabel_2.setBounds(343, 516, 207, 13);
		mainFrameLowerPanel.add(lblNewLabel_2);
	}
}
