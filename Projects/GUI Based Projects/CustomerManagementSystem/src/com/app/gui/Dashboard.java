package com.app.gui;

import static com.app.utils.UserBasicFunctions.*;
import static com.app.fileio.FileManagement.*;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import static com.app.tester.Tester.*;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.security.auth.login.LoginException;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DropMode;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.app.core.ServicePlan;
import com.app.customExceptions.CustomerCustomExceptions;
import com.app.customExceptions.LoginExceptions;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.CardLayout;
import javax.swing.JPasswordField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JToggleButton;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	private JTextField topUpField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Dashboard() {
		
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1129, 765);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel upperPanelDashboard = new JPanel();
		upperPanelDashboard.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		upperPanelDashboard.setBackground(new Color(112, 128, 144));
		upperPanelDashboard.setBounds(-26, -15, 1178, 110);
		contentPane.add(upperPanelDashboard);
		upperPanelDashboard.setLayout(null);
		
		JLabel mainHeading = new JLabel("Dashboard");
		mainHeading.setFont(new Font("Dialog", Font.BOLD, 45));
		mainHeading.setBounds(454, 20, 279, 58);
		upperPanelDashboard.add(mainHeading);
		
		JLabel greetingText = new JLabel("Welcome, "+loggedInUser.getFirstName());
		greetingText.setForeground(new Color(248, 248, 255));
		greetingText.setFont(new Font("Dialog", Font.BOLD, 15));
		greetingText.setBounds(75, 75, 207, 23);
		upperPanelDashboard.add(greetingText);
		
		JPanel CardLayout = new JPanel();
		CardLayout.setBackground(new Color(255, 255, 255));
		CardLayout.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		CardLayout.setBounds(235, 107, 639, 616);
		contentPane.add(CardLayout);
		CardLayout.setLayout(new CardLayout(0, 0));
		
		JPanel NullCard = new JPanel();
		CardLayout.add(NullCard, "nullCard");
		
		
		JScrollPane scrollPane = new JScrollPane();
		NullCard.add(scrollPane);
		
		JPanel TopUpCard = new JPanel();
		CardLayout.add(TopUpCard, "topUpCard");
		TopUpCard.setLayout(null);
		
		JLabel TopUpWalletLabel = new JLabel("Top Up Wallet");
		TopUpWalletLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		TopUpWalletLabel.setBounds(253, 43, 168, 48);
		TopUpCard.add(TopUpWalletLabel);
		
		topUpField = new JTextField();
		topUpField.setBounds(301, 136, 134, 31);
		TopUpCard.add(topUpField);
		topUpField.setColumns(10);
		
		JLabel AmountLabel = new JLabel("Amount");
		AmountLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		AmountLabel.setBounds(211, 136, 68, 31);
		TopUpCard.add(AmountLabel);
		
		
		JButton topUpButton = new JButton("Top Up");
		topUpButton.setBounds(277, 215, 107, 40);
		TopUpCard.add(topUpButton);
		
		
		JPanel ChangeEmailCard = new JPanel();
		CardLayout.add(ChangeEmailCard, "changeEmailCard");
		
		JPanel ChangePasswordCard = new JPanel();
		CardLayout.add(ChangePasswordCard, "changePasswordCard");
		ChangePasswordCard.setLayout(null);
		
		JLabel lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setFont(new Font("Dialog", Font.BOLD, 20));
		lblChangePassword.setEnabled(true);
		lblChangePassword.setBounds(220, 44, 207, 51);
		ChangePasswordCard.add(lblChangePassword);
		
		JLabel lblCurrentPassword = new JLabel("Current Password");
		lblCurrentPassword.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCurrentPassword.setBounds(76, 155, 164, 33);
		ChangePasswordCard.add(lblCurrentPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(295, 155, 227, 33);
		ChangePasswordCard.add(passwordField);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewPassword.setBounds(76, 225, 164, 33);
		ChangePasswordCard.add(lblNewPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(295, 225, 227, 33);
		ChangePasswordCard.add(passwordField_1);
		
		JLabel lblReenterNewPassword = new JLabel("ReType New Password");
		lblReenterNewPassword.setFont(new Font("Dialog", Font.BOLD, 15));
		lblReenterNewPassword.setBounds(76, 291, 201, 33);
		ChangePasswordCard.add(lblReenterNewPassword);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(295, 291, 227, 33);
		ChangePasswordCard.add(passwordField_2);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setBounds(242, 403, 164, 45);
		ChangePasswordCard.add(btnChangePassword);
		
		
		JPanel ChangePlanCard = new JPanel();
		CardLayout.add(ChangePlanCard, "changePlanCard");
		ChangePlanCard.setLayout(null);
		
		
		JLabel changePlanHeading = new JLabel("Change Plan");
		changePlanHeading.setFont(new Font("Dialog", Font.BOLD, 21));
		changePlanHeading.setBounds(240, 48, 170, 44);
		ChangePlanCard.add(changePlanHeading);
		
		ButtonGroup radioGroup = new ButtonGroup();

		JRadioButton radioSilver = new JRadioButton("Silver");
		radioSilver.setFont(new Font("Dialog", Font.BOLD, 14));
		radioSilver.setBounds(125, 159, 76, 23);
		ChangePlanCard.add(radioSilver);
		radioGroup.add(radioSilver);
		
		
		JRadioButton radioGold = new JRadioButton("Gold");
		radioGold.setFont(new Font("Dialog", Font.BOLD, 14));
		radioGold.setBounds(125, 213, 67, 23);
		ChangePlanCard.add(radioGold);
		radioGroup.add(radioGold);
		
		
		JRadioButton radioDiamond = new JRadioButton("Diamond");
		radioDiamond.setFont(new Font("Dialog", Font.BOLD, 14));
		radioDiamond.setBounds(125, 267, 96, 23);
		ChangePlanCard.add(radioDiamond);
		radioGroup.add(radioDiamond);
		
		
		JRadioButton radioPlatinum = new JRadioButton("Platinum");
		radioPlatinum.setFont(new Font("Dialog", Font.BOLD, 14));
		radioPlatinum.setBounds(125, 322, 96, 23);
		ChangePlanCard.add(radioPlatinum);
		radioGroup.add(radioPlatinum);
		
		
		JButton changePlanSubmitBtn = new JButton("Submit");
		changePlanSubmitBtn.setBounds(254, 403, 117, 44);
		ChangePlanCard.add(changePlanSubmitBtn);
		
		
		JPanel leftPanelDashboard = new JPanel();
		leftPanelDashboard.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		leftPanelDashboard.setBounds(12, 107, 211, 616);
		contentPane.add(leftPanelDashboard);
		leftPanelDashboard.setLayout(null);
		
		CardLayout cardlayout = (CardLayout)CardLayout.getLayout();
		
		JPanel ShowProfile = new JPanel();
		CardLayout.add(ShowProfile, "showProfile");
		ShowProfile.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Profile");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 26));
		lblNewLabel.setBounds(257, 22, 97, 35);
		ShowProfile.add(lblNewLabel);
		
		JLabel profileName = new JLabel("Name");
		profileName.setFont(new Font("Dialog", Font.PLAIN, 16));
		profileName.setBounds(116, 100, 50, 23);
		ShowProfile.add(profileName);
		
		JLabel profileNameField = new JLabel("");
		profileNameField.setFont(new Font("Dialog", Font.BOLD, 18));
		profileNameField.setBounds(275, 100, 269, 23);
		ShowProfile.add(profileNameField);
		
		JLabel profileEmail = new JLabel("Email");
		profileEmail.setFont(new Font("Dialog", Font.PLAIN, 16));
		profileEmail.setBounds(116, 158, 112, 23);
		ShowProfile.add(profileEmail);
		
		JLabel profileMailField = new JLabel("");
		profileMailField.setFont(new Font("Dialog", Font.BOLD, 16));
		profileMailField.setBounds(275, 158, 269, 23);
		ShowProfile.add(profileMailField);
		
		JLabel profileAddress = new JLabel("Address");
		profileAddress.setFont(new Font("Dialog", Font.PLAIN, 16));
		profileAddress.setBounds(116, 217, 112, 23);
		ShowProfile.add(profileAddress);
		
		JLabel profileAddressField = new JLabel("");
		profileAddressField.setFont(new Font("Dialog", Font.BOLD, 16));
		profileAddressField.setBounds(275, 217, 269, 23);
		ShowProfile.add(profileAddressField);
		
		JLabel profileDOB = new JLabel("D.O.B");
		profileDOB.setFont(new Font("Dialog", Font.PLAIN, 16));
		profileDOB.setBounds(116, 283, 112, 23);
		ShowProfile.add(profileDOB);
		
		JLabel profileDOBField = new JLabel("");
		profileDOBField.setFont(new Font("Dialog", Font.BOLD, 16));
		profileDOBField.setBounds(275, 283, 269, 23);
		ShowProfile.add(profileDOBField);
		
		JLabel profileRegisterDate = new JLabel("Register Date");
		profileRegisterDate.setFont(new Font("Dialog", Font.PLAIN, 16));
		profileRegisterDate.setBounds(116, 350, 112, 23);
		ShowProfile.add(profileRegisterDate);
		
		JLabel profileRegisterDateField = new JLabel("");
		profileRegisterDateField.setFont(new Font("Dialog", Font.BOLD, 16));
		profileRegisterDateField.setBounds(275, 350, 269, 23);
		ShowProfile.add(profileRegisterDateField);
		
		JLabel profilePlan = new JLabel("Plan Type");
		profilePlan.setFont(new Font("Dialog", Font.PLAIN, 16));
		profilePlan.setBounds(116, 417, 112, 23);
		ShowProfile.add(profilePlan);
		
		JLabel profilePlanField = new JLabel("");
		profilePlanField.setFont(new Font("Dialog", Font.BOLD, 16));
		profilePlanField.setBounds(275, 417, 269, 23);
		ShowProfile.add(profilePlanField);
		
		JLabel profileExpiry = new JLabel("Plan Expiry");
		profileExpiry.setFont(new Font("Dialog", Font.PLAIN, 16));
		profileExpiry.setBounds(116, 480, 112, 23);
		ShowProfile.add(profileExpiry);
		
		JLabel profileExpiryField = new JLabel("");
		profileExpiryField.setFont(new Font("Dialog", Font.BOLD, 16));
		profileExpiryField.setBounds(275, 480, 269, 23);
		ShowProfile.add(profileExpiryField);
		
		
		JButton PaySubscription = new JButton("Pay Subscription");
		PaySubscription.setBounds(12, 111, 187, 90);
		leftPanelDashboard.add(PaySubscription);
		
		
		
		JButton topUpWallet = new JButton("Top Up Wallet");
		topUpWallet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(CardLayout, "topUpCard");
			}
		});
		
		
		topUpWallet.setBounds(12, 235, 187, 90);
		leftPanelDashboard.add(topUpWallet);
		
		JButton changePlan = new JButton("Change Plan");
		changePlan.setBounds(12, 359, 187, 90);
		leftPanelDashboard.add(changePlan);
		
		JToggleButton showProfile = new JToggleButton("Show Profile");
		showProfile.setBounds(12, 477, 187, 90);
		leftPanelDashboard.add(showProfile);
		
		JLabel currBalanceLabel = new JLabel("Current Balance");
		currBalanceLabel.setBounds(50, 12, 119, 15);
		leftPanelDashboard.add(currBalanceLabel);
		
		JPanel BalancePanel = new JPanel();
		BalancePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		BalancePanel.setBackground(new Color(246, 245, 244));
		BalancePanel.setBounds(35, 40, 136, 33);
		leftPanelDashboard.add(BalancePanel);
		BalancePanel.setLayout(null);
		
		JLabel balanceText = new JLabel(String.valueOf(loggedInUser.getBalance()));
		balanceText.setBounds(0, 0, 136, 33);
		BalancePanel.add(balanceText);
		balanceText.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel rightPanelDashboard = new JPanel();
		rightPanelDashboard.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		rightPanelDashboard.setBounds(886, 107, 221, 616);
		contentPane.add(rightPanelDashboard);
		rightPanelDashboard.setLayout(null);
		
		JButton logoutButton = new JButton("LOGOUT");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				loggedInUser = null;
				Login loginWindow = new Login();
				loginWindow.setVisible(true);
			}
		});
		logoutButton.setBounds(31, 105, 166, 90);
		rightPanelDashboard.add(logoutButton);
		
		JButton changeMail = new JButton("Change Email");
		changeMail.setBounds(31, 229, 166, 90);
		rightPanelDashboard.add(changeMail);
		
		JButton changePassword = new JButton("Change Password");
		changePassword.setBounds(31, 359, 166, 90);
		rightPanelDashboard.add(changePassword);
		
		JButton deleteAccount = new JButton("Delete Account");
		deleteAccount.setBounds(31, 495, 166, 90);
		rightPanelDashboard.add(deleteAccount);
		
		JPanel ExpiryDatePanel = new JPanel();
		ExpiryDatePanel.setLayout(null);
		ExpiryDatePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		ExpiryDatePanel.setBackground(new Color(246, 245, 244));
		ExpiryDatePanel.setBounds(45, 39, 136, 33);
		rightPanelDashboard.add(ExpiryDatePanel);

		JLabel expiryDate = new JLabel(loggedInUser.getExpiryDate().toString());
		expiryDate.setBounds(0, 0, 136, 33);
		ExpiryDatePanel.add(expiryDate);
		expiryDate.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JLabel expiryDateLabel = new JLabel("   Plan Expiry Date");
		if(loggedInUser.getExpiryDate().isBefore(LocalDate.now()))
		{
			JOptionPane.showMessageDialog(null, "Your Plan has Expired! Please Recharge!",null,JOptionPane.ERROR_MESSAGE);
			expiryDate.setForeground(new Color(237, 51, 59));
			expiryDateLabel.setForeground(new Color(237, 51, 59));
		}
		
		expiryDateLabel.setBounds(58, 10, 136, 15);
		rightPanelDashboard.add(expiryDateLabel);
		
				
		PaySubscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to Pay the Amount "+loggedInUser.getPlan().getCost());
				if(i==0)
				{
					try {
						validatePaySubscription();
						balanceText.setText(String.valueOf(loggedInUser.getBalance()));
						expiryDate.setText(loggedInUser.getExpiryDate().toString());
						expiryDate.setForeground(new Color(51, 51, 51));
						expiryDateLabel.setForeground(new Color(51, 51, 51));
						
					} catch (Exception errMsg) {
						JOptionPane.showMessageDialog(null, errMsg.getMessage());
					}
				}
				
				
			}
		});

	
		topUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				
					if(topUpField.getText().isEmpty() || topUpField.getText().isBlank())
						throw new CustomerCustomExceptions("Please Enter an Amount First!");
					
				loggedInUser.setBalance(loggedInUser.getBalance()+Double.parseDouble(topUpField.getText()));
				JOptionPane.showMessageDialog(null, "Top Up Done!");
				cardlayout.show(CardLayout, "nullCard");
				balanceText.setText(String.valueOf(loggedInUser.getBalance()));
				loadToFile();
				
				} catch (CustomerCustomExceptions e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		changePlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(CardLayout, "changePlanCard");
			}
		});
		
		
		changePlanSubmitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String planString = radioDiamond.isSelected() ? "DIAMOND" : radioGold.isSelected() ? "GOLD" : radioPlatinum.isSelected() ? "PLATINUM" : radioSilver.isSelected() ? "SILVER" : "";
				try {
					if(loggedInUser.getPlan().name().equals(planString))
						throw new CustomerCustomExceptions("Selected Plan is Already Active!");
					
					int choice = JOptionPane.showConfirmDialog(null, "Sure want to Change Plan?");
					
					if(choice==0)
						validateChangePlan(ServicePlan.valueOf(planString));
	
					cardlayout.show(CardLayout, "nullCard");
					balanceText.setText(String.valueOf(loggedInUser.getBalance()));
					expiryDate.setText(loggedInUser.getExpiryDate().toString());
					
				} catch (CustomerCustomExceptions errMsg) {
					JOptionPane.showMessageDialog(null,errMsg.getMessage(),null,JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		changePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(CardLayout, "changePasswordCard");
			}
		});
		
		

		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					validateChangePassword(String.copyValueOf(passwordField.getPassword()),String.copyValueOf(passwordField_1.getPassword()),String.copyValueOf(passwordField_2.getPassword()));
					cardlayout.show(CardLayout, "nullCard");
				}catch (CustomerCustomExceptions errMsg) {
					JOptionPane.showMessageDialog(null, errMsg.getMessage(), null, JOptionPane.ERROR_MESSAGE);
				}catch (LoginExceptions errMsg1) {
					JOptionPane.showMessageDialog(null, errMsg1.getMessage(), null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		

		showProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(showProfile.isSelected()) {
				cardlayout.show(CardLayout,"showProfile");
				profileNameField.setText(loggedInUser.getName());
				profileMailField.setText(loggedInUser.getEmail());
				profileAddressField.setText(loggedInUser.getCity());
				profileDOBField.setText(loggedInUser.getDobDate().toString());
				profileRegisterDateField.setText(loggedInUser.getRegisterDate().toString());
				profilePlanField.setText(loggedInUser.getPlan().name());
				profileExpiryField.setText(loggedInUser.getExpiryDate().toString());
			}
			else {				
				cardlayout.show(CardLayout,"nullCard");
			}

			}
			
		});
		
		
		//TABLE

		
	}
}
