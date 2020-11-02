package com.revature.driver;

import com.revature.menu.Menu;
import com.revature.util.File;

public class Driver {
	static{File.summonWizards();}
	public static void main(String[] args) {
		Menu.startMenu();
	}

}
