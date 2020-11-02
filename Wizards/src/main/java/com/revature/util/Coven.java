package com.revature.util;

import java.util.ArrayList;

import com.revature.beans.Wizards;
import com.revature.menu.Menu;

public class Coven {
	public static ArrayList<Wizards> wizardCoven = new ArrayList<Wizards>();
	
	public static Wizards selectWizard(String inputName) {
		for (int i = 0; i< wizardCoven.size(); i++) {
			String name = wizardCoven.get(i).getName();
			if(inputName.equals(name)) {
				return wizardCoven.get(i);
			}
		}
		System.out.println("This Wizard does not exist.");
		Menu.startMenu();
		return null;
	}

}
