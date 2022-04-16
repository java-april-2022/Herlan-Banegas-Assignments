package com.herlan.zookeeper;

public class Gorilla extends Mammal {
	
	public Gorilla(int displayEnergy) {
		super();
	}
	
	public Gorilla() {
		super();
	}
	
	public void throwSomething() {
		System.out.println("Tommy threw a rock !");
		displayEnergy -= 5;
		System.out.println(displayEnergy);
		
	}
	
	public void eatBananas() {
		System.out.println("Tommy ate a banana yummm");
		displayEnergy += 10;
		System.out.println(displayEnergy);
	}
	
	public void climb() {
		System.out.println("Tommy  climbed a Big Tree");
		displayEnergy -= 10;
		System.out.println(displayEnergy);
	}
}
