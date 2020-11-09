package com.revature.driver;

import com.revature.menu.MainMenu;
import com.revature.util.File;

public class Driver {
	static {File.readCust();}
	static {File.readEmp();}
	static {File.readAdmin();}
	static {File.readAcct();}
	static {File.readPending();}
	public static void main(String[] args) {
		
		MainMenu.startMenu();
		
	}

}
