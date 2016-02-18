package org.usfirst.frc.team1160.robot;

import java.util.Random;

public class DeployConfirm {
	
	private String select[] = new String[9];
	Random rand = new Random();
	
	public DeployConfirm(){
		select[0] = "I am certified.";
		select[1] = "Certified BEAST.";
		select[2] = "That's a waste of a perfectly good!!!";
		select[3] = "Whales can't breathe underwater..?";
		select[4] = "Was America alive during WWII?";
		select[5] = "Are you certified to be reading this?";
		select[6] = "Error: 2147483647";
		select[7] = "Error: 404 Could not find the codes";
		select[8] = "Chips Ahoy!";
		
		System.out.println(select[rand.nextInt(select.length)] + " " + System.currentTimeMillis() % 8);
	}
	
}
