package org.usfirst.frc.team1160.robot;

import org.usfirst.frc.team1160.robot.commands.auto.Cheval;
import org.usfirst.frc.team1160.robot.commands.auto.Drawbridge;
import org.usfirst.frc.team1160.robot.commands.auto.LowBar;
import org.usfirst.frc.team1160.robot.commands.auto.Moat;
import org.usfirst.frc.team1160.robot.commands.auto.Portcullis;
import org.usfirst.frc.team1160.robot.commands.auto.Ramparts;
import org.usfirst.frc.team1160.robot.commands.auto.Rock;
import org.usfirst.frc.team1160.robot.commands.auto.Rough;
import org.usfirst.frc.team1160.robot.commands.auto.Sallyport;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class AutoSelection implements RobotMap {

	boolean[] on;
	int[] flipped = { 0, 0 };
	int position;
	
	public AutoSelection(Joystick input) {
		on = new boolean[input.getButtonCount()];

		for (int count = 0; count < input.getButtonCount(); count++) {
			on[count] = input.getRawButton(count);
			if (flipped[0] == 0 && on[count]) {
				flipped[0] = count;
			} else if (on[count]) {
				flipped[1] = count;
			}
		}
	}

	public void picker() {
		
		
			switch(flipped[0]){
			
			case s6:
				position = 3;
			case s7:
				position = 4;
			case s8:
				position = 5;
			default:
				position = 2;
			}
		
		if (on[s9]) {
			switch (flipped[0]) {
			case s0:
				new LowBar();
			case s1: 
				new Portcullis();
			case s2:
				new Ramparts();
			case s3:
				new Drawbridge();
			case s4:
				new Rock();
			}
		} else {
			switch (flipped[0]) {
			case s0:
				new LowBar();
			case s1:
				new Cheval();
			case s2:
				new Moat();
			case s3:
				new Sallyport();
			case s4:
				new Rough();
			}
		}
	}

}
