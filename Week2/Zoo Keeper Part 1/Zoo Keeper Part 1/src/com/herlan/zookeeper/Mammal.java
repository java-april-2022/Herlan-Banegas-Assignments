package com.herlan.zookeeper;

public class Mammal {
	public int displayEnergy = 100;
	
	public Mammal() {
		super();
	}
	
	public int energyLevel() {
		System.out.printf("Energy Level: %s\n" , getDisplayEnergy());
		return getDisplayEnergy();
	}
	
	public int getDisplayEnergy() {
		return displayEnergy;
	}
	
	public void setDisplayEnergy(int displayEnergy) {
		this.displayEnergy = displayEnergy;
	}
}
