package com.revature.beans;

import java.io.Serializable;

import com.revature.util.Coven;
import com.revature.util.File;
import com.revature.util.Log;

public class Wizards implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6441758607783965501L;
	
	private String name;
	private String wizardClass;
	private int powerLevel;
	private boolean beard;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWizardClass() {
		return wizardClass;
	}
	public void setWizardClass(String wizardClass) {
		this.wizardClass = wizardClass;
	}
	public int getPowerLevel() {
		return powerLevel;
	}
	public void setPowerLevel(int powerLevel) {
		this.powerLevel = powerLevel;
	}
	public boolean isBeard() {
		return beard;
	}
	public void setBeard(boolean beard) {
		this.beard = beard;
	}
	
	public Wizards(String name, String wizardClass, int powerLevel, boolean beard) {
		super();
		this.name = name;
		this.wizardClass = wizardClass;
		this.powerLevel = powerLevel;
		this.beard = beard;
		Coven.wizardCoven.add(this);
		File.storeWizards(Coven.wizardCoven);
		Log.Logging("info", "A new wizard " + this.getName() +  ", has been forged from the ether!");
	}
	
	public Wizards() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Wizards [name=" + name + ", wizardClass=" + wizardClass + ", powerLevel=" + powerLevel + ", beard="
				+ beard + "]";
	}
	
	

}
