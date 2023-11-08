package com.app.utils;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.app.customExceptions.LoginExceptions;
import com.app.gui.Login;

public class Authenticator extends Login {
	static Login loginObj = new Login();

	public static void checkCreds(String login, String pass) {

		if (login.isEmpty() || pass.isEmpty()) {
			JOptionPane.showMessageDialog(loginObj.contentPane, "Username/Password Must not be Empty!", "",
					JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				if (!login.matches("^[\\w.+\\-]+@gmail\\.com$"))
					throw new LoginExceptions("Username Must Contain @gmail.com");
				if (!pass.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{3,}$"))
					throw new LoginExceptions("Password Must contain Lower,Upper,Numeric and a Special Character");
			} catch (LoginExceptions msg) {
				JOptionPane.showMessageDialog(loginObj.contentPane, msg.getMessage(), "", JOptionPane.ERROR_MESSAGE);
			}

		}
	}

	public static void matchCreds(String login, String pass) {

		try (BufferedReader bw = new BufferedReader(new FileReader("UserCredentials.txt"))) {

			String s = "";
			while ((s = bw.readLine()) != null) {
				String[] data = s.split(",");
				if (login.equals(data[0]) && pass.equals(data[1]))
					break;
			}
//			JOptionPane.showInternalMessageDialog(loginObj.contentPane, "Logged In", "", JOptionPane.OK_OPTION);
			bw.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
