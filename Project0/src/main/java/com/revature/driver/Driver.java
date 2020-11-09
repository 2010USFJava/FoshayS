package com.revature.driver;

import com.revature.menu.MainMenu;
import com.revature.util.File;

public class Driver {
	static {File.readCust();}
	public static void main(String[] args) {
		
		MainMenu.startMenu();
		
	}

}
