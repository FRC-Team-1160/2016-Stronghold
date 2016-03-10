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
	boolean turnDirection;
	int position;
	double rotationTime;
	
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
		
		
			switch(flipped[1]){
			
			case s6:
				position = 3;
				rotationTime = C_TIME;
			case s7:
				position = 4;
				rotationTime = D_TIME;
			case s8:
				position = 5;
				rotationTime = E_TIME;
			default:
				position = 2;
				rotationTime = B_TIME;
			}
			
		//If the robot is on the right side of the field, the robot will turn left
		//If it is on the left, it will turn right.
		if(position>=3){
			turnDirection = true;
		}
		else{
			turnDirection = false;
		}
		
		if (on[s9]) {
			switch (flipped[0]) {
			case s0:
				new LowBar();
			case s1: 
				new Portcullis(rotationTime, turnDirection);
			case s2:
				new Ramparts(rotationTime, turnDirection);
			case s3:
				new Drawbridge(rotationTime, turnDirection);
			case s4:
				new Rock(rotationTime, turnDirection);
			}
		} else {
			switch (flipped[0]) {
			case s0:
				new LowBar();
			case s1:
				new Cheval(rotationTime, turnDirection);
			case s2:
				new Moat(rotationTime, turnDirection);
			case s3:
				new Sallyport(rotationTime, turnDirection);
			case s4:
				new Rough(rotationTime, turnDirection);
			}
		}
	}

}
