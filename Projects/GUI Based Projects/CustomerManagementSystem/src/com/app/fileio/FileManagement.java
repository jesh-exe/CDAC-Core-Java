package com.app.fileio;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import com.app.core.Customer;

import static com.app.tester.Tester.*;

public class FileManagement {

	public static void loadtoList() {
		try {

			File file = new File("UsersData.ser");

			if (file.createNewFile())
			{
				usersList =  new ArrayList<>();
				return;
			}

			
			try (ObjectInputStream ob = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream("UsersData.ser")))) {

				usersList = ((ArrayList<Customer>) ob.readObject());
			}

		} catch (Exception d) {
			// TODO: handle exception
		}
	}

	public static void loadToFile() {
		try (ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("UsersData.ser"))) {
//			usersList.stream().forEach(l -> pw.println(l.getId()+":"+l.getName()+":"+l.getEmail()+":"+l.getPasssword()+":"+l.getCity()+":"+l.getBalance()+":"+l.getDobDate()+":"+l.getRegisterDate()+":"+l.getSubsDate()+":"+l.getPlan().name()));
			ob.writeObject(usersList);
		} catch (Exception e) {

		}
	}



}
