package com.revature.beans;

public class Engine{
	boolean running;
	
	public Engine (boolean running) {
		if (running == true){
			System.out.println("The car is running");
		}
		else {
			System.out.println("The car is dead");
		};
	};
}
