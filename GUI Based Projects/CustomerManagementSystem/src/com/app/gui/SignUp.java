package com.app.gui;

import static com.app.utils.AuthenticateSignUp.*;
import static com.app.utils.AuthenticateLogin.checkCreds;
import static com.app.utils.AuthenticateLogin.matchCreds;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.app.customExceptions.LoginExceptions;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.RadialGradientPaint;

import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {

	public JPanel contentPane;
	private JTextField nameField;
	private JTextField emailField;
	private JTextField passwordField;
	private JTextField amountField;
	private JTextField dobField;
	private JTextField cityTextField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 717);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(-20, 0, 777, 66);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Sign Up Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel.setBounds(281, 12, 253, 46);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(SystemColor.text);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(-10, 60, 778, 641);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		nameField = new JTextField();
		nameField.setHorizontalAlignment(SwingConstants.LEFT);
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nameField.setBounds(375, 91, 265, 25);
		panel_1.add(nameField);
		nameField.setColumns(10);

		JLabel firstNameTitle = new JLabel("Full Name");
		firstNameTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		firstNameTitle.setForeground(Color.WHITE);
		firstNameTitle.setBackground(SystemColor.text);
		firstNameTitle.setBounds(129, 92, 96, 25);
		panel_1.add(firstNameTitle);

		JLabel emailIDFTitle = new JLabel("Email ID");
		emailIDFTitle.setForeground(Color.WHITE);
		emailIDFTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		emailIDFTitle.setBackground(Color.WHITE);
		emailIDFTitle.setBounds(129, 152, 96, 25);
		panel_1.add(emailIDFTitle);

		emailField = new JTextField();
		emailField.setHorizontalAlignment(SwingConstants.LEFT);
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		emailField.setColumns(10);
		emailField.setBounds(375, 151, 265, 25);
		panel_1.add(emailField);

		JLabel passwordTitle = new JLabel("Password");
		passwordTitle.setForeground(Color.WHITE);
		passwordTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordTitle.setBackground(Color.WHITE);
		passwordTitle.setBounds(129, 211, 96, 25);
		panel_1.add(passwordTitle);

		passwordField = new JTextField();
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setColumns(10);
		passwordField.setBounds(375, 210, 265, 25);
		panel_1.add(passwordField);

		JLabel amountTitle = new JLabel("Registration Amount");
		amountTitle.setForeground(Color.WHITE);
		amountTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		amountTitle.setBackground(Color.WHITE);
		amountTitle.setBounds(129, 332, 188, 25);
		panel_1.add(amountTitle);

		amountField = new JTextField();
		amountField.setHorizontalAlignment(SwingConstants.LEFT);
		amountField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		amountField.setColumns(10);
		amountField.setBounds(378, 331, 265, 25);
		panel_1.add(amountField);

		JLabel dobTitle = new JLabel("DOB (YYYY-MM-DD)");
		dobTitle.setForeground(Color.WHITE);
		dobTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dobTitle.setBackground(Color.WHITE);
		dobTitle.setBounds(129, 391, 188, 25);
		panel_1.add(dobTitle);

		dobField = new JTextField();
		dobField.setHorizontalAlignment(SwingConstants.LEFT);
		dobField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dobField.setColumns(10);
		dobField.setBounds(378, 390, 265, 25);
		panel_1.add(dobField);

		ButtonGroup radioGroup = new ButtonGroup();

		JRadioButton radioSilver = new JRadioButton("SILVER");
		radioSilver.setForeground(new Color(255, 255, 255));
		radioSilver.setBackground(new Color(0, 0, 0));
		radioSilver.setBounds(222, 469, 73, 23);
		panel_1.add(radioSilver);

		JRadioButton radioGold = new JRadioButton("GOLD");
		radioGold.setForeground(Color.WHITE);
		radioGold.setBackground(Color.BLACK);
		radioGold.setBounds(330, 469, 73, 23);
		panel_1.add(radioGold);

		JRadioButton radioDiamond = new JRadioButton("DIAMOND");
		radioDiamond.setForeground(Color.WHITE);
		radioDiamond.setBackground(Color.BLACK);
		radioDiamond.setBounds(427, 469, 96, 23);
		panel_1.add(radioDiamond);

		JRadioButton radioPlatinum = new JRadioButton("PLATINUM");
		radioPlatinum.setForeground(Color.WHITE);
		radioPlatinum.setBackground(Color.BLACK);
		radioPlatinum.setBounds(545, 469, 98, 23);
		panel_1.add(radioPlatinum);

		radioGroup.add(radioSilver);
		radioGroup.add(radioGold);
		radioGroup.add(radioDiamond);
		radioGroup.add(radioPlatinum);

		JLabel planTitle = new JLabel("Plan");
		planTitle.setForeground(Color.WHITE);
		planTitle.setFont(new Font("Dialog", Font.PLAIN, 18));
		planTitle.setBackground(Color.WHITE);
		planTitle.setBounds(129, 467, 55, 25);
		panel_1.add(planTitle);

		JLabel silverPrice = new JLabel("1000/-");
		silverPrice.setForeground(Color.WHITE);
		silverPrice.setFont(new Font("Dialog", Font.PLAIN, 11));
		silverPrice.setBackground(Color.WHITE);
		silverPrice.setBounds(251, 486, 42, 25);
		panel_1.add(silverPrice);

		JLabel goldPrice = new JLabel("2000/-");
		goldPrice.setForeground(Color.WHITE);
		goldPrice.setFont(new Font("Dialog", Font.PLAIN, 11));
		goldPrice.setBackground(Color.WHITE);
		goldPrice.setBounds(353, 486, 42, 25);
		panel_1.add(goldPrice);

		JLabel diamondPrice = new JLabel("5000/-");
		diamondPrice.setForeground(Color.WHITE);
		diamondPrice.setFont(new Font("Dialog", Font.PLAIN, 11));
		diamondPrice.setBackground(Color.WHITE);
		diamondPrice.setBounds(464, 486, 42, 25);
		panel_1.add(diamondPrice);

		JLabel platinumPrice = new JLabel("10000/-");
		platinumPrice.setForeground(Color.WHITE);
		platinumPrice.setFont(new Font("Dialog", Font.PLAIN, 11));
		platinumPrice.setBackground(Color.WHITE);
		platinumPrice.setBounds(580, 486, 63, 25);
		panel_1.add(platinumPrice);

		JLabel cityTitle = new JLabel("City");
		cityTitle.setForeground(Color.WHITE);
		cityTitle.setFont(new Font("Dialog", Font.PLAIN, 18));
		cityTitle.setBackground(Color.WHITE);
		cityTitle.setBounds(129, 271, 96, 25);
		panel_1.add(cityTitle);

		cityTextField = new JTextField();
		cityTextField.setHorizontalAlignment(SwingConstants.LEFT);
		cityTextField.setFont(new Font("Dialog", Font.PLAIN, 18));
		cityTextField.setColumns(10);
		cityTextField.setBounds(378, 270, 265, 25);
		panel_1.add(cityTextField);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String plan = radioDiamond.isSelected() ? "DIAMOND" : radioGold.isSelected() ? "GOLD" : radioPlatinum.isSelected() ? "PLATINUM" : radioSilver.isSelected() ? "SILVER" : "";
				try {
					checkCreds(emailField.getText(), passwordField.getText());
					if(checkSignUpCreds(nameField.getText(), emailField.getText(), passwordField.getText(),
							cityTextField.getText(), amountField.getText(), dobField.getText(), plan))
					{
						dispose();
						Login login = new Login();
						login.setVisible(true);
					}
					
				} catch (LoginExceptions errMsg) {
					JOptionPane.showMessageDialog(null, errMsg.getMessage(),"",JOptionPane.ERROR_MESSAGE);
				}
					
				}
		});
		btnSubmit.setFont(new Font("Dialog", Font.BOLD, 14));
		btnSubmit.setBounds(326, 551, 117, 25);
		panel_1.add(btnSubmit);
	}
}
