package com.herlan.zookeeper2;

public class Bat extends Mammal {
	public Bat(int displayEnergy) {
	}
	
	public Bat() {
		super();
		displayEnergy = 300;
	}
	
	public void fly() {
		System.out.println("fllllppppppppp");
		displayEnergy -= 50;
		System.out.println(displayEnergy);
	}
	
	public void eatHumans() {
		displayEnergy += 25;
		System.out.println(displayEnergy);
	}
	
	public void attackTown() {
		System.out.println("**firefighters sirens**");
		displayEnergy -= 100;
		System.out.println(displayEnergy);
	}
}
