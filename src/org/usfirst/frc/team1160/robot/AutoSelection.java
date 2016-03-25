package org.usfirst.frc.team1160.robot;

import org.usfirst.frc.team1160.robot.commands.auto.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoSelection implements RobotMap {

	boolean[] on;
	int[] flipped = { 0, 0 };
	int[] button;
	boolean turnDirection;
	int position;
	int chosen;
	double rotationTime;
	
	public AutoSelection(Joystick input) {
		on = new boolean[input.getButtonCount()];

		for (int count = 1; count < input.getButtonCount(); count++) {
			on[count] = input.getRawButton(count);
			if (flipped[0] == 0 && on[count]) {
				flipped[0] = count;
			} else if (on[count]) {
				flipped[1] = count;
			}
		}
	}
	
	public Command selection(){
		
		switch(flipped[0]){
		case s0:
			SmartDashboard.putString("Auto Selected: ", "Lowbar");
			return new Lowbar();
		case s1:
			SmartDashboard.putString("Auto Selected: ", "Cheval");
			return new Cheval();
		case s2:
			SmartDashboard.putString("Auto Selected: ", "UnevenTerrain");
			return new UnevenTerrain();
		case s3:
			SmartDashboard.putString("Auto Selected: ", "Portcullis");
			return new Portcullis();
		}
		
		SmartDashboard.putString("Auto Selected: ", "No auto");
		return null;
	}

}
