package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Wizards;

public class File {
	public static final String wizardFile="wizards.txt";
	
	public static void storeWizards(List<Wizards> wizList) {
		try {
			ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(wizardFile));
			objOut.writeObject(wizList);
			objOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void summonWizards() {
		try {
			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(wizardFile));
			Coven.wizardCoven = (ArrayList<Wizards>)objIn.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
