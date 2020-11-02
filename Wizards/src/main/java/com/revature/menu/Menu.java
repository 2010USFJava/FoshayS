package com.revature.menu;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.Wizards;
import com.revature.util.Coven;
import com.revature.util.Log;

public class Menu {
	static Scanner sc = new Scanner(System.in);
	
	public static void startMenu() {
		System.out.println("Become a Wizard!");
		System.out.println("\t[m]ake a new wizard");
		System.out.println("\t[d]isplay a wizard");
		System.out.println("\t[l]eave wizard creation");
		
		String option = sc.nextLine();
		
		switch(option.toLowerCase()) {
		case "m":
			makeAWiz();
			break;
		case "d":
			displayAWiz();
			break;
		case "l":
			System.out.println("You are now leaving the coven");
			break;
		default:
			System.out.println("What? Please choose another option");
			startMenu();
			break;
		}	
	}
	
	public static void makeAWiz() {
		String wizardClass = null;
		Boolean beardChoice = null;
		ArrayList<String> wizClass = new ArrayList<String>();
		wizClass.add("[d]ruid");
		wizClass.add("[w]arlock");
		wizClass.add("[n]ecromancer");
		wizClass.add("[s]orcerer");
		System.out.println("Make Your Wizard!");
		System.out.println("Name Your Wizard!");
		String wizName = sc.nextLine();
		System.out.println("Choose Your Wizards Class!");
		for(String x : wizClass) {
			System.out.println(x);
		};
		String chooseClass = sc.nextLine();
		if(chooseClass.equalsIgnoreCase("d")) {
			wizardClass = "Druid";
		}
		else if(chooseClass.equalsIgnoreCase("w")) {
			wizardClass = "Warlock";
		}
		else if(chooseClass.equalsIgnoreCase("n")) {
			wizardClass = "Necromancer";
		}
		else if(chooseClass.equalsIgnoreCase("s")) {
			wizardClass = "Sorcerer";
		}
		else {
			System.out.println("What? That's not an option. Redirecting to Main Menu.");
			startMenu();
		}
		System.out.println("Please enter your Wizard's Power Level");
		int wizardPL = Integer.parseInt(sc.nextLine());
		System.out.println("Does your wizard have a beard? (y/n)");
		String wizBeard = sc.nextLine();
		if(wizBeard.equalsIgnoreCase("y")) {
			beardChoice = true;
		}
		else if (wizBeard.equalsIgnoreCase("n")) {
			beardChoice = false;
		}
		else {
			System.out.println("What? That is not a valid option. Redirecting to Main Menu");
			startMenu();
		}
		
		Wizards x = new Wizards(wizName, wizardClass, wizardPL, beardChoice);
		Log.Logging("info", x.getName() + " has risen!");
		System.out.println(Coven.wizardCoven.toString());
		
		System.out.println("Would you like to summon another wizard? (y/n)");
		String newWiz = sc.nextLine();
		if(newWiz.equalsIgnoreCase("y")) {
			makeAWiz();
		}
		else if (newWiz.equalsIgnoreCase("n")){
			startMenu();
		}
		else {
			System.out.println("What? That's not valid input. Redirecting to Main Menu.");
			startMenu();
		}
	}
	
	public static void displayAWiz() {
		System.out.println("Which wizard would you like to display?");
		String wizard = sc.nextLine();
		Wizards y = Coven.selectWizard(wizard);
		System.out.println("This is the glorious wizard you selected!");
		System.out.println(y.getName() + " has appeared. They are a " + y.getWizardClass() + " and their power level is " + y.getPowerLevel() + ".");
		if(y.isBeard() == true) {
			System.out.println("They have a beard.");
		}
		else if (y.isBeard() == false) {
			System.out.println("They do not have a beard");
		}
		else {
			System.out.println("This wizard is glitching. Somehow they were not created correctly");
		}
		
		System.out.println("Would you like to party with another wizard? (y/n)");
		String moreWiz = sc.nextLine();
		if(moreWiz.equalsIgnoreCase("y")) {
			displayAWiz();
		}
		else if (moreWiz.equalsIgnoreCase("n")){
			startMenu();
		}
		else {
			System.out.println("What? That's not valid input. Redirecting to Main Menu.");
			startMenu();
		}
	}
	

}
